package music_player;

import javax.sound.sampled.Clip;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public interface MusicPlayerCommand {
  void execute(Clip clip, String fileName, Button button, Text name);
}
