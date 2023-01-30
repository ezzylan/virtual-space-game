package music_player;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MusicPlayer {
  private static MusicPlayer musicPlayerInstance;
  private boolean isPlaying = false;
  File file;
  String fileName;
  AudioInputStream audioInputStream;
  Clip clip;

  private MusicPlayer() {
  }

  public static MusicPlayer getInstance() {
    if (musicPlayerInstance == null) {
      musicPlayerInstance = new MusicPlayer();
    }
    return musicPlayerInstance;
  }

  public void playMusic(MusicPlayerCommand onMusicCommand, boolean isPlaying, Button button, Text name)
      throws LineUnavailableException, IOException, UnsupportedAudioFileException {
    file = new File("src/resources/music/Jazz Music.wav");
    fileName = file.getName();
    int index = fileName.lastIndexOf(".");
    fileName = fileName.substring(0, index);

    audioInputStream = AudioSystem.getAudioInputStream(file);
    clip = AudioSystem.getClip();
    clip.open(audioInputStream);

    setPlaying(isPlaying);
    onMusicCommand.execute(clip, fileName, button, name);
  }

  public void stopMusic(MusicPlayerCommand offMusicCommand, boolean isPlaying,
      Button button, Text name) {
    setPlaying(isPlaying);
    offMusicCommand.execute(clip, fileName, button, name);
  }

  public boolean isPlaying() {
    return isPlaying;
  }

  public void setPlaying(boolean isPlaying) {
    this.isPlaying = isPlaying;
  }

  public String getFileName() {
    return fileName;
  }
}
