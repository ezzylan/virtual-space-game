import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MenuItem {
    private final StringProperty name;
    private final DoubleProperty price;
    private final StringProperty description;
    private final StringProperty image;

    // Constructor to create menu item
    public MenuItem(String name, String image, double price, String description) {
        this.name = new SimpleStringProperty(name);
        this.image = new SimpleStringProperty(image);
        this.price = new SimpleDoubleProperty(price);
        this.description = new SimpleStringProperty(description);
    }

    public String getImage() {
        return image.get();
    }

    public String getName() {
        return name.get();
    }

    public String getDescription() {
        return description.get();
    }

    public double getPrice() {
        return price.get();
    }
}
