import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class dotGameController {
	
    private double dotX = 0;
    private double dotY = 0;
    private double stepSize = 1.0; // Ball speed
    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    private long lastDirectionChangeTime1 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime2 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime3 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime4 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime5 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime6 = System.currentTimeMillis() / 1000;
    private long lastDirectionChangeTime7 = System.currentTimeMillis() / 1000;
    private double redDot1SpeedX = 0.0;
    private double redDot1SpeedY = 0.0;
    private double redDot2SpeedX = 0.0;
    private double redDot2SpeedY = 0.0;
    private double redDot3SpeedX = 0.0;
    private double redDot3SpeedY = 0.0;
    private double redDot4SpeedX = 0.0;
    private double redDot4SpeedY = 0.0;
    private double redDot5SpeedX = 0.0;
    private double redDot5SpeedY = 0.0;
    private double redDot6SpeedX = 0.0;
    private double redDot6SpeedY = 0.0;
    private double redDot7SpeedX = 0.0;
    private double redDot7SpeedY = 0.0;
    private final long directionChangeIntervalSeconds = 1; // 1 second
    private int countdownSeconds = 10; //timer in seconds
    private Timeline timeline;
    private Random random = new Random();
    private hangmanGameController hangmanController; //instance to use hangman methods
    public dotGameController(hangmanGameController hangmanController) {
        this.hangmanController = hangmanController;
    }
    public dotGameController() {
    }
    public void setHangmanController(hangmanGameController hangmanController) {
        this.hangmanController = hangmanController;
    }
    
    @FXML
    private Circle blueDot;

    @FXML
    private Circle redDot1;
    
    @FXML
    private Circle redDot2;
    
    @FXML
    private Circle redDot3;
    
    @FXML
    private Circle redDot4;
    
    @FXML
    private Circle redDot5;
    
    @FXML
    private Circle redDot6;
    
    @FXML
    private Circle redDot7;
    
    @FXML
    private Label timerLabel;
    
    @FXML
    private Pane playPane;

    @FXML
    private Pane winDotScreen;
    
    @FXML
    private Button returnButton;
    
    @FXML
    private Pane loseDotScreen;
    
    @FXML
    private Button returnButton2;
    
    @FXML
    private Button startMenuButton;
    
    @FXML
    private Pane startScreen;
    
    

    @FXML
    public void handleKeyPress(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        switch (keyCode) {
            case W:
                wPressed = true;
                break;
            case A:
                aPressed = true;
                break;
            case S:
                sPressed = true;
                break;
            case D:
                dPressed = true;
                break;
            default:
                break;
        }
    }

    @FXML
    public void handleKeyRelease(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        switch (keyCode) {
            case W:
                wPressed = false;
                break;
            case A:
                aPressed = false;
                break;
            case S:
                sPressed = false;
                break;
            case D:
                dPressed = false;
                break;
            default:
                break;
        }
    }

    private void updatePosition() {
        // Update blue dot position based on key presses
        if (wPressed) {
            dotY -= stepSize;
        }
        if (aPressed) {
            dotX -= stepSize;
        }
        if (sPressed) {
            dotY += stepSize;
        }
        if (dPressed) {
            dotX += stepSize;
        }

        // Update blue dot position
        blueDot.setTranslateX(dotX);
        blueDot.setTranslateY(dotY);
        
        moveRedDot(redDot1, lastDirectionChangeTime1);
        moveRedDot(redDot2, lastDirectionChangeTime2);
        moveRedDot(redDot3, lastDirectionChangeTime3);
        moveRedDot(redDot4, lastDirectionChangeTime4);
        moveRedDot(redDot5, lastDirectionChangeTime5);
        moveRedDot(redDot6, lastDirectionChangeTime6);
        moveRedDot(redDot7, lastDirectionChangeTime7);

        // Check collision with red dots
        if (blueDot.getBoundsInParent().intersects(redDot1.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot2.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot3.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot4.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot5.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot6.getBoundsInParent()) ||
            blueDot.getBoundsInParent().intersects(redDot7.getBoundsInParent())) {
            // Collision detected, handle losing condition
            handleCollision();
        }
    }

    private void moveRedDot(Circle redDot, long lastDirectionChangeTime) {
        long currentTime = System.currentTimeMillis() / 200;
        long elapsedTime = currentTime - lastDirectionChangeTime;
        
        if (elapsedTime >= directionChangeIntervalSeconds) {
            double speedX = (random.nextDouble() - 0.5) * 2.5; // Adjust the speed
            double speedY = (random.nextDouble() - 0.5) * 2.5; // Adjust the speed
            if (redDot == redDot1) {
                redDot1SpeedX = speedX;
                redDot1SpeedY = speedY;
                lastDirectionChangeTime1 = currentTime;
            } 
            else if (redDot == redDot2) {
                redDot2SpeedX = speedX;
                redDot2SpeedY = speedY;
                lastDirectionChangeTime2 = currentTime;
            }
            else if (redDot == redDot3) {
                redDot3SpeedX = speedX;
                redDot3SpeedY = speedY;
                lastDirectionChangeTime3 = currentTime;
            }
            else if (redDot == redDot4) {
                redDot4SpeedX = speedX;
                redDot4SpeedY = speedY;
                lastDirectionChangeTime4 = currentTime;
            }
            else if (redDot == redDot5) {
        		redDot5SpeedX = speedX;
        		redDot5SpeedY = speedY;
        		lastDirectionChangeTime5 = currentTime;
        	}
            else if (redDot == redDot6) {
        		redDot6SpeedX = speedX;
        		redDot6SpeedY = speedY;
        		lastDirectionChangeTime6 = currentTime;
        	}
            else if (redDot == redDot7) {
        		redDot7SpeedX = speedX;
        		redDot7SpeedY = speedY;
        		lastDirectionChangeTime7 = currentTime;
        	}
        }

        double speedX, speedY;
        if (redDot == redDot1) {
            speedX = redDot1SpeedX;
            speedY = redDot1SpeedY;
        }
        else if (redDot == redDot2) {
            speedX = redDot2SpeedX;
            speedY = redDot2SpeedY;
        }
        else if (redDot == redDot3) {
            speedX = redDot3SpeedX;
            speedY = redDot3SpeedY;
        }
        else if (redDot == redDot4) {
            speedX = redDot4SpeedX;
            speedY = redDot4SpeedY;
        }
        else if (redDot == redDot5) {
            speedX = redDot5SpeedX;
            speedY = redDot5SpeedY;
        }
        else if (redDot == redDot6) {
            speedX = redDot6SpeedX;
            speedY = redDot6SpeedY;
        }
        else if (redDot == redDot7) {
            speedX = redDot7SpeedX;
            speedY = redDot7SpeedY;
        }
        else {
            // Handle the case where redDot is not one of the expected red dots
            speedX = 0.0;
            speedY = 0.0;
        }

        // Calculate new position
        double newX = redDot.getTranslateX() + speedX;
        double newY = redDot.getTranslateY() + speedY;

        // Ensure the red dot stays within the boundaries of the pane
        double radius = redDot.getRadius();
        double minX = radius;
        double maxX = playPane.getWidth() - radius;
        double minY = radius;
        double maxY = playPane.getHeight() - radius;

        // Adjust newX and newY if they exceed the pane boundaries
        newX = Math.max(minX, Math.min(newX, maxX));
        newY = Math.max(minY, Math.min(newY, maxY));

        // Update red dot position
        redDot.setTranslateX(newX);
        redDot.setTranslateY(newY);
    }
    

    private void handleCollision() {
        // Stop the timer
        timeline.stop();
        
        // Make the loseDotScreen visible
        loseDotScreen.setVisible(true);
        
        // Hide the red dots
        redDot1.setDisable(true);
        redDot2.setDisable(true);
        redDot3.setDisable(true);
        redDot4.setDisable(true);
        redDot5.setDisable(true);
        redDot6.setDisable(true);
        redDot7.setDisable(true);
        
        redDot1.setVisible(false);
        redDot2.setVisible(false);
        redDot3.setVisible(false);
        redDot4.setVisible(false);
        redDot5.setVisible(false);
        redDot6.setVisible(false);
        redDot7.setVisible(false);
    }
    
    private void handleWin() {
        // Stop the timer
        timeline.stop();
        
        // Make the winDotScreen visible
        winDotScreen.setVisible(true);
        
        //Disable the blue dot
        blueDot.setDisable(true);
        
        // Hide the red dots
        redDot1.setDisable(true);
        redDot2.setDisable(true);
        redDot3.setDisable(true);
        redDot4.setDisable(true);
        redDot5.setDisable(true);
        redDot6.setDisable(true);
        redDot7.setDisable(true);
        
        redDot1.setVisible(false);
        redDot2.setVisible(false);
        redDot3.setVisible(false);
        redDot4.setVisible(false);
        redDot5.setVisible(false);
        redDot6.setVisible(false);
        redDot7.setVisible(false);
    }
    
    @FXML
    private void returnLose(ActionEvent event) {
        returnButton2.getScene().getWindow().hide();
    }
    
    
    public void returnWin() {
        if (hangmanController != null) {
            hangmanController.replaceVowelForDotGame();
            returnButton.getScene().getWindow().hide();
        } else {
            System.err.println("Error: hangmanController is null");
        }
    }
    

    

    @FXML
    public void initialize() {
        startMenuButton.setOnAction(this::handleStartButtonClick);
    }

    private void handleStartButtonClick(ActionEvent event) {
        startScreen.setVisible(false);
        
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePosition();
            }
        };
        animationTimer.start();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), this::updateTimer);
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }

    private void updateTimer(ActionEvent event) {
        if (countdownSeconds > 0) {
            countdownSeconds--;
            timerLabel.setText(formatTime(countdownSeconds));
        } else {
            handleWin(); 
        }
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%d:%02d", minutes, remainingSeconds);
    }
}