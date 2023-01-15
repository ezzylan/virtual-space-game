package music_player;
import javax.sound.sampled.Clip;

import app.MainSceneController;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class OffMusicCommand implements MusicPlayerCommand {

  @Override
  public void execute(Clip clip, String fileName, MainSceneController controller, Button button, Text name) {
    clip.stop();
    controller.setPlaying(false);
    button.setText("Turn on music");
    name.setText("-");
  }

}
