import java.util.ArrayList;
import java.util.List;

public class ViewMenuController {
    
    List<MenuItem> menuItems;

    public ViewMenuController(){
        menuItems = new ArrayList<MenuItem>();

        addItem("Pasta", 12.0, "Simple and delicious, with house-made tomato-basil marinara, drizzled with Tusean olive oil.");
    }

    public void addItem(String name, double price, String description){
        MenuItem menuItem = new MenuItem(name, price, description);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems(){
        return (ArrayList<MenuItem>) menuItems;
    }
}
