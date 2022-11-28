package budget;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);


    public static void startMainMenu() {
        BudgetAccount currentBudgetAccount = new BudgetAccount();
        boolean isMenuWorking = true;
        while (isMenuWorking) {
            showStartScreen();
            String inputStr = scanner.nextLine();
            System.out.println();
            switch (inputStr) {
                case "1":
                    System.out.println("Enter income:");
                    double income = Double.parseDouble(scanner.nextLine());
                    currentBudgetAccount.addIncome(income);
                    System.out.println("Income was added!");
                    break;
                case "2":
                    startAddPurchasesMenu(currentBudgetAccount);
                    break;
                case "3": {
                    if (currentBudgetAccount.isPurchasesListEmpty()) {
                        System.out.println("The purchase list is empty");
                        break;
                    }
                    startStatPurchasesMenu(currentBudgetAccount);
                }
                break;
                case "4":
                    currentBudgetAccount.showBalance();
                    break;
                case "5":
                    FileWork.saveToFile(currentBudgetAccount);
                    break;
                case "6":
                    FileWork.loadFromFile(currentBudgetAccount);
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
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("0) Exit");
    }

    private static void showAddPurchasesScreen() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");

    }

    private static void showPurchasesStatScreen() {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");

    }

    private static void startAddPurchasesMenu(BudgetAccount budgetAccount) {
        boolean isMenuWorking = true;
        while (isMenuWorking) {
            showAddPurchasesScreen();
            int categoryNumber = Integer.parseInt(scanner.nextLine());
            switch (categoryNumber) {
                case 1, 2, 3, 4: {
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    String purchaseName = scanner.nextLine();
                    if (purchaseName.isEmpty()) {
                        purchaseName = scanner.nextLine();
                    }
                    System.out.println("Enter its price:");
                    double purchasePrice = Double.parseDouble(scanner.nextLine());
                    budgetAccount.addPurchase(categoryNumber, purchaseName, purchasePrice);
                    System.out.println("Purchase was added!");
                    System.out.println();
                    break;
                }

                case 5: {
                    isMenuWorking = false;
                    break;
                }
                default: {
                    System.out.println("Wrong category");
                    System.out.println();
                }
            }

        }

    }

    private static void startStatPurchasesMenu(BudgetAccount budgetAccount) {
        boolean isMenuWorking = true;
        while (isMenuWorking) {
            showPurchasesStatScreen();
            int categoryNumber = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (categoryNumber) {
                case 1, 2, 3, 4, 5: {
                    budgetAccount.showListPurchases(categoryNumber);
                    System.out.println();
                    break;
                }
                case 6: {
                    isMenuWorking = false;
                    break;
                }
                default: {
                    System.out.println("Wrong category");
                }

            }
        }
    }
}
