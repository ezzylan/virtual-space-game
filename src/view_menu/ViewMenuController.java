import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button addItemLabel;

    @FXML
    private Button removeItemLabel;

    @FXML
    private Button orderLabel;

    @FXML
    private Text pastaItemQuantityLabel;

    @FXML
    private Text cakeItemQuantityLabel;

    @FXML
    private Text juiceItemQuantityLabel;

    // var to grab selected menu item
    MenuItem currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create list of menu items
        ObservableList<MenuItem> items = FXCollections.observableArrayList();
        // Create Menu Object
        MenuItem pasta = new MenuPasta();
        MenuItem cake = new MenuCake();
        MenuItem juice = new MenuJuice();
        // Add object to the observable list
        items.add(pasta);
        items.add(cake);
        items.add(juice);
        // Add object to listview
        menuListView.setItems(items);
        menuListView.setCellFactory(param -> new ListCell<MenuItem>() {
            protected void updateItem(MenuItem menu, boolean empty) {
                super.updateItem(menu, empty);
                if (empty || menu == null || menu.getMenuName() == null) {
                    setText(null);
                } else {
                    setText(menu.getMenuName());
                }
            }
        });

        menuListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MenuItem>() {

            @Override
            public void changed(ObservableValue<? extends MenuItem> arg0, MenuItem arg1, MenuItem arg2) {
                // call this method everytime we select a menu item from menu list
                currentFood = menuListView.getSelectionModel().getSelectedItem();
                menuLabel.setText(currentFood.getMenuName());
                Image image = new Image(currentFood.getMenuImage());
                menuPicLabel.setImage(image);
                double p = currentFood.getMenuPrice();
                String price = Double.toString(p);
                menuPriceLabel.setText(price);
                menuDescTA.setText(currentFood.getMenuDesc());
            }

        });
    }

}
