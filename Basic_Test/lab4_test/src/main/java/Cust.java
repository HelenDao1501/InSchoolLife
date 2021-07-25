public class Cust {
    private long id;
    private String name;
    private String address;
    private String licenseNumber;

    public Cust(long id, String name, String address, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.licenseNumber = licenseNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
