package FunctionalProgramming_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class x10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {

            names = isFiltration(names, command);

            command = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", names.stream().sorted().collect(Collectors.joining(", ")));
        }
    }

    private static ArrayList<String> isFiltration(ArrayList<String> names, String command) {
        String option = command.split("\\s+")[0];
        String filter = command.split("\\s+")[1];
        String character = command.split("\\s+")[2];
        List<String> filteringName = new ArrayList<>();

        Predicate<String> predicate = null;

        switch (filter) {
            case "StartsWith":
                predicate = name -> name.startsWith(character);
                break;

            case "EndsWith":
                predicate = name -> name.endsWith(character);
                break;

            case "Length":
                predicate = name -> name.length() == Integer.parseInt(character);
                break;

        }
        if (option.equals("Remove")) {
            Predicate<String> finalPredicate = predicate;
            names.forEach(name -> {
                if (finalPredicate.test(name)) {
                    filteringName.add(name);
                }
            });
            names.removeAll(filteringName);

        } else if (option.equals("Double")) {
            Predicate<String> finalPredicate1 = predicate;
            names.forEach(name -> {
                if (finalPredicate1.test(name)) {
                    filteringName.add(name);
                }
            });
            names.addAll(filteringName);
        }
        return names;
    }
}
