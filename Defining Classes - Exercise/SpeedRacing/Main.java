package DefiningClasses_Exercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Car> carsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            int carFuelAmount = Integer.parseInt(carData[1]);
            double carFuelCostFor1km = Double.parseDouble(carData[2]);

            Car car = new Car(carModel,carFuelAmount,carFuelCostFor1km);

            carsMap.put(carModel,car);
        }
        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("End")){
            String[] command = inputCommand.split("\\s+");
            String carModel = command[1];
            int amountOfKm = Integer.parseInt(command[2]);

            Car carToDrive = carsMap.get(carModel);

            carToDrive.drive(amountOfKm);

            inputCommand = scanner.nextLine();
        }

        carsMap.values().forEach(System.out::println);
    }
}
