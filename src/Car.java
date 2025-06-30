import java.util.Objects;

public class Car implements Comparable<Car> {
    private String VIN;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.VIN = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVIN() { return VIN; }
    public void setVIN(String VIN) {this.VIN = VIN; }
    public String getModel() { return model; }
    public void setModel(String model) {this.model = model; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer; }
    public int getYear() { return year; }
    public void setYear(int year) {this.year = year; }
    public int getMileage() { return mileage; }
    public void  setMileage(int mileage) {this.mileage = mileage; }
    public double getPrice() { return price; }
    public void  setPrice(double price) {this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(VIN, car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }

    @Override
    public String toString() {
        return String.format("VIN: %s | %s %s | Год: %d | Пробег: %,d км | Цена: $%.2f",
                VIN, manufacturer, model, year, mileage, price);
    }
}