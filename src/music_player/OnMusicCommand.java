package music_player;

import javax.sound.sampled.Clip;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class OnMusicCommand implements MusicPlayerCommand {

  @Override
  public void execute(Clip clip, String fileName, Button button, Text name) {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
    button.setText("Turn off music");
    name.setText(fileName);
  }

}
