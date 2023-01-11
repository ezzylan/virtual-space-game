import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ViewMenuController implements Initializable {

    @FXML
    private ListView<String> menuListView;

    @FXML
    private Label menuLabel;

    String[] food = { "Pasta", "Cake", "Juice" };

    String currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuListView.getItems().addAll(food);

        menuListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // call this method everytime we select a menu item from menu list
                currentFood = menuListView.getSelectionModel().getSelectedItem();
                menuLabel.setText(currentFood);
            }

        });
    }

}
