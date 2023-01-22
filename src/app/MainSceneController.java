package app;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import enter_leave.EnterLeave;
import enter_leave.LeaveState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import music_player.MusicPlayer;
import music_player.OffMusicCommand;
import music_player.OnMusicCommand;

public class MainSceneController {
  MusicPlayer musicPlayer = new MusicPlayer();
  boolean isPlaying = false;

  @FXML
  private ImageView indexBG;

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
  private Button OrderAllButton;

  @FXML
  private Button SitButton;

  @FXML
  private Text WalletAmount;

  @FXML
  void EatButtonClicked(ActionEvent event) {

  }

  @FXML
  void LeaveButtonClicked(ActionEvent event)
      throws LineUnavailableException, IOException, UnsupportedAudioFileException {
    Stage primaryStage = new Stage();
    Parent root;

    enter_leave.EnterLeave context = new EnterLeave();
    enter_leave.State leaveState = new LeaveState();

    context.setState(leaveState);
    context.doAction();

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
    Stage viewMenuStage = new Stage();
    Parent root;

    try {
      root = FXMLLoader.load(getClass().getResource("ViewMenuScene.fxml"));
      Scene scene = new Scene(root);
      viewMenuStage.setTitle("Virtual Space Game - Menu");
      viewMenuStage.setScene(scene);
      viewMenuStage.setResizable(false);
      ((Node) event.getSource()).getScene().getWindow().hide();
      viewMenuStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
  void OrderAllButtonClicked(ActionEvent event) {
    Stage displayStage = new Stage();
    Parent root;

    try {
      root = FXMLLoader.load(getClass().getResource("../order_Food/orderAll.fxml"));
      Scene scene = new Scene(root);
      displayStage.setTitle("Virtual Space Game - Display Food");
      displayStage.setScene(scene);
      displayStage.setResizable(false);
      ((Node) event.getSource()).getScene().getWindow().hide();
      displayStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void SitButtonClicked(ActionEvent event) {
    Image image = new Image(getClass().getResourceAsStream("../resources/img/table.png"));
    indexBG.setImage(image);
    MenuButton.setDisable(false);
    EatButton.setDisable(false);
    SitButton.setDisable(true);
  }

  public boolean isPlaying() {
    return isPlaying;
  }

  public void setPlaying(boolean isPlaying) {
    this.isPlaying = isPlaying;
  }

}
