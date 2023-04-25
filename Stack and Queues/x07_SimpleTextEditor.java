package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class x07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> textDataStack = new ArrayDeque<>();
        int appendOperationLength = 0;
        String textToErases = "";

        for (int commandCount = 1; commandCount <= numberOfOperations ; commandCount++) {
            String inputCommand = scanner.nextLine();
            String currentCommand = inputCommand.split("\\s+")[0];


            switch (currentCommand){
                case "1" :
                    textDataStack.push(text.toString());
                    String currentText = inputCommand.split("\\s+")[1];
                    appendOperationLength = currentText.length();
                    text.append(currentText);
                    break;
                case "2":
                    textDataStack.push(text.toString());
                    int countCharErases = Integer.parseInt(inputCommand.split("\\s+")[1]);
                    textToErases = text.substring(text.length() - countCharErases,text.length());
                    text.delete(text.length() - countCharErases,text.length());
                    break;
                case "3":
                    int indexCharReturn = Integer.parseInt(inputCommand.split("\\s+")[1]);
                    char charToPrint = text.charAt(indexCharReturn-1);
                    System.out.println(charToPrint);
                    break;
                case "4":
                    if (!textDataStack.isEmpty()) {
                        String lastText = textDataStack.pop();
                        text = new StringBuilder(lastText);
                    }

            }

        }
    }
}
