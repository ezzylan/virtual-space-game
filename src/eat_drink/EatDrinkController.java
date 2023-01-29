package eat_drink;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import enter_leave.EnterLeave;
import enter_leave.LeaveState;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;
import music_player.MusicPlayer;
import music_player.OffMusicCommand;
import music_player.OnMusicCommand;
import wallet.Wallet;

public class EatDrinkController {

    MusicPlayer musicPlayer = MusicPlayer.getInstance();
    boolean isPlaying = musicPlayer.isPlaying();
    public int cake;
    public int juice;
    public int pasta;
    int walletAmount;
    Wallet wallet = Wallet.getInstance();

    @FXML
    private Group AllDoneGroup;

    @FXML
    public Button displayButton;

    @FXML
    private Button EatButton;

    @FXML
    private Group EatDrinkAllSomeGroup;

    @FXML
    private Group EatDrinkNoiseGroup;

    @FXML
    private Text EatDrinkText;

    @FXML
    private ImageView foodBG1;

    @FXML
    private ImageView foodBG2;

    @FXML
    private ImageView foodBG3;

    @FXML
    private ImageView indexBG;

    @FXML
    private Button LeaveButton;

    @FXML
    private Button LoudlyButton;

    @FXML
    private Button MenuButton;

    @FXML
    private Button MusicButton;

    @FXML
    private Text MusicName;

    @FXML
    private Button NoSomeButton;

    @FXML
    private Button OrderButton;

    @FXML
    private Button SilentlyButton;

    @FXML
    private Button SitButton;

    @FXML
    private Text WalletAmount;

    @FXML
    private Button YesAllButton;

    public void initialize() {
        walletAmount = wallet.getAmount();
        WalletAmount.setText(Integer.toString(walletAmount));

        if (isPlaying) {
            MusicButton.setText("Turn off music");
            MusicName.setText(musicPlayer.getFileName());
        }
    }

    @FXML
    void displayButtonClicked(ActionEvent event) throws IOException {
    }

    @FXML
    void EatButtonClicked(ActionEvent event) {
    }

    @FXML
    void LeaveButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        wallet.setAmount(100);
        musicPlayer.stopMusic(new OffMusicCommand(), false, MusicButton, MusicName);

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
    void LoudlyButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        EatDrink eatDrink = new EatDrink();
        EatDrinkBehaviour eatDrinkLoudly = new EatDrinkLoudly();

        eatDrink.setEatDrinkBehaviour(eatDrinkLoudly);
        eatDrink.performEatDrink(pasta, juice, cake, foodBG1, foodBG2, foodBG3);

        FXMLLoader root = new FXMLLoader(getClass().getResource("EatDrink.fxml"));
        root.setController(eatDrinkLoudly);

        EatDrinkNoiseGroup.setVisible(false);
        EatDrinkNoiseGroup.setManaged(false);

        FadeTransition ft = new FadeTransition(Duration.millis(1000), EatDrinkAllSomeGroup);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        EatDrinkAllSomeGroup.setVisible(true);
        EatDrinkAllSomeGroup.setManaged(true);
    }

    @FXML
    void MenuButtonClicked(ActionEvent event) {
    }

    @FXML
    void MusicButtonClicked(ActionEvent event)
            throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (isPlaying) {
            musicPlayer.stopMusic(new OffMusicCommand(), false, MusicButton, MusicName);
        } else {
            musicPlayer.playMusic(new OnMusicCommand(), true, MusicButton, MusicName);
        }
        isPlaying = musicPlayer.isPlaying();
    }

    @FXML
    void NoSomeButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        EatDrink eatDrink = new EatDrink();
        EatDrinkBehaviour eatDrinkSome = new EatDrinkSome();

        eatDrink.setEatDrinkBehaviour(eatDrinkSome);
        eatDrink.performEatDrink(pasta, juice, cake, foodBG1, foodBG2, foodBG3);

        FXMLLoader root = new FXMLLoader(getClass().getResource("EatDrink.fxml"));
        root.setController(eatDrinkSome);

        EatDrinkAllSomeGroup.setVisible(false);
        EatDrinkAllSomeGroup.setManaged(false);

        AllDoneGroup.setVisible(true);
        AllDoneGroup.setManaged(true);
    }

    @FXML
    void QuietlyButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        EatDrink eatDrink = new EatDrink();
        EatDrinkBehaviour eatDrinkQuietly = new EatDrinkQuietly();

        eatDrink.setEatDrinkBehaviour(eatDrinkQuietly);
        eatDrink.performEatDrink(pasta, juice, cake, foodBG1, foodBG2, foodBG3);

        FXMLLoader root = new FXMLLoader(getClass().getResource("EatDrink.fxml"));
        root.setController(eatDrinkQuietly);

        EatDrinkNoiseGroup.setVisible(false);
        EatDrinkNoiseGroup.setManaged(false);

        FadeTransition ft = new FadeTransition(Duration.millis(1000), EatDrinkAllSomeGroup);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        EatDrinkAllSomeGroup.setVisible(true);
        EatDrinkAllSomeGroup.setManaged(true);
    }

    @FXML
    void SitButtonClicked(ActionEvent event) {

    }

    @FXML
    void YesAllButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        EatDrink eatDrink = new EatDrink();
        EatDrinkBehaviour eatDrinkAll = new EatDrinkAll();

        eatDrink.setEatDrinkBehaviour(eatDrinkAll);
        eatDrink.performEatDrink(pasta, juice, cake, foodBG1, foodBG2, foodBG3);

        FXMLLoader root = new FXMLLoader(getClass().getResource("EatDrink.fxml"));
        root.setController(eatDrinkAll);

        EatDrinkAllSomeGroup.setVisible(false);
        EatDrinkAllSomeGroup.setManaged(false);

        AllDoneGroup.setVisible(true);
        AllDoneGroup.setManaged(true);
    }

}