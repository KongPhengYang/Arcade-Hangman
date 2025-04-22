# Welcome to **Arcade Hangman**  
*The ultimate word-guessing game*

---

### Objective

Select your preferred **difficulty** to begin.  
You will be given a **random word** based on the chosen difficulty level. Your goal is to solve this word — but with a twist!  

With all **vowels LOCKED**, you'll need to **complete a series of random minigames** to unlock them.  
Only after beating those minigames will your vowels be revealed.  
Solve the word to **win the game**!

---

### Font Setup

>  **Download the custom font** used for the game to ensure proper formatting and the best visual experience.

---

### Setup Instructions

#### Step 1: Download the Game Files
Download all required files for the game from the provided link or repository.

#### Step 2: Set Up JavaFX in Eclipse

1. **Install JavaFX SDK version 8.**  
2. In Eclipse:
   - Right-click your project → **Properties** → **Java Build Path** → **Libraries**
   - Click on **Module Path** → **Add External JARs** → Select the **JavaFX SDK JARs**
3. Go to **Run Configuration** → **Arguments**  
   Add the following to **VM arguments**:
   --module-path /path/to/javafx-sdk-<version>/lib --add-modules javafx.controls,javafx.fxml
   
*(Replace `/path/to/javafx-sdk-<version>/lib` with the actual path to your SDK folder.)*

#### Step 3: Launch the Game

1. Load the project in Eclipse.
2. Launch `TypingGame.java`.
3. On the title screen, click **"Start Game"**.
4. Select your difficulty: **Easy** or **Hard**.
5. Begin typing when prompted.
- Press **Enter** to submit your guess.
- Click **"Try Again"** to retry with a new sentence.
6. Use the **"Main Menu"** button to return to the title screen.


