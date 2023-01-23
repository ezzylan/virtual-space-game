package eat_drink;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EatDrinkSilently implements EatDrinkBehaviour {

    @Override
    public void eat(int pasta, int juice, int cake, ImageView foodBG1, ImageView foodBG2, ImageView foodBG3) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (cake != 0){
            Image image1 = new Image(getClass().getResourceAsStream("../resources/img/cake.png"));
            foodBG1.setImage(image1);
        }
        if (juice != 0){
            Image image2 = new Image(getClass().getResourceAsStream("../resources/img/juice.png"));
            foodBG2.setImage(image2);
        }
        if (pasta != 0){
            Image image3 = new Image(getClass().getResourceAsStream("../resources/img/pasta.png"));
            foodBG3.setImage(image3);
        }
    }
}