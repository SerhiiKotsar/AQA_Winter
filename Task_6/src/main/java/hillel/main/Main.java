package hillel.main;
import hillel.collections.Product;
import hillel.collections.ProductMarket;
import java.util.ArrayList;

public class Main {

    static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Творог", 45));
        products.add(new Product("Сметана", 7.48));
        products.add(new Product("Корица", 9.99));
        products.add(new Product("Свинина", 100.85));
        products.add(new Product("Кола", 35));
    }

    public static void main(String[] args) {

        //1. Получить имена продуктов
        ProductMarket productMarket = new ProductMarket(products);
        System.out.println("1. Список листа:");
        productMarket.getProductNames(products);

        //2. Сортировка по алфавиту
        System.out.println();
        System.out.println("2. Сортировка по алфавиту:");
        productMarket.getSortedProductNames(products);

        //3. Продукты, где цены больше 10
        System.out.println();
        System.out.println("3. Продукты, где цены больше 10:");
        productMarket.getPriceMoreThanTen(products);

        //4. Продукты, где цена меньше 0
        System.out.println();
        System.out.println("4. Продукты, где цена меньше 0:");
        productMarket.getPriceMoreLessThanZero(products);

        //5. Цена как String
        System.out.println();
        System.out.println("5. Цена как строка:");
        productMarket.getPriceAsString(products);
    }
}