/**
 *
 */
public class IPBean {
    private String code = "0" ;
    private IPData data = new IPData();


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = "0";
    }

    public IPData getData() {
        return data;
    }

    public void setData(IPData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
