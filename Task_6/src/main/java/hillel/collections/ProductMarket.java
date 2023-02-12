package hillel.collections;
import java.util.ArrayList;
import java.util.Collections;

public class ProductMarket {

    ArrayList<Product> list;

    public ProductMarket(ArrayList<Product> list) {
        this.list = list;
    }

    //Метод возвращающий имена продуктов
   public void getProductNames(ArrayList<Product> products) {
        ArrayList<String> names = new ArrayList<>();
        for (Product product : list) {
            System.out.println(product.name);
        }
   }

   public void getSortedProductNames(ArrayList<Product> products) {
       ArrayList<String> names = new ArrayList<>();
       for (Product product : list) {
           names.add(product.name);
       }
       Collections.sort(names);
       System.out.println(names);
   }

   public void getPriceMoreThanTen(ArrayList<Product> products) {
       ArrayList<String> names = new ArrayList<>();
       for (Product product : list) {
           if (product.price > 10) {
               names.add(product.name);
           }
       }
       System.out.println(names);
   }

    public void getPriceMoreLessThanZero (ArrayList<Product> products) {
        ArrayList<String> names = new ArrayList<>();
        for (Product product : list) {
            if (product.price < 0) {
                names.add(product.name);
            } else {
                System.out.println("Нет таких продуктов где стоимость меньше 0");
                break;
            }
        }
    }

    public void getPriceAsString(ArrayList<Product> products) {
        ArrayList<String> names = new ArrayList<>();
        for (Product product : list) {
                names.add(String.valueOf(product.price));
        }
        System.out.println(names);
    }
}
