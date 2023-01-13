import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ViewMenuController implements Initializable {

    @FXML
    private ListView<MenuItem> menuListView;

    @FXML
    private ImageView menuPicLabel;

    @FXML
    private Text menuLabel;

    @FXML
    private Text menuPriceLabel;

    @FXML
    private Text menuDescTA;

    MenuItem currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create list of menu items
        ObservableList<MenuItem> items = FXCollections.observableArrayList();
        items.add(new MenuItem("Pasta", "resources/pasta.png", 12.0,
                "Simple and delicious, with house-made tomato-basil marinara, drizzled with Tusean olive oil."));
        items.add(new MenuItem("Cake", "resources/cake.png", 10.0,
                "Simple and delicious, topped with house-made chocolate fondue."));
        items.add(new MenuItem("Juice", "resources/juice.png", 5.0,
                "Fresh orange juice may even be more intense and enjoyable, like eating a freshly peeled orange."));
        menuListView.setItems(items);
        menuListView.setCellFactory(param -> new ListCell<MenuItem>() {
            protected void updateItem(MenuItem menu, boolean empty) {
                super.updateItem(menu, empty);
                if (empty || menu == null || menu.getName() == null) {
                    setText(null);
                } else {
                    setText(menu.getName());
                }
            }
        });

        menuListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MenuItem>() {

            @Override
            public void changed(ObservableValue<? extends MenuItem> arg0, MenuItem arg1, MenuItem arg2) {
                // call this method everytime we select a menu item from menu list
                currentFood = menuListView.getSelectionModel().getSelectedItem();
                menuLabel.setText(currentFood.getName());
                Image image = new Image(currentFood.getImage());
                menuPicLabel.setImage(image);
                double p = currentFood.getPrice();
                String price = Double.toString(p);
                menuPriceLabel.setText(price);
                menuDescTA.setText(currentFood.getDescription());
            }

        });
    }

}
