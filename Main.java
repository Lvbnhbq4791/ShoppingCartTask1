import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Апельсины", "Кефир"};
        int[] prices = {20, 150, 70};
        int[] basket = new int[products.length];
        boolean purchases = false;
        while (true) {
            System.out.println("Список возможных товаров для покупки");
            for (int i = 0; i < products.length; i++) {
                System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " руб/шт");
            }
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end") && purchases) {
                displayShoppingList(products, prices, basket);
                break;
            } else if (input.equals("end")) {
                System.out.println("Ваша корзина: пуста");
                break;
            }
            purchases = true;
            String[] productPrice = input.split(" ");
            int productNumber = Integer.parseInt(productPrice[0]);
            int productCount = Integer.parseInt(productPrice[1]);
            basket[productNumber - 1] += productCount;
        }
    }

    public static void displayShoppingList(String[] products, int[] prices, int[] basket) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != 0) {
                int sum = prices[i] * basket[i];
                System.out.println(products[i] + " " + basket[i] + " шт " + prices[i]
                        + " руб/шт " + sum + " руб в сумме");
            }
        }
    }
}