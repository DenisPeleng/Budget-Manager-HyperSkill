package budget;

import java.util.ArrayList;
import java.util.HashMap;

import static budget.BudgetAccountService.*;

public class BudgetAnalyze {
    protected static void sortByCategoryByPrice(BudgetAccount budgetAccount, int categoryNumber) {
        ArrayList<String> currentCategoryList = budgetAccount.getCategoryPurchasesMap().get(categoryNumber);
        HashMap<String, Double> pricesMap = budgetAccount.getPurchasesWithPrice();
        ArrayList<String> sortedList = sortByPrice(currentCategoryList, pricesMap);
        System.out.println(getCategoryName(budgetAccount, categoryNumber) + ":");
        showListPurchases(sortedList, budgetAccount.getPurchasesWithPrice());
    }

    protected static void sortTypesByPrice(BudgetAccount budgetAccount) {
        ArrayList<String> categoriesWithSumList = new ArrayList<>();
        HashMap<Integer, String> categoriesNames = budgetAccount.getCategoryNames();
        HashMap<String, Double> categoryWithSumMap = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            double categorySum = totalSumOfCategory(budgetAccount, i);
            String categoryFullStr = categoriesNames.get(i) + " - $" + df.format(categorySum);
            categoriesWithSumList.add(categoryFullStr);
            categoryWithSumMap.put(categoryFullStr, categorySum);
        }
        ArrayList<String> sortedList = sortByPrice(categoriesWithSumList, categoryWithSumMap);
        System.out.println("Types:");
        showListPurchases(sortedList, budgetAccount.getPurchasesWithPrice());
    }

    protected static double totalSumOfCategory(BudgetAccount budgetAccount, int numberOfCategory) {
        ArrayList<String> currentPurchasesList = budgetAccount.getCategoryPurchasesMap().get(numberOfCategory);
        double totalSum = 0;
        for (String currentPurchase : currentPurchasesList
        ) {
            totalSum += budgetAccount.getPurchasesWithPrice().get(currentPurchase);
        }
        return totalSum;
    }

    private static ArrayList<String> sortByPrice(ArrayList<String> currentList, HashMap<String, Double> currentMapPrice) {
        String tempStr;
        for (int i = 0; i < currentList.size(); i++) {
            for (int j = 1; j < currentList.size() - 1; j++) {
                double prevPrice = currentMapPrice.get(currentList.get(j));
                double currentPrice = currentMapPrice.get(currentList.get(j + 1));
                if (prevPrice < currentPrice) {
                    tempStr = currentList.get(j + 1);
                    currentList.set(j + 1, currentList.get(j));
                    currentList.set(j, tempStr);
                }
            }
        }
        return currentList;
    }

}
