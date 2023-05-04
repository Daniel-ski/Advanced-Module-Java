package FunctionalProgramming;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class x03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> word = new ArrayList<>();

        Arrays.stream(text).filter(isUpperCase).forEach(word::add);


        System.out.println(word.size());
        word.forEach(System.out::println);

    }
}
