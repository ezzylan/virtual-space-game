package app;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import music_player.MusicPlayer;
import music_player.OffMusicCommand;
import music_player.OnMusicCommand;

public class MainSceneController {
  MusicPlayer musicPlayer = new MusicPlayer();
  boolean isPlaying = false;

  @FXML
  private Button EatButton;

  @FXML
  private Button LeaveButton;

  @FXML
  private Button MenuButton;

  @FXML
  private Button MusicButton;

  @FXML
  private Text MusicName;

  @FXML
  private Button OrderButton;

  @FXML
  private Button SitButton;

  @FXML
  private Text WalletAmount;

  @FXML
  void EatButtonClicked(ActionEvent event) {

  }

  @FXML
  void LeaveButtonClicked(ActionEvent event) {
    Stage primaryStage = new Stage();
    Parent root;

    try {
      root = FXMLLoader.load(getClass().getResource("IndexScene.fxml"));
      Scene scene = new Scene(root);
      primaryStage.setTitle("Virtual Space Game");
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      ((Node) event.getSource()).getScene().getWindow().hide();
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @FXML
  void MenuButtonClicked(ActionEvent event) {

  }

  @FXML
  void MusicButtonClicked(ActionEvent event)
      throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    if (isPlaying) {
      musicPlayer.stopMusic(new OffMusicCommand(), this, MusicButton, MusicName);
    } else {
      musicPlayer.playMusic(new OnMusicCommand(), this, MusicButton, MusicName);
    }
  }

  @FXML
  void OrderButtonClicked(ActionEvent event) {

  }

  @FXML
  void SitButtonClicked(ActionEvent event) {

  }

  public boolean isPlaying() {
    return isPlaying;
  }

  public void setPlaying(boolean isPlaying) {
    this.isPlaying = isPlaying;
  }

}
