import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;

public class hangmanGameController {
	private ColorAdjust darkenEffect = new ColorAdjust(); // creates the color adjust for the letter buttons
	private List<String> words = Arrays.asList("Apple", "Train", "Mango", "River", "Lemon", "Horse", "Tiger", "Snake",
			"Chair", "Cloud", "Table", "Music", "Laptop", "Forest", "Rabbit", "Dragon"); // list of words
	private String randomWord; // random word chosen from the list
	private int wrongGuessCount = 0;
	@FXML
	private Pane losingScreen;

	@FXML
	private Button exitGameButton;

	@FXML
	private Button exitGameButton1;
	
    @FXML
    private Button exitGameW;

	@FXML
	private Button startButton;

	@FXML
	private Button aButton;

	@FXML
	private Button bButton;

	@FXML
	private Button cButton;

	@FXML
	private Button dButton;

	@FXML
	private Button fButton;

	@FXML
	private Button gButton;

	@FXML
	private Button hButton;

	@FXML
	private Button jButton;

	@FXML
	private Button kButton;

	@FXML
	private Button lButton;

	@FXML
	private Button mButton;

	@FXML
	private Button nButton;

	@FXML
	private Button pButton;

	@FXML
	private Button qButton;

	@FXML
	private Button rButton;

	@FXML
	private Button sButton;

	@FXML
	private Button tButton;

	@FXML
	private Button xButton;

	@FXML
	private Button vButton;

	@FXML
	private Button wButton;

	@FXML
	private Button yButton;

	@FXML
	private Button zButton;

	@FXML
	private Button eButton;

	@FXML
	private Button iButton;

	@FXML
	private Button oButton;

	@FXML
	private Button uButton;

	@FXML
	private Circle head;

	@FXML
	private Line body;

	@FXML
	private Line leftArm;

	@FXML
	private Line rightArm;

	@FXML
	private Line leftLeg;

	@FXML
	private Line rightLeg;

	@FXML
	private Text text;

	@FXML
	private Button playAgain;

	@FXML
	private void buttonClicked(ActionEvent event) {
	    Button clickedButton = (Button) event.getSource();
	    String guessedLetter = clickedButton.getText();

	    // Check if the guessed letter is a vowel
	    if (isVowel(guessedLetter)) {
	        replaceVowel(guessedLetter);
	        darkenAndDisableVowels(guessedLetter); // Darken and disable the vowel button
	    } else {
	        // Existing logic for handling non-vowel letters
	        boolean correctGuess = false;
	        StringBuilder updatedText = new StringBuilder(text.getText());

	        // Check if the guessed letter is correct and replace underscores accordingly
	        for (int i = 0; i < randomWord.length(); i++) {
	            char randomCharLower = Character.toLowerCase(randomWord.charAt(i));
	            char guessedLetterLower = Character.toLowerCase(guessedLetter.charAt(0));

	            if (randomCharLower == guessedLetterLower) {
	                updatedText.setCharAt(2 * i, guessedLetter.charAt(0));
	                correctGuess = true;
	            }
	        }

	        text.setText(updatedText.toString());

	        if (!correctGuess) {
	            updateHangmanFigure();
	        }
	    }

	    clickedButton.setEffect(darkenEffect);
	    clickedButton.setDisable(true);
	}



	private boolean isVowel(String letter) { 	// check if a letter is a vowel
	    return "aeiou".contains(letter.toLowerCase());
	}

	private void resetHangmanFigure() { //reset the human method
		head.setOpacity(0);
		body.setOpacity(0);
		leftArm.setOpacity(0);
		rightArm.setOpacity(0);
		leftLeg.setOpacity(0);
		rightLeg.setOpacity(0);
		losingScreen.setOpacity(0);
	}

	private void resetAlphabetButtons() { //reset the non vowel letter methods 
		List<Button> alphabetButtons = Arrays.asList(aButton, bButton, cButton, dButton, eButton, fButton, gButton,
				hButton, iButton, jButton, kButton, lButton, mButton, nButton, oButton, pButton, qButton, rButton,
				sButton, tButton, uButton, vButton, wButton, xButton, yButton, zButton);

		for (Button button : alphabetButtons) {
			button.setDisable(false);
			button.setEffect(null);
		}
	}

	@FXML
	private void startClicked(ActionEvent event) {
		// Select a random word from the list
		Random random = new Random();
		randomWord = words.get(random.nextInt(words.size()));

		// Hide the start button
		startButton.setVisible(false);

		StringBuilder underscores = new StringBuilder();
		for (int i = 0; i < randomWord.length(); i++) {
			underscores.append("_ ");
		}
		text.setText(underscores.toString());

		// Testing
		System.out.println("Random word: " + randomWord);
	}

	private void updateHangmanFigure() {
		switch (wrongGuessCount) { // switch case for updateHangman
		case 0:
			head.setOpacity(1);
			break;
		case 1:
			body.setOpacity(1);
			break;
		case 2:
			leftArm.setOpacity(1); 
			break;
		case 3:
			rightArm.setOpacity(1);
			break;
		case 4:
			leftLeg.setOpacity(1);
			break;
		case 5:
			rightLeg.setOpacity(1); 
			losingScreen.setOpacity(0.9);
		}
		wrongGuessCount++; // increment wrong guess count
	}

	@FXML
	private void initialize() {
		darkenEffect.setBrightness(-0.5); // brightness to darken the buttons

		exitGameButton.setOnAction(event -> {// Event for the exitGameButton in the corner of the game

			Stage stage = (Stage) exitGameButton.getScene().getWindow(); // Get the current stage
			stage.close();// closes stage
		});

		exitGameButton1.setOnAction(event -> { // Event for the exitGameButton1 for the you lose/win
			Stage stage = (Stage) exitGameButton1.getScene().getWindow();// Gets the current stage
			stage.close(); // closes stage
		});

		playAgain.setOnAction(event -> { // Event for the playAgain button
			randomWord = null;// sets the random word back to null
			wrongGuessCount = 0;// initialize wrong guess count

			resetHangmanFigure();// Reset figure

			text.setText("");// Reset text

			startButton.setVisible(true);// Makes the start button visible again

			resetAlphabetButtons(); //reset letter method
			resetVowelButtons(); //reset vowel letter method
		});		
	}

	@FXML
	private void buttonVowelClicked(ActionEvent event) { //action for when vowels are clicked
	    Button clickedButton = (Button) event.getSource();
	    String guessedVowel = clickedButton.getText();
	    new MathQuiz(this, guessedVowel);

	}
	
    public void darkenAndDisableVowels(String guessedVowel) { //darkens and disabled the vowels once used
        switch (guessedVowel.toLowerCase()) {
            case "a":
                aButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #AAAAAA;");
                aButton.setDisable(true);
                break;
            case "e":
                eButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #AAAAAA;");
                eButton.setDisable(true);
                break;
            case "i":
                iButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #AAAAAA;");
                iButton.setDisable(true);
                break;
            case "o":
                oButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #AAAAAA;");
                oButton.setDisable(true);
                break;
            case "u":
                uButton.setStyle("-fx-background-color: #666666; -fx-text-fill: #AAAAAA;");
                uButton.setDisable(true);
                break;
            default:
            	break;
        }
    }

    public void replaceVowel(String guessedVowel) { //replace vowels
        StringBuilder updatedText = new StringBuilder(text.getText());
        char guessedChar = guessedVowel.toLowerCase().charAt(0);
        System.out.println("Guessed vowel: " + guessedChar);
        for (int i = 0; i < randomWord.length(); i++) {
            char randomChar = randomWord.toLowerCase().charAt(i);
            System.out.println("Random character: " + randomChar);
            if (randomChar == guessedChar) {
                int index = updatedText.indexOf("_"); 
                System.out.println("Index of underscore: " + index);
                if (index != -1) {
                    updatedText.setCharAt(index, Character.toUpperCase(randomWord.charAt(i)));
                    System.out.println("Updated text: " + updatedText.toString());
                }
            }
        }
        text.setText(updatedText.toString());
    }
    
    private void resetVowelButtons() { //Reset vowels
        List<Button> vowelButtons = Arrays.asList(aButton, eButton, iButton, oButton, uButton);

        for (Button button : vowelButtons) {
        	button.setStyle("-fx-background-color: #990011; -fx-text-fill: white;");
            button.setDisable(false);
        }
    }
}