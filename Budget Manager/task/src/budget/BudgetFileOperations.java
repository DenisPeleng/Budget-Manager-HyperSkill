package budget;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static budget.BudgetAccountService.addIncome;

public class BudgetFileOperations {
    private static final String filePath = "purchases.txt";

    public static void saveToFile(BudgetAccount budgetAccount) {
        File purchasesFile = new File(filePath);
        HashMap<Integer, ArrayList<String>> purchasesMap = budgetAccount.getCategoryPurchasesMap();
        HashMap<String, Double> purchasesPriceMap = budgetAccount.getPurchasesWithPrice();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(purchasesFile, false))) {
            printWriter.println(budgetAccount.getBalance());
            for (int currentCategory : purchasesMap.keySet()
            ) {
                ArrayList<String> purchasesForCategory = purchasesMap.get(currentCategory);
                for (String purchase : purchasesForCategory
                ) {
                    String fullStrToSave = currentCategory +
                            "#" +
                            purchase +
                            "#" +
                            purchasesPriceMap.get(purchase);
                    printWriter.println(fullStrToSave);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println("Purchases were saved!");
    }

    public static void loadFromFile(BudgetAccount budgetAccount) {
        File purchasesFile = new File(filePath);
        HashMap<Integer, ArrayList<String>> purchasesMap = budgetAccount.getCategoryPurchasesMap();
        HashMap<String, Double> purchasesPriceMap = budgetAccount.getPurchasesWithPrice();
        try (Scanner scannerFile = new Scanner(purchasesFile)) {
            double balance = Double.parseDouble(scannerFile.nextLine());
            addIncome(budgetAccount, balance);
            while (scannerFile.hasNext()) {
                String[] fullDataPurchases = scannerFile.nextLine().split("#");
                int categoryNumber = Integer.parseInt(fullDataPurchases[0]);
                String purchaseName = fullDataPurchases[1];
                double purchasePrice = Double.parseDouble(fullDataPurchases[2]);
                ArrayList<String> purchaseList = purchasesMap.get(categoryNumber);
                purchaseList.add(purchaseName);
                purchasesMap.put(categoryNumber, purchaseList);
                purchasesPriceMap.put(purchaseName, purchasePrice);
            }
            budgetAccount.setCategoryPurchasesMap(purchasesMap);
            budgetAccount.setPurchasesWithPrice(purchasesPriceMap);
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

        System.out.println("Purchases were loaded!");
    }
}
