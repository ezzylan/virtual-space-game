package order_Food;

import javafx.scene.image.Image;

public class pastaPlate implements plate {

    @Override
    public Image display() {
        Image imagepasta = new Image(getClass().getResourceAsStream("../resources/img/pasta.png"));
        return imagepasta;
    }
    
}
