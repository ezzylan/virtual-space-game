import javax.security.auth.callback.Callback;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewMenuTest extends Application {
    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create list of menu items
        ObservableList<MenuItem> items = FXCollections.observableArrayList();
        items.addAll(
                new MenuItem("Pasta", 12.0,
                        "Simple and delicious, with house-made tomato-basil marinara, drizzled with Tusean olive oil."),
                new MenuItem("Cake", 10.0, "This is cake description!"));

        // Create a ListView
        ListView<MenuItem> listView = new ListView<>();

        // Bind our list to the ListView
        listView.setItems(items);

        // Now, for the magic. We'll create our own ListCells for the ListView. This
        // allows us to create a custom
        // layout for each individual cell. For this sample, we'll include a profile
        // picture, the name, and the age.
        listView.setCellFactory(new Callback<ListView<MenuItem>, ListCell<MenuItem>>() {
            @Override
            public ListCell<MenuItem> call(ListView<MenuItem> param) {
                return new ListCell<MenuItem>() {
                    @Override
                    protected void updateItem(MenuItem item, boolean empty) {
                        super.updateItem(item, empty);

                        // Set any empty cells to show nothing
                        if (item == null || empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            // Here we can build our layout. We'll use a HBox for our root container
                            HBox cellRoot = new HBox(5);
                            cellRoot.setAlignment(Pos.CENTER_LEFT);
                            cellRoot.setPadding(new Insets(5));

                            // Add our profile picture
                            ImageView imgProfilePic = new ImageView("/resources/diner.png");
                            imgProfilePic.setFitHeight(24);
                            imgProfilePic.setFitWidth(24);
                            cellRoot.getChildren().add(imgProfilePic);

                            // A simple Separator between the photo and the details
                            cellRoot.getChildren().add(new Separator(Orientation.VERTICAL));

                            // Now, create a VBox to hold the name and age
                            VBox vBox = new VBox(5);
                            vBox.setAlignment(Pos.CENTER_LEFT);
                            vBox.setPadding(new Insets(5));

                            // Add our Item details
                            vBox.getChildren().addAll(
                                    new Label("Name: " + item.getName()),
                                    new Label("Price: " + item.getPrice()),
                                    new Label("Description: " + item.getDescription));

                            // Add our VBox to the cellRoot
                            cellRoot.getChildren().add(vBox);

                            // Finally, set this cell to display our custom layout
                            setGraphic(cellRoot);
                        }
                    }
                };
            }
        });

        // Now, add our ListView to the root layout
        root.getChildren().add(listView);

        // Show the Stage
        primaryStage.setWidth(450);
        primaryStage.setHeight(400);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
