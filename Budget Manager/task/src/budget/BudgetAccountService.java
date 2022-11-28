package budget;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class BudgetAccountService {
    static final DecimalFormat df = new DecimalFormat("#0.00");

    public static void addIncome(BudgetAccount budgetAccount, double income) {
        budgetAccount.setBalance(budgetAccount.getBalance() + income);
    }

    protected static void showBalance(BudgetAccount budgetAccount) {
        System.out.println("Balance: $" + df.format(budgetAccount.getBalance()));
    }

    protected static void addPurchase(BudgetAccount budgetAccount, int categoryNumber, String name, double price) {

        ArrayList<String> currentCategoryList = budgetAccount.getCategoryPurchasesMap().get(categoryNumber);
        String currentPurchase = name + " $" + df.format(price);
        currentCategoryList.add(currentPurchase);
        budgetAccount.getPurchasesWithPrice().put(currentPurchase, price);
        budgetAccount.getCategoryPurchasesMap().get(5).add(name + " $" + df.format(price));
        budgetAccount.setBalance(budgetAccount.getBalance() - price);
    }

    protected static void showListPurchasesByCategory(BudgetAccount budgetAccount, int categoryNumber) {
        System.out.println(getCategoryName(budgetAccount, categoryNumber) + ":");
        showListPurchases(budgetAccount.getCategoryPurchasesMap().get(categoryNumber), budgetAccount.getPurchasesWithPrice());
    }

    static String getCategoryName(BudgetAccount budgetAccount, int categoryNumber) {
        return budgetAccount.getCategoryNames().get(categoryNumber);
    }

    protected static boolean isPurchasesListEmpty(BudgetAccount budgetAccount) {
        return budgetAccount.getCategoryPurchasesMap().get(5).isEmpty();
    }

    static void showListPurchases(ArrayList<String> currentCategoryList, HashMap<String, Double> mapWithPrice) {
        if (currentCategoryList.isEmpty()) {
            System.out.println("The purchase list is empty");
            return;
        }
        double totalSumPurchases = 0;
        for (String purchase : currentCategoryList
        ) {
            System.out.println(purchase);
            if (!mapWithPrice.containsKey(purchase)) {
                totalSumPurchases = 0;
            } else {
                totalSumPurchases = totalSumPurchases + mapWithPrice.get(purchase);
            }

        }
        System.out.println("Total sum: $" + df.format(totalSumPurchases));
    }


}
