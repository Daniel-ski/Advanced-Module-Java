package DefiningClasses_Exercise.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccountsData = new HashMap<>();

        BiFunction<BankAccount,String,String> depositFunction = (b,s) -> {
            int amount = Integer.parseInt(s);
            b.deposit(amount);
            return "Deposited " + amount + " to ID"+ b.getId();
        };

        BiFunction<BankAccount,String,String> getInterestFunction = (b,s) -> {
            int years = Integer.parseInt(s);
            double interest = b.getInterest(years);
            return String.format("%.2f",interest);
        };

        while (!input.equals("End")){
            String[] command = input.split("\\s+");

            if (command[0].equals("Create")){
                BankAccount bankAccount = new BankAccount();
                bankAccountsData.put(bankAccount.getId(),bankAccount);
                System.out.println("Account " + "ID"+ bankAccount.getId() + " created");

            } else if (command[0].equals("Deposit")) {
                String output = executeOnBankAccount(command,bankAccountsData,depositFunction);
                System.out.println(output);

            } else if (command[0].equals("GetInterest")) {
                String output = executeOnBankAccount(command,bankAccountsData,getInterestFunction);
                System.out.println(output);

            } else if (command[0].equals("SetInterest")) {
                double interest = Double.parseDouble(command[1]);
                BankAccount.setInterestRate(interest);
            }

            input = scanner.nextLine();
        }
    }

    public static String executeOnBankAccount(String[] command, Map<Integer,BankAccount> bankAccounts,
                                              BiFunction<BankAccount,String,String> function){

        int id = Integer.parseInt(command[1]);
        BankAccount bankAccount = bankAccounts.get(id);

        if (bankAccount == null){
            return  "Account does not exist";

        }
        return function.apply(bankAccount,command[2]);
    }
}
