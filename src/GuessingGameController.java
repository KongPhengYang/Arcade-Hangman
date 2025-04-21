
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;



public class GuessingGameController implements Initializable {
	

    private hangmanGameController hangmanController;
    public GuessingGameController(hangmanGameController hangmanController) {
        this.hangmanController = hangmanController;
    }
    public GuessingGameController() {
    }
    public void setHangmanController(hangmanGameController hangmanController) {
        this.hangmanController = hangmanController;
    }
	
    private final Random random = new Random();
    private int randomNum;
    private int guessCount = 0;
    private int finalCount = 5;
    @FXML
    private TextField guess;
    @FXML
    private ImageView upArrow;
    @FXML
    private ImageView downArrow;
    @FXML
    private ImageView playerWon;
    @FXML
    private Text guessCounter;
    @FXML
    private Pane winPane;
    @FXML
    private Button returnWinButton;
    @FXML
    private Pane startPane;
    @FXML
    private Button returnLose;
    @FXML
    private Pane losePane;
    
    
    @FXML
    void startGame(ActionEvent event) {
    	startPane.setVisible(false);
    	downArrow.setVisible(false);
        upArrow.setVisible(false);
        winPane.setVisible(false);
        losePane.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNum = random.nextInt(50);
        System.out.println(randomNum);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        winPane.setVisible(false);
        losePane.setVisible(false);
    }

    @FXML
    void checkGuess(ActionEvent event) {
        if(Integer.parseInt(guess.getText()) == randomNum){
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            winPane.setVisible(true);
        } else if(Integer.parseInt(guess.getText()) > randomNum){
            downArrow.setVisible(true);
            upArrow.setVisible(false);
            winPane.setVisible(false);
        } else if(Integer.parseInt(guess.getText()) < randomNum){
            downArrow.setVisible(false);
            upArrow.setVisible(true);
            winPane.setVisible(false);
        }
        guessCount++;
        guessCounter.setText("Guess Counter: " + guessCount);
        if(guessCount >= finalCount) {
        	randomNum = random.nextInt(50);
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            winPane.setVisible(false);
            losePane.setVisible(true);
        }
        
    }
    
    
    public void returnWin() {
        if (hangmanController != null) {
            hangmanController.replaceVowelForGuessingGame();
            returnWinButton.getScene().getWindow().hide();
        } else {
            System.err.println("Error: hangmanController is null");
        }
    }
    
    public void returnLose() {
        returnWinButton.getScene().getWindow().hide();
    }

    @FXML
    void exit(ActionEvent event) {
        javafx.application.Platform.exit();
    }
}
