package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listOfBuyings = new ArrayList<>();
        double totalSum = 0;
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            listOfBuyings.add(str);
            String[] strArr = str.split(" ");
            for (String s : strArr) {
                if (s.contains("$")) {
                    totalSum = totalSum + Double.parseDouble(s.substring(1));
                }
            }
        }
        for (String temp : listOfBuyings
        ) {
            System.out.println(temp);
        }
        System.out.println();
        System.out.println("Total: $" + totalSum);
    }

}
