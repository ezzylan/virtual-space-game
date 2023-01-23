package eat_drink;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EatDrinkLoudly implements EatDrinkBehaviour {

    @Override
    public void eatDrink(int pasta, int juice, int cake, ImageView foodBG1, ImageView foodBG2, ImageView foodBG3) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (cake != 0){
            File file = new File("src/resources/sfx/eating-cake.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            Image image1 = new Image(getClass().getResourceAsStream("../resources/img/cake.png"));
            foodBG1.setImage(image1);
        }
        if (juice != 0){
            File file = new File("src/resources/sfx/drinking-juice.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            Image image2 = new Image(getClass().getResourceAsStream("../resources/img/juice.png"));
            foodBG2.setImage(image2);
        }
        if (pasta != 0){
            File file = new File("src/resources/sfx/eating-pasta.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            Image image3 = new Image(getClass().getResourceAsStream("../resources/img/pasta.png"));
            foodBG3.setImage(image3);
        }
    }
}