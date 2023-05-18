package DefiningClasses_Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPerson = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= countOfPerson ; i++) {
            String[] dataForPerson = scanner.nextLine().split("\\s+");

            Person newPerson = new Person(dataForPerson[0],Integer.parseInt(dataForPerson[1]));
            personList.add(newPerson);
        }

        personList.stream()
                .filter( person -> person.getAge() > 30)
                .sorted((left,right) -> left.getName().compareTo(right.getName()))
                .forEach(System.out::println);
    }
}
