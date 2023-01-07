package music_player;
import javax.sound.sampled.Clip;

import app.MainSceneController;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class OnMusicCommand extends MusicPlayerCommand {

  @Override
  public void execute(Clip clip, String fileName, MainSceneController controller, Button button, Text name) {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    clip.start();
    controller.setPlaying(true);
    button.setText("Turn off music");
    name.setText(fileName);
  }

}
