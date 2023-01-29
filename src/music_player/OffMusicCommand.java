package music_player;

import javax.sound.sampled.Clip;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class OffMusicCommand implements MusicPlayerCommand {

  @Override
  public void execute(Clip clip, String fileName, Button button, Text name) {
    clip.stop();
    button.setText("Turn on music");
    name.setText("-");
  }

}
