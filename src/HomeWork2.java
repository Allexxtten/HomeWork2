import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("1. Массивы (Работа с парком машин)");
        int[] years = new int[50];
        Random rand = new Random();
        for (int i = 0; i < years.length; i++) {
            years[i] = rand.nextInt(2026 - 2000) + 2000;
        }

        System.out.println("Все года выпуска:");
        System.out.println(Arrays.toString(years));

        System.out.println("\nМашины, выпущенные после 2015 года:");
        for (int i = 0; i < years.length; i++) {
            if (years[i] > 2015) {
                System.out.print(years[i] + " ");
            }
        }
        System.out.println();

        int cur = LocalDate.now().getYear();
        int total = 0;
        for (int i = 0; i < years.length; i++) {
            total += (cur - years[i]);
        }
        double average = (double) total / years.length;
        System.out.printf("\nСредний возраст авто: %.2f лет\n", average);

        System.out.println("\n2. Коллекции (Управление моделями)");
        List<String> modelsList = new ArrayList<>(List.of(
                "Toyota Camry", "BMW X5", "Tesla Model 3", "Toyota Camry", "Audi A4",
                "BMW X5", "Volkswagen Golf", "Tesla Model Y", "Ford Focus", "BMW X5"
        ));
        System.out.println("Cписок с дубликатами:" + modelsList);

        Set<String> modelsSet = new TreeSet<>(Comparator.reverseOrder());
        for (String model : modelsList) {
            if (model.contains("Tesla")) {
                modelsSet.add("ELECTRO_CAR");
            } else {
                modelsSet.add(model);
            }
        }
        System.out.println("\nОтсортированный список без дубликатов: " + modelsSet);

        System.out.println("\n3. equals/hashCode (Сравнение автомобилей)");
        Car c1 = new Car("VIN1", "Camry", "Toyota", 2020, 30_000, 25_000);
        Car c2 = new Car("VIN2", "Model 3", "Tesla", 2023, 10_000, 42_000);
        Car c3 = new Car("VIN1", "Camry", "Toyota", 2020, 30_000, 25_000); // дубликат VIN
        Car c4 = new Car("VIN3", "X5", "BMW", 2018, 70_000, 38_000);

        Set<Car> cars = new HashSet<>(List.of(c1, c2, c3, c4));
        System.out.println("Список машин:");
        cars.forEach(System.out::println);

        List<Car> sortedByYearDesc = cars.stream().sorted().toList();
        System.out.println("\nОтсортирован по году выпуска:");
        sortedByYearDesc.forEach(System.out::println);

        System.out.println("\n4. Stream API (Анализ автопарка)");
        List<Car> fleet = List.of(
                new Car("VIN1", "Camry", "Toyota", 2021, 25_000, 28_000),
                new Car("VIN2", "Corolla", "Toyota", 2019, 60_000, 18_000),
                new Car("VIN3", "Model Y", "Tesla", 2022, 15_000, 55_000),
                new Car("VIN4", "X5", "BMW", 2020, 45_000, 48_000),
                new Car("VIN5", "Q7", "Audi", 2023, 8_000, 65_000),
                new Car("VIN6", "A4", "Audi", 2017, 85_000, 20_000),
                new Car("VIN7", "Golf", "Volkswagen", 2018, 40_000, 22_000)
        );

        System.out.println("Машины с пробегом меньше 50 000 км:");
        List<Car> lowMileage = fleet.stream().filter(car -> car.getMileage() < 50_000).toList();
        lowMileage.forEach(System.out::println);

        System.out.println("\nТоп‑3 самых дорогих машин:");
        List<Car> top3Price = fleet.stream().sorted(Comparator.comparingDouble(Car::getPrice).reversed()).limit(3).toList();
        top3Price.forEach(System.out::println);

        double avgMileage = fleet.stream().mapToInt(Car::getMileage).average().orElse(0.0);
        System.out.printf("\nСредний пробег всех машин: %.0f км\n", avgMileage);

        Map<String, List<Car>> byMaker = fleet.stream().collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("\nСгруппировано по производителю:");
        byMaker.forEach((maker, cars1) -> {
            System.out.println(maker + " → " + cars1);
        });
    }
}
