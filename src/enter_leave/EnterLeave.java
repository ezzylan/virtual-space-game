package enter_leave;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class EnterLeave implements State {
    private State UserState;

    public void setState(State state) {
        this.UserState = state;
    }

    public State getState() {
        return this.UserState;
    }

    @Override
    public void doAction() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.UserState.doAction();
    }

}
