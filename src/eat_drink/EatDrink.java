package eat_drink;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.image.ImageView;

public class EatDrink implements EatDrinkBehaviour {
    private EatDrinkBehaviour eatBehaviour;

    public EatDrinkBehaviour getEatBehaviour() {
        return this.eatBehaviour;
    }

    public void setEatBehaviour(EatDrinkBehaviour eatBehaviour) {
        this.eatBehaviour = eatBehaviour;
    }

    @Override
    public void eat(int pasta, int juice, int cake, ImageView foodBG1, ImageView foodBG2, ImageView foodBG3) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.eatBehaviour.eat(pasta, juice, cake, foodBG1, foodBG2, foodBG3);
    }

}
