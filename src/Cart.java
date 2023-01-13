import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<String> items;
    double total;

    public Cart() {
        items = new ArrayList<String>();
    }

    public void addItems(String item) {
        items.add(item);
    }

    public void removeItems(String item) {
        items.remove(item);
    }

    public void getNumberOfItems() {
        System.out.println(items.size());
    }

    public String getItemName(int index) {
        return items.get(index);
    }

    public void getTotalOfCart() {
        total = 0;
        for (String x : items) {
            if (x.equals("A")) {
                total += 3.0;
            } else if (x.equals("B")) {
                total += 5.0;
            } else if (x.equals("C")) {
                total += 2.50;
            }
        }
        System.out.println(total);
    }
}