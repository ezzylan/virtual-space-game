package order_Food;

import javafx.scene.image.Image;

public class cakePlate implements plate {

    @Override
    public Image display() {
        Image imagecake = new Image(getClass().getResourceAsStream("../resources/img/cake.png"));
        return imagecake;
    }
    
}
