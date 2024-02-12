import Helper.DrinksMachine;
import java.util.Scanner;

public class DrinksChoose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть свій напой:");
        System.out.println("1. COFFEE");
        System.out.println("2. TEA");
        System.out.println("3. LEMONADE");
        System.out.println("4. MOJITO");
        System.out.println("5. MINERAL");
        System.out.println("6. COCA COLA");
        System.out.println("Введіть 0, щоб припинити вибір напоїв.");

        DrinksMachine[] chosenDrinks = new DrinksMachine[DrinksMachine.values().length];
        int[] quantities = new int[DrinksMachine.values().length];

        int choice;
        do {
            System.out.print("Введіть ваш вибір (1-6): ");
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 6) {
                System.out.print("Введіть кількість: ");
                int quantity = scanner.nextInt();
                chosenDrinks[choice - 1] = DrinksMachine.values()[choice - 1];
                quantities[choice - 1] += quantity;
            }
        } while (choice != 0);

        double totalCost = 0;
        for (int i = 0; i < chosenDrinks.length; i++) {
            if (chosenDrinks[i] != null) {
                totalCost += DrinksApp.calculateTotalCost(new DrinksMachine[]{chosenDrinks[i]}, new int[]{quantities[i]})
                        + DrinksApp.addOptions(chosenDrinks[i], scanner);
            }
        }
        System.out.println("Загальна ціна для оплати: $" + totalCost);

        scanner.close();
    }
}