package enter_leave;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class LeaveState implements State {

    @Override
    public void doAction() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        System.out.print("leave restaurant");
        File file = new File("src/resources/sfx/Thankyou-1.wav");

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

}
