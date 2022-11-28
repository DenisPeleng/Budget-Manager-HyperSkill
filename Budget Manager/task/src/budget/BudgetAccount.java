package budget;

import java.util.ArrayList;
import java.util.HashMap;

public class BudgetAccount {
    private double balance;
    private HashMap<Integer, ArrayList<String>> categoryPurchasesMap = new HashMap<>();
    private HashMap<String, Double> purchasesWithPrice = new HashMap<>();

    public HashMap<Integer, String> getCategoryNames() {
        return categoryNames;
    }

    private final HashMap<Integer, String> categoryNames = new HashMap<>();

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setCategoryPurchasesMap(HashMap<Integer, ArrayList<String>> categoryPurchasesMap) {
        this.categoryPurchasesMap = categoryPurchasesMap;
    }

    protected void setPurchasesWithPrice(HashMap<String, Double> purchasesWithPrice) {
        this.purchasesWithPrice = purchasesWithPrice;
    }

    protected double getBalance() {
        return balance;
    }

    protected HashMap<Integer, ArrayList<String>> getCategoryPurchasesMap() {
        return categoryPurchasesMap;
    }

    protected HashMap<String, Double> getPurchasesWithPrice() {
        return purchasesWithPrice;
    }

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


}
