import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

/**
 *
 */
public class IPCrawl2 {
    public static Logger log = Logger.getLogger(String.valueOf(IPCrawl.class));
    public static String ip = "";
    public static URL url = null;
    public static URLConnection conn = null;
    public static String urlStr = "http://ip.taobao.com/service/getIpInfo.php?ip=%s";
    public static BufferedReader in;
    public static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\IdeaProjects\\IPCrawl\\IPPool2.txt", true), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        int init1 = Integer.valueOf(args[0]);
        int init2 = Integer.valueOf(args[1]);
//        int init1 = 0;
//        int init2 = 0;
        for (int i = init1; i < 256; i++) {
            for (int j = init2; j < 256; j++) {

                String i1 = String.valueOf(i);
                String i2 = String.valueOf(j);
                String i3 = String.valueOf(0);
                String i4 = String.valueOf(0);
                ip = i1 + "." + i2 + "." + i3 + "." + i4;
                String request = String.format(urlStr, ip);

                //System.out.println(request);
                IPBean ipBean = getIPInfo(request, ip);
                String country = ipBean.getData().getCountry();
                if ("unknown".equals(country)) {

                    // System.out.println(ip + "  " + ipBean.getData().getCountry().toString());

                    try {
                        j--;
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if ("香港".equals(country) || "台湾".equals(country) || "澳门".equals(country)) {
                    ipBean.getData().setCountry("中国");
                    ipBean.getData().setArea("港澳台地区");

                    // System.out.println(ipBean.toString());

                    writeFile(ipBean);
                    try {
                        bw.flush();
                    } catch (IOException e) {

                    }
                } else if (!"中国".equals(country) && !"未分配或者内网IP".equals(country)) {

                    // System.out.println(ipBean.toString());

                    writeFile(ipBean);
                    try {
                        bw.flush();
                    } catch (IOException e) {

                    }
                }
            }
            init2 = 0;
        }
        try {
            bw.flush();
            if (bw != null) {
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static IPBean getIPInfo(String request, String ip) {
        IPBean ipBean = new IPBean();
        try {
            url = new URL(request);
            conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString;
            while ((jsonString = in.readLine()) != null) {
                if (jsonString.split(":")[2].equals("\"\"}")) {
                    //System.out.println(jsonString);
                } else {
                    ipBean = JSON.parseObject(jsonString, IPBean.class);
                }

            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return ipBean;
    }

    public static void writeFile(IPBean ipBean) {
        try {

            bw.write(ipBean.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
