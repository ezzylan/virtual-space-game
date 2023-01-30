package see_Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import wallet.Observer;
import wallet.Subject;
import wallet.Wallet;

public class ViewMenuController implements Initializable, Subject {

    @FXML
    private ListView<MenuItem> menuListView;

    @FXML
    private ImageView menuPicLabel;

    @FXML
    private Text menuLabel;

    @FXML
    private Text menuPriceLabel;

    @FXML
    private Text orderAmount;

    @FXML
    private Text menuDescTA;

    @FXML
    private Button addItemLabel;

    @FXML
    private Button removeItemLabel;

    @FXML
    private Button orderMenu;

    @FXML
    private Button cancelMenu;

    @FXML
    private Text pastaItemQuantityLabel;

    @FXML
    private Text cakeItemQuantityLabel;

    @FXML
    private Text juiceItemQuantityLabel;

    @FXML
    private Text priceTotalLabel;

    // var to grab selected menu item
    MenuItem currentFood;

    protected int quantityPasta = 0;
    protected int quantityCake = 0;
    protected int quantityJuice = 0;

    // var to get the price of each menu item to count total price
    protected int pricePasta = 12;
    protected int priceCake = 10;
    protected int priceJuice = 5;
    protected int priceTotal = 0;

    Wallet wallet = Wallet.getInstance();
    List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerObserver(wallet);

        MenuRepository menuRepository = new MenuRepository();

        // JavaFx - Create list of menu items
        ObservableList<MenuItem> items = FXCollections.observableArrayList();

        Iterator iterator = menuRepository.createIterator();
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            // Add object to the observable list
            items.add(menuItem);
            // Add object to listview
            menuListView.setItems(items);
        }

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

                if (menuLabel.getText() == "Pasta") {
                    orderAmount.setText("" + quantityPasta);
                }

                if (menuLabel.getText() == "Cake") {
                    orderAmount.setText("" + quantityCake);
                }

                if (menuLabel.getText() == "Juice") {
                    orderAmount.setText("" + quantityJuice);
                }
            }

        });
    }

    @FXML
    void addItemClicked(ActionEvent event) {
        if (menuLabel.getText() == "Pasta") {
            quantityPasta += 1;
            orderAmount.setText("" + quantityPasta);
            pastaItemQuantityLabel.setText("" + quantityPasta);
        }

        if (menuLabel.getText() == "Cake") {
            quantityCake += 1;
            orderAmount.setText("" + quantityCake);
            cakeItemQuantityLabel.setText("" + quantityCake);
        }

        if (menuLabel.getText() == "Juice") {
            quantityJuice += 1;
            orderAmount.setText("" + quantityJuice);
            juiceItemQuantityLabel.setText("" + quantityJuice);
        }

        updateTotalPrice();
    }

    @FXML
    void removeItemClicked(ActionEvent event) {
        if (menuLabel.getText() == "Pasta" && quantityPasta != 0) {
            quantityPasta -= 1;
            orderAmount.setText("" + quantityPasta);
            pastaItemQuantityLabel.setText("" + quantityPasta);
        }

        if (menuLabel.getText() == "Cake" && quantityCake != 0) {
            quantityCake -= 1;
            orderAmount.setText("" + quantityCake);
            cakeItemQuantityLabel.setText("" + quantityCake);
        }

        if (menuLabel.getText() == "Juice" && quantityJuice != 0) {
            quantityJuice -= 1;
            orderAmount.setText("" + quantityJuice);
            juiceItemQuantityLabel.setText("" + quantityJuice);
        }

        updateTotalPrice();
    }

    @FXML
    void cancelMenuClicked(ActionEvent event) {
        Stage menuStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../app/MainScene.fxml"));
            Scene scene = new Scene(root);
            menuStage.setTitle("Virtual Space Game");
            menuStage.setScene(scene);
            menuStage.setResizable(false);
            ((Node) event.getSource()).getScene().getWindow().hide();
            menuStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void orderMenuClicked(ActionEvent event) {
        notifyObservers();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../food/displayFood.fxml"));
            Parent odr = loader.load();

            Scene scene2 = new Scene(odr);

            food.foodController controller = loader.getController();
            controller.cake = quantityCake;
            controller.juice = quantityJuice;
            controller.pasta = quantityPasta;
            controller.total = priceTotal;

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Virtual Space Game - Display Food");
            window.setScene(scene2);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateTotalPrice() {
        int p = quantityPasta * pricePasta;
        int c = quantityCake * priceCake;
        int j = quantityJuice * priceJuice;
        priceTotal = p + c + j;

        priceTotalLabel.setText("" + priceTotal);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(priceTotal);
        }
    }

}
