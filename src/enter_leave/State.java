package enter_leave;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface State {
    public void doAction() throws LineUnavailableException, IOException, UnsupportedAudioFileException;
}
