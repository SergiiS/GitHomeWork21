import Helper.DrinksMachine;
import java.util.Scanner;

class DrinksApp {
    public static final double COFFEE_PRICE = 2.0;
    public static final double TEA_PRICE = 1.5;
    public static final double LEMONADE_PRICE = 3.0;
    public static final double MOJITO_PRICE = 4.0;
    public static final double MINERAL_PRICE = 1.0;
    public static final double COCA_COLA_PRICE = 2.0;

    public static double calculateTotalCost(DrinksMachine[] drinks, int[] quantities) {
        double totalCost = 0;
        for (int i = 0; i < drinks.length; i++) {
            DrinksMachine drink = drinks[i];
            int quantity = quantities[i];
            switch (drink) {
                case COFFEE:
                    totalCost += COFFEE_PRICE * quantity;
                    break;
                case TEA:
                    totalCost += TEA_PRICE * quantity;
                    break;
                case LEMONADE:
                    totalCost += LEMONADE_PRICE * quantity;
                    break;
                case MOJITO:
                    totalCost += MOJITO_PRICE * quantity;
                    break;
                case MINERAL:
                    totalCost += MINERAL_PRICE * quantity;
                    break;
                case COCA_COLA:
                    totalCost += COCA_COLA_PRICE * quantity;
                    break;
            }
        }
        return totalCost;
    }

    public static double addOptions(DrinksMachine drink, Scanner scanner) {
        double optionsCost = 0;
        if (drink == DrinksMachine.COFFEE || drink == DrinksMachine.TEA) {
            System.out.print("Ви хочете добавити цукор (так/ні): ");
            String sugarChoice = scanner.next();
            if ("так".equalsIgnoreCase(sugarChoice)) {
                optionsCost += 0.5; // Add sugar cost
            }

            System.out.print("Ви хочете добавити молоко (так/ні): ");
            String milkChoice = scanner.next();
            if ("так".equalsIgnoreCase(milkChoice)) {
                optionsCost += 0.5; // Add milk cost
            }

            System.out.print("Ви хочете добавити лід (так/ні): ");
            String iceChoice = scanner.next();
            if ("так".equalsIgnoreCase(iceChoice)) {
                optionsCost += 0.5; // Add ice cost
            }
        }
        return optionsCost;
    }
}