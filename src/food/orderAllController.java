package food;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import enter_leave.EnterLeave;
import enter_leave.LeaveState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import music_player.MusicPlayer;
import music_player.OffMusicCommand;
import music_player.OnMusicCommand;

public class orderAllController {
    MusicPlayer musicPlayer = new MusicPlayer();
    boolean isPlaying = false;
    // total price for order all is rm 27 (12 + 10 + 5)
    int total = 27;

    @FXML
    private ImageView tableBG;

    @FXML
    private ImageView displayFoodBG1;

    @FXML
    private ImageView displayFoodBG2;

    @FXML
    private ImageView displayFoodBG3;

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
    private Button DisplayButton;

    @FXML
    private Button SitButton;

    @FXML
    private Text WalletAmount;

    @FXML
    private Button confirmButton;

    @FXML
    private Group orderListGroup;

    @FXML
    void EatButtonClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../eat_drink/EatDrink.fxml"));
            Parent odr = loader.load();

            Scene scene2 = new Scene(odr);

            eat_drink.EatDrinkController controller = loader.getController();
            controller.cake = 1;
            controller.juice = 1;
            controller.pasta = 1;

            Stage window =(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Virtual Space Game - Eat/Drink");
            window.setScene(scene2);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        root = FXMLLoader.load(getClass().getResource("../app/IndexScene.fxml"));
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
      // if (isPlaying) {
      //   musicPlayer.stopMusic(new OffMusicCommand(), this, MusicButton, MusicName);
      // } else {
      //   musicPlayer.playMusic(new OnMusicCommand(), this, MusicButton, MusicName);
      // }
    }

    @FXML
    void DisplayButtonClicked(ActionEvent event) {
      orderListGroup.setVisible(true);
      DisplayButton.setDisable(true);
    }

    /**
     * Using Facade design pattern that use orderAllFacade class as
     * an interface which provides simplified methods required by 
     * client (DisplayButtonClicked) and delegates calls to methods of
     * existing system classes. (cakePlate, juicePlate, pastaPlate)
     */

    @FXML
    void confirmButtonClicked(ActionEvent event) {
      orderListGroup.setVisible(false);
      orderAllFacade foodImage = new orderAllFacade();
      displayFoodBG1.setImage(foodImage.getCakeImage());
      displayFoodBG2.setImage(foodImage.getJuiceImage());
      displayFoodBG3.setImage(foodImage.getPastaImage());

      // To display total price:
      WalletAmount.setText("" + total);
      
      System.out.print("\n\nDisplay Number of Cake: 1\n\nDisplay Number of Juice: 1\n\nDisplay Number of Pasta: 1");
      DisplayButton.setDisable(true);
      EatButton.setDisable(false);

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
