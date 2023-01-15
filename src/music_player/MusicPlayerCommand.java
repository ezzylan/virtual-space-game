package music_player;
import javax.sound.sampled.Clip;

import app.MainSceneController;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public interface MusicPlayerCommand {
  abstract void execute(Clip clip, String fileName, MainSceneController controller, Button button, Text name);
}
