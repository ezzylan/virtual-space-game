package order_Food;

import javafx.scene.image.Image;

public class juicePlate implements plate {

    @Override
    public Image display() {
        Image imagejuice = new Image(getClass().getResourceAsStream("../resources/img/juice.png"));
        return imagejuice;
    }
    
}
