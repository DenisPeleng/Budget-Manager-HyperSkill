package budget;

import java.util.ArrayList;
import java.util.HashMap;

public class BudgetAccount {
    private double balance;
    private final HashMap<Integer, ArrayList<String>> categoryPurchasesMap = new HashMap<>();
    private final HashMap<String, Double> purchasesWithPrice = new HashMap<>();
    private final HashMap<Integer, String> categoryNames = new HashMap<>();

    public BudgetAccount() {
        this.balance = 0.0;
        categoryPurchasesMap.put(1, new ArrayList<>());
        categoryPurchasesMap.put(2, new ArrayList<>());
        categoryPurchasesMap.put(3, new ArrayList<>());
        categoryPurchasesMap.put(4, new ArrayList<>());
        categoryPurchasesMap.put(5, new ArrayList<>());
        categoryNames.put(1, "Food");
        categoryNames.put(2, "Clothes");
        categoryNames.put(3, "Entertainment");
        categoryNames.put(4, "Other");
        categoryNames.put(5, "All");

    }

    protected void addIncome(double income) {
        balance = balance + income;
    }

    protected void showBalance() {
        System.out.println("Balance: $" + balance);
    }

    protected void addPurchase(int categoryNumber, String name, double price) {

        ArrayList<String> currentCategoryList = categoryPurchasesMap.get(categoryNumber);
        String currentPurchase = name + " $" + price;
        currentCategoryList.add(currentPurchase);
        purchasesWithPrice.put(currentPurchase, price);
        categoryPurchasesMap.get(5).add(name + " $" + price);
        balance = balance - price;
    }

    protected void showListPurchases(int categoryNumber) {
        ArrayList<String> currentCategoryList = categoryPurchasesMap.get(categoryNumber);
        System.out.println(getCategoryName(categoryNumber) + ":");
        if (currentCategoryList.isEmpty()) {
            System.out.println("The purchase list is empty");
            return;
        }
        double totalSumPurchases = 0;
        for (String purchase : currentCategoryList
        ) {
            System.out.println(purchase);
            totalSumPurchases = totalSumPurchases + purchasesWithPrice.get(purchase);
        }
        System.out.println("Total sum: $" + totalSumPurchases);
    }

    private String getCategoryName(int categoryNumber) {
        return categoryNames.get(categoryNumber);
    }

    protected boolean isPurchasesListEmpty() {
        return categoryPurchasesMap.get(5).isEmpty();
    }

}
