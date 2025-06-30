import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String VIN;
    private final String model;
    private final String manufacturer;
    private final int year;
    private final int mileage;   // км
    private final double price;  // USD

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this.VIN = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getVIN() { return VIN; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }

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