import java.util.Objects;

public class Laptop {
    private String serial;
    private double price;
    private String model;
    private String brand;

    public Laptop(String serial, double price, String model, String brand) {
        this.serial = serial;
        this.price = price;
        this.model = model;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return serial.equals(laptop.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial);
    }
}
