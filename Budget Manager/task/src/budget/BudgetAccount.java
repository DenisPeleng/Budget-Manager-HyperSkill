package budget;

import java.util.ArrayList;

public class BudgetAccount {
    private final ArrayList<String> listOfPurchases = new ArrayList<>();
    private double totalSumPurchases = 0.0;
    private double balance = 0.0;

    protected void addIncome(double income) {
        balance = balance + income;
    }

    protected void showBalance() {
        System.out.println("Balance: $" + balance);
    }

    protected void addPurchase(String name, double price) {
        listOfPurchases.add(name + " $" + price);
        totalSumPurchases = totalSumPurchases + price;
        balance = balance - price;
    }

    protected void showListPurchases() {
        if (listOfPurchases.isEmpty()) {
            System.out.println("The purchase list is empty");
            return;
        }
        for (String purchase : listOfPurchases
        ) {
            System.out.println(purchase);
        }
        System.out.println("Total sum: $" + totalSumPurchases);
    }
}
