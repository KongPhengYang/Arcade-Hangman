import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;

public class hangmanGameController {
	private ColorAdjust darkenEffect = new ColorAdjust(); // creates the color adjust for the letter buttons

	
	private String randomWord; // random word chosen from the list
	private int wrongGuessCount = 0;
	
    @FXML
    private VBox difficultyMenu;
    
    @FXML
    private VBox mainMenuScreen;
	
	@FXML
	private Pane losingScreen;
	
	@FXML
	private Pane winningScreen;
	
	@FXML
	private Button easyButton;

	@FXML
	private Button mediumButton;

	@FXML
	private Button hardButton;

	@FXML
	private Button exitGameButton;

	@FXML
	private Button exitGameButton1;
	
	@FXML
	private Button exitGameButtonWin;
	
	@FXML
	private Button playAgain2;
	
    @FXML
    private Button exitGameMM;

	@FXML
	private Button startButton;
	
	@FXML
	private Button startButtonMM;

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
    private ImageView head;
	
    @FXML
    private ImageView body;
    
    @FXML
    private ImageView arm;

    @FXML
    private ImageView bothArm;
    
    @FXML
    private ImageView leg;

    @FXML
    private ImageView bothLeg;

	@FXML
	private Text text;

	@FXML
	private Button playAgain;

	private List<String> easyWords; // list of easy words
	private List<String> mediumWords; // list of medium words
	private List<String> hardWords; // list of hard words
	
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
	    
	    if (hasGuessedWord()) {
	        winningScreen.setOpacity(0.9); // Set opacity of winningScreen to 0.9
	    }
	}



	private boolean isVowel(String letter) { 	// check if a letter is a vowel
	    return "aeiou".contains(letter.toLowerCase());
	}

	private void resetHangmanFigure() { //reset the human method
		head.setVisible(false);
		body.setVisible(false);
		arm.setVisible(false);
		bothArm.setVisible(false);
		leg.setVisible(false);
		bothLeg.setVisible(false);
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
	    Button clickedButton = (Button) event.getSource();
	    System.out.println("Button clicked: " + clickedButton.getId());
	    Random random = new Random();
	    if (clickedButton.getId().equals("easyButton")) {
	        randomWord = easyWords.get(random.nextInt(easyWords.size()));
	        System.out.println("Easy Button Clicked");
	    } else if (clickedButton.getId().equals("mediumButton")) {
	        randomWord = mediumWords.get(random.nextInt(mediumWords.size()));
	        System.out.println("Medium Button Clicked");
	    } else if (clickedButton.getId().equals("hardButton")) {
	        randomWord = hardWords.get(random.nextInt(hardWords.size()));
	        System.out.println("Hard Button Clicked");
	    } else {
	        // Default to easy words if no specific button is clicked
	        randomWord = easyWords.get(random.nextInt(easyWords.size()));
	        System.out.println("No Button Clicked");
	    }

	    difficultyMenu.setVisible(false);
	    
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
			head.setVisible(true);
			break;
		case 1:
			body.setVisible(true);
			break;
		case 2:
			arm.setVisible(true);
			break;
		case 3:
			bothArm.setVisible(true);
			break;
		case 4:
			leg.setVisible(true);
			break;
		case 5:
			bothLeg.setVisible(true);
			losingScreen.setOpacity(0.9);
		}
		wrongGuessCount++; // increment wrong guess count
	}
	
	private boolean hasGuessedWord() {
	    String guessedWord = text.getText().replaceAll("\\s+", ""); // Remove spaces from the displayed text
	    return guessedWord.equalsIgnoreCase(randomWord);
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
		
		exitGameButtonWin.setOnAction(event -> { // Event for the exitGameButton1 for the you lose/win
			Stage stage = (Stage) exitGameButton1.getScene().getWindow();// Gets the current stage
			stage.close(); // closes stage
		});
		
		exitGameMM.setOnAction(event -> { // Event for the exitGameMM from the main menu
			Stage stage = (Stage) exitGameMM.getScene().getWindow();// Gets the current stage
			stage.close(); // closes stage
		});

		playAgain.setOnAction(event -> { // Event for the playAgain button
			randomWord = null;// sets the random word back to null
			wrongGuessCount = 0;// initialize wrong guess count

			resetHangmanFigure();// Reset figure

			text.setText("");// Reset text

			startButton.setVisible(true);// Makes the start button visible again
			
		    difficultyMenu.setVisible(true); // Makes the difficultyMenu visible again
		    

			resetAlphabetButtons(); //reset letter method
			resetVowelButtons(); //reset vowel letter method
		});
		
		playAgain2.setOnAction(event -> { // Event for the playAgain button
			randomWord = null;// sets the random word back to null
			wrongGuessCount = 0;// initialize wrong guess count

			resetHangmanFigure();// Reset figure

			text.setText("");// Reset text

			startButton.setVisible(true);// Makes the start button visible again
			
		    difficultyMenu.setVisible(true); // Makes the difficultyMenu visible again
		    

			resetAlphabetButtons(); //reset letter method
			resetVowelButtons(); //reset vowel letter method
		});
		
		startButtonMM.setOnAction(event -> {  //start
			startButtonMM.setVisible(false);
			exitGameMM.setVisible(false);
			mainMenuScreen.setVisible(false);
			difficultyMenu.setVisible(true);
		});
		
	}
	
	private String guessedVowel; 

	@FXML
	private void buttonVowelClicked(ActionEvent event) { //action for when vowels are clicked
	    Button clickedButton = (Button) event.getSource();
	    guessedVowel = clickedButton.getText();
	       // Randomly choose between opening dotGame.fxml or MathQuiz
        if (Math.random() < 0.4) {
            // Open dotGame
            openDotGame();
        } 
        else if(Math.random() < 0.3){
            // Open MathQuiz
            new MathQuizcompiler(this, guessedVowel);
        } else {
        	// Open GuessingGame
        	openGuessingGame();
        }
	}
	
	private void openDotGame() { //Load dot game
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dotGame.fxml"));
	        Parent root = fxmlLoader.load();
	        dotGameController controller = fxmlLoader.getController();
	        controller.setHangmanController(this);
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void openGuessingGame() { //Load guessing game
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuessingScene.fxml"));
            Parent root = fxmlLoader.load();
	        GuessingGameController controller = fxmlLoader.getController();
	        controller.setHangmanController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public hangmanGameController() { //For list txt
        this.easyWords = new ArrayList<>();
        this.mediumWords = new ArrayList<>();
        this.hardWords = new ArrayList<>();
        loadEasyWordsFromFile("src/easyWordList.txt"); 
        loadMediumWordsFromFile("src/mediumWordList.txt"); 
        loadHardWordsFromFile("src/hardWordList.txt"); 
    }
	
    private void loadEasyWordsFromFile(String easyWordList) {
        try (BufferedReader br = new BufferedReader(new FileReader(easyWordList))) {
            String line;
            while ((line = br.readLine()) != null) {
                easyWords.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading words from file: " + e.getMessage());
        }
    }
    
    private void loadMediumWordsFromFile(String mediumWordList) {
        try (BufferedReader br = new BufferedReader(new FileReader(mediumWordList))) {
            String line;
            while ((line = br.readLine()) != null) {
                mediumWords.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading words from file: " + e.getMessage());
        }
    }

    private void loadHardWordsFromFile(String hardWordList) {
        try (BufferedReader br = new BufferedReader(new FileReader(hardWordList))) {
            String line;
            while ((line = br.readLine()) != null) {
                hardWords.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading words from file: " + e.getMessage());
        }
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

    public void replaceVowel(String guessedVowel) { //Replace Vowel method for Math game
        StringBuilder updatedText = new StringBuilder(text.getText());
        char guessedChar = guessedVowel.toLowerCase().charAt(0);
        System.out.println("Guessed vowel: " + guessedChar);

        int index = 0; // Initialize index for searching underscores
        while ((index = updatedText.indexOf("_", index)) != -1) {
            // Check if the character at the corresponding index in the random word is the guessed vowel
            if (randomWord.toLowerCase().charAt(index / 2) == guessedChar) {
                updatedText.setCharAt(index, Character.toUpperCase(guessedChar)); // Replace the underscore with the vowel
            }
            index++; 
        }

        System.out.println("Updated text: " + updatedText.toString());
        text.setText(updatedText.toString());
    }

    public void replaceVowelForDotGame() { //Replace Vowel method for Dot Game
        StringBuilder updatedText = new StringBuilder(text.getText());
        char guessedChar = guessedVowel.toLowerCase().charAt(0);
        System.out.println("Guessed vowel: " + guessedChar);

        int index = 0; 
        while ((index = updatedText.indexOf("_", index)) != -1) {
            if (randomWord.toLowerCase().charAt(index / 2) == guessedChar) {
                updatedText.setCharAt(index, Character.toUpperCase(guessedChar)); 
            }
            index++; 
        }
        text.setText(updatedText.toString());
        // Darken and disable the used vowel button
        darkenAndDisableVowels(guessedVowel);
    }
    
    public void replaceVowelForGuessingGame() { //Replace Vowel method for Guessing game
        StringBuilder updatedText = new StringBuilder(text.getText());
        char guessedChar = guessedVowel.toLowerCase().charAt(0);
        System.out.println("Guessed vowel: " + guessedChar);

        int index = 0; 
        while ((index = updatedText.indexOf("_", index)) != -1) {
            if (randomWord.toLowerCase().charAt(index / 2) == guessedChar) {
                updatedText.setCharAt(index, Character.toUpperCase(guessedChar));
            }
            index++; 
        }
        text.setText(updatedText.toString());
        // Darken and disable the used vowel button
        darkenAndDisableVowels(guessedVowel);
    }
    
    private void resetVowelButtons() { //Reset vowels
        List<Button> vowelButtons = Arrays.asList(aButton, eButton, iButton, oButton, uButton);

        for (Button button : vowelButtons) {
        	button.setStyle("-fx-background-color: #990011; -fx-text-fill: white;");
            button.setDisable(false);
        }
    }
    
}