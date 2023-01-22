package eat_drink;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class EatDrinkAll implements EatDrinkBehaviour {

    @Override
    public void eat(int pasta, int juice, int cake, ImageView foodBG1, ImageView foodBG2, ImageView foodBG3) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (cake != 0){
            FadeTransition ft = new FadeTransition(Duration.millis(500), foodBG1);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();

            Image image1 = new Image(getClass().getResourceAsStream("../resources/img/emptyPlate.png"));
            foodBG1.setImage(image1);
        }
        if (juice != 0){
            FadeTransition ft = new FadeTransition(Duration.millis(500), foodBG2);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();

            Image image2 = new Image(getClass().getResourceAsStream("../resources/img/emptyPlate.png"));
            foodBG2.setImage(image2);
        }
        if (pasta != 0){
            FadeTransition ft = new FadeTransition(Duration.millis(500), foodBG3);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            
            Image image3 = new Image(getClass().getResourceAsStream("../resources/img/emptyPlate.png"));
            foodBG3.setImage(image3);
        }

        File file = new File("src/resources/sfx/burp.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}