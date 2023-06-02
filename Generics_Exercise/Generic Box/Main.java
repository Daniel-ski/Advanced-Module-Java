package Generics_Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 1; i <= n ; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }
        System.out.println(box);
    }
}
