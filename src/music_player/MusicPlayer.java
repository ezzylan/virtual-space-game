package music_player;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import app.MainSceneController;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MusicPlayer {
  File file;
  String fileName;
  AudioInputStream audioInputStream;
  Clip clip;

  public void playMusic(MusicPlayerCommand onMusicCommand, MainSceneController controller, Button button, Text name)
      throws LineUnavailableException, IOException, UnsupportedAudioFileException {
    file = new File("resources/music/Jazz Music.wav");
    fileName = file.getName();
    int index = fileName.lastIndexOf(".");
    fileName = fileName.substring(0, index);

    audioInputStream = AudioSystem.getAudioInputStream(file);
    clip = AudioSystem.getClip();
    clip.open(audioInputStream);

    onMusicCommand.execute(clip, fileName, controller, button, name);
  }

  public void stopMusic(MusicPlayerCommand offMusicCommand, MainSceneController controller, Button button, Text name) {
    offMusicCommand.execute(clip, fileName, controller, button, name);
  }

  public void chooseMusic(MusicPlayerCommand chooseMusicCommand, MainSceneController controller, Button button,
      Text name) {
    chooseMusicCommand.execute(clip, fileName, controller, button, name);
  }
}
