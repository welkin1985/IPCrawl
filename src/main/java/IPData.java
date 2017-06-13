/**
 *
 */
public class IPData {

    private String country = "unknown";
    private String country_id = "unknown";
    private String area = "unknown";
    private String area_id = "unknown";
    private String region = "unknown";
    private String region_id = "unknown";
    private String city = "unknown";
    private String city_id = "unknown";
    private String county = "unknown";
    private String county_id = "unknown";
    private String isp = "unknown";
    private String isp_id = "unknown";
    private String ip = "unknown";

    public IPData() {
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {

        this.country = "".equals(country) ? "unknown" : country;

    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {

        this.country_id = "".equals(country_id) ? "unknown" : country_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {

        this.area = "".equals(area) ? "unknown" : area;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = "".equals(area_id) ? "unknown" : area_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = "".equals(region) ? "unknown" : region;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = "".equals(region_id) ? "unknown" : region_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = "".equals(city) ? "unknown" : city;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = "".equals(city_id) ? "unknown" : city_id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = "".equals(county) ? "unknown" : county;
    }

    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = "".equals(county_id) ? "unknown" : county_id;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = "".equals(isp) ? "unknown" : isp;
    }

    public String getIsp_id() {
        return isp_id;
    }

    public void setIsp_id(String isp_id) {
        this.isp_id = "".equals(isp_id) ? "unknown" : isp_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = "".equals(ip) ? "unknown" : ip;
    }

    @Override
    public String toString() {

        return
                ip+"\t"+
                country + "\t" +
                area + "\t" +
                region + "\t" +
                city + "\t" +
                county + "\t" +
                isp + "\t";


    }
}
