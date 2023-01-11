import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ViewMenuController {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;

    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private TextArea description;

    List<MenuItem> menuItems;

    public ViewMenuController() {
        menuItems = new ArrayList<MenuItem>();

        addItem("Pasta", 12.0,
                "Simple and delicious, with house-made tomato-basil marinara, drizzled with Tusean olive oil.");
    }

    public void addItem(String name, double price, String description) {
        MenuItem menuItem = new MenuItem(name, price, description);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return (ArrayList<MenuItem>) menuItems;
    }
}
