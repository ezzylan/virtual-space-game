package order_food;

import javafx.scene.image.Image;

public class cakePlate implements plate {

    @Override
    public Image display() {
        Image imagecake = new Image(getClass().getResourceAsStream("../resources/img/cake.png"));
        return imagecake;
    }
    
}
