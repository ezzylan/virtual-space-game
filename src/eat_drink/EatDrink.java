package eat_drink;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.image.ImageView;

public class EatDrink {
    private EatDrinkBehaviour eatDrinkBehaviour;

    public EatDrinkBehaviour getEatDrinkBehaviour() {
        return this.eatDrinkBehaviour;
    }

    public void setEatDrinkBehaviour(EatDrinkBehaviour eatDrinkBehaviour) {
        this.eatDrinkBehaviour = eatDrinkBehaviour;
    }

    public void performEatDrink(int pasta, int juice, int cake, ImageView foodBG1, ImageView foodBG2, ImageView foodBG3) throws LineUnavailableException, IOException, UnsupportedAudioFileException  {
        this.eatDrinkBehaviour.eatDrink(pasta, juice, cake, foodBG1, foodBG2, foodBG3);
    }
}