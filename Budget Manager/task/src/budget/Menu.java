package budget;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        BudgetAccount currentBudgetAccount = new BudgetAccount();
        boolean isMenuWorking = true;
        while (isMenuWorking) {
            showStartScreen();
            String inputStr = scanner.next();
            System.out.println();
            switch (inputStr) {
                case "1":
                    System.out.println("Enter income:");
                    double income = scanner.nextDouble();
                    currentBudgetAccount.addIncome(income);
                    System.out.println("Income was added!");
                    break;
                case "2":
                    System.out.println("Enter purchase name:");
                    String purchaseName = scanner.nextLine();
                    if (purchaseName.isEmpty()) {
                        purchaseName = scanner.nextLine();
                    }
                    System.out.println("Enter its price:");
                    double purchasePrice = scanner.nextDouble();
                    currentBudgetAccount.addPurchase(purchaseName, purchasePrice);
                    System.out.println("Purchase was added!");
                    break;
                case "3":
                    currentBudgetAccount.showListPurchases();
                    break;
                case "4":
                    currentBudgetAccount.showBalance();
                    break;
                case "0":
                    System.out.println("Bye!");
                    isMenuWorking = false;
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
            System.out.println();
        }
    }

    private static void showStartScreen() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }
}
