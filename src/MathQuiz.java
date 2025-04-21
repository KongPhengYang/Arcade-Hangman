import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;




public class MathQuiz extends JFrame implements ActionListener {

    private hangmanGameController gameController;
    private String guessedVowel;
	
	private static final long serialVersionUID = 1L;
	JLabel title = new JLabel("Math Quiz Minigame!");
	JLabel line1 = new JLabel("--------");
	JLabel line2 = new JLabel("--------");
	JLabel question = new JLabel();
	JLabel answer = new JLabel("Answer: ");
	JLabel gameoverLose = new JLabel();
	JLabel gameoverWin = new JLabel();
	JLabel Instructions = new JLabel("<html>If you get 3 different math problems correct then you win the vowel <br/><html>"
			+ "and if you get three wrong then you lose the vowel and maybe the game!");
	JButton playButton = new JButton("Play!");
	JButton Instruct = new JButton("Instructions!");
	JButton Mult = new JButton("*");
	JButton Addition = new JButton("+");
	JButton Subtract = new JButton("-");
	JButton Division = new JButton("/");
	JButton ReturnWin = new JButton("Return!");
	JButton ReturnLose = new JButton("GET OUT!");
	
	JTextField answerField = new JTextField(10);
	JTextField remarksField = new JTextField(15);
	
	Random random = new Random();
	int digit1;
	int digit2;
	int correctAnswer;
	int rightCounter1=0;
	int wrongCounter1=0;
	final int limitLose = 3;
	final int limitWin = 3;
	String operator="";
	
	
	public MathQuiz(hangmanGameController gameController, String guessedVowel) {
        this.gameController = gameController;
        this.guessedVowel = guessedVowel;
        
		setLayout(new FlowLayout());
		add(title);
		add(line1);
		add(question);
		add(line2);
		add(answer);
		add(answerField);
		add(Mult);
		add(Addition);
		add(Subtract);
		add(Division);
		add(remarksField);
		add(playButton);
		add(Instruct);
		add(gameoverLose);
		add(gameoverWin);
		add(ReturnWin);
		add(ReturnLose);
		add(Instructions);
		
		Instructions.setVisible(false);
		ReturnWin.setVisible(false);
		ReturnLose.setVisible(false);
		line1.setVisible(false);
		gameoverLose.setVisible(false);
		gameoverWin.setVisible(false);
		question.setVisible(false);
		line2.setVisible(false);
		answer.setVisible(false);
		answerField.setVisible(false);
		Mult.setVisible(false);
		Addition.setVisible(false);
		Subtract.setVisible(false);
		Division.setVisible(false);
		remarksField.setVisible(false);
		
		/* 
		 * Styles of color in foreground and background.
		 */
		getContentPane().setBackground(new Color(245, 245, 220));
		question.setForeground(Color.white);
		answerField.setForeground(Color.black);
		Addition.setForeground(Color.white);
		Subtract.setForeground(Color.white);
		Mult.setForeground(Color.white);
		Division.setForeground(Color.white);
		gameoverLose.setForeground(Color.white);
		gameoverWin.setForeground(Color.white);
		
		Mult.setBackground(new Color(153, 0, 17));
		Addition.setBackground(new Color(153, 0, 17));
		Subtract.setBackground(new Color(153, 0, 17));
		Division.setBackground(new Color(153, 0, 17));
		playButton.setBackground(new Color(153, 0, 17));
		Instruct.setBackground(new Color(153, 0, 17));
		ReturnWin.setBackground(new Color(153, 0, 17));
		ReturnLose.setBackground(new Color(153, 0, 17));
		/* 
		 * Fonts and Sizes
		 */
		ReturnLose.setFont(new Font("System", Font.BOLD, 75));
		ReturnWin.setFont(new Font("System", Font.BOLD, 75));
		playButton.setFont(new Font("System", Font.BOLD, 100));
		Instruct.setFont(new Font("System", Font.BOLD, 60));
		gameoverLose.setFont(new Font("System", Font.BOLD,95));
		gameoverWin.setFont(new Font("System", Font.BOLD,75));
		Instructions.setFont(new Font("System", Font.PLAIN,15));
		
		title.setFont(new Font("System", Font.BOLD,50));
		line1.setFont(new Font("System", Font.PLAIN,35));
		line2.setFont(new Font("System", Font.PLAIN,35));
		question.setFont(new Font("System", Font.PLAIN,35));
		answer.setFont(new Font("System", Font.PLAIN,70));
		answerField.setFont(new Font("System", Font.PLAIN,35));
		remarksField.setFont(new Font("System", Font.PLAIN,35));
		Mult.setFont(new Font("System", Font.PLAIN,35));
		Addition.setFont(new Font("System", Font.PLAIN,35));
		Subtract.setFont(new Font("System", Font.PLAIN,35));
		Division.setFont(new Font("System", Font.PLAIN,35));
		remarksField.setHorizontalAlignment(JTextField.CENTER);
        
		ReturnLose.addActionListener(this);
		ReturnWin.addActionListener(this);
		playButton.addActionListener(this);
		answerField.addActionListener(this);
		Instruct.addActionListener(this);
		Mult.addActionListener(this);
		Addition.addActionListener(this);
		Subtract.addActionListener(this);
		Division.addActionListener(this);
		
		setTitle("Math Quiz MiniGame");
		setSize(600,500);
		setLocation(900,100);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == ReturnWin) {
		    // Close the Math Quiz application
		    dispose();
		    // Darken and disable the specific vowel button
		    gameController.darkenAndDisableVowels(guessedVowel);
		    // Replace the vowel in hangman game
		    gameController.replaceVowel(guessedVowel);
		}
		
		if (e.getSource() == ReturnLose) {
		    // Close the Math Quiz application
		    dispose();
		}
		
		
		
		if(e.getSource() == Instruct) {
			getContentPane().setBackground(new Color(245, 245, 220));
			Instructions.setVisible(true);
			playButton.setVisible(true);
			Instruct.setVisible(false);
			question.setVisible(false);
			answer.setVisible(false);
			line1.setVisible(false);
			line2.setVisible(false);
			answerField.setVisible(false);
			answerField.setEditable(false);
			Mult.setVisible(false);
			Addition.setVisible(false);
			Subtract.setVisible(false);
			Division.setVisible(false);
			remarksField.setVisible(false);
			answerField.setVisible(false);
			answerField.setEditable(false);
			remarksField.setEditable(false);
		}
		if(e.getSource() == playButton) {
			getContentPane().setBackground(new Color(245, 245, 220));
			Instructions.setVisible(false);
			playButton.setVisible(false);
			question.setVisible(true);
			answer.setVisible(true);
			line1.setVisible(true);
			line2.setVisible(true);
			answerField.setVisible(false);
			answerField.setEditable(true);
			Mult.setVisible(true);
			Addition.setVisible(true);
			Subtract.setVisible(true);
			Division.setVisible(true);
			remarksField.setVisible(true);
			answerField.setVisible(true);
			answerField.setEditable(false);
			remarksField.setEditable(false);
		}
		if(e.getSource() == Mult) {
			operator="*";
			question.setText(setQuestion(operator));
			answerField.setEditable(true);
			question.setForeground(Color.blue);
			
		}
		if(e.getSource() == Addition) {
			operator="+";
			question.setText(setQuestion(operator));
			answerField.setEditable(true);
			question.setForeground(Color.red);
		}
		if(e.getSource() == Subtract) {
			operator="-";
			question.setText(setQuestion(operator));
			answerField.setEditable(true);
			question.setForeground(new Color(79, 121, 66));
		}
		if(e.getSource() == Division) {
			operator="/";
			question.setText(setQuestion(operator));
			answerField.setEditable(true);
			question.setForeground(new Color(184, 115, 51));
		}
		if(e.getSource() == answerField) {
			int userAnswer = Integer.parseInt(answerField.getText());
			if(userAnswer == correctAnswer) {
				remarksField.setForeground(Color.blue);
				remarksField.setText(getCorrectResponse());
				answerField.setText("");
				question.setText(setQuestion(operator));
			if(rightCounter1 == limitLose) {
				getContentPane().setBackground(Color.black);
				title.setForeground(Color.white);
				gameoverWin.setText("YOU'VE WON");
				gameoverWin.setVisible(true);
				ReturnWin.setVisible(true);
				question.setVisible(false);
				line2.setVisible(false);
				answer.setVisible(false);
				answerField.setVisible(false);
				answerField.setEditable(false);
				Mult.setVisible(false);
				Addition.setVisible(false);
				Subtract.setVisible(false);
				Division.setVisible(false);
				remarksField.setVisible(false);
				answerField.setVisible(false);
				answerField.setEditable(false);
				}
			}
			else {
				remarksField.setForeground(Color.red);
				remarksField.setText(getWrongResponse());
				answerField.setText("");
				
				if(wrongCounter1 == limitLose) {
					getContentPane().setBackground(Color.black);
					title.setForeground(Color.white);
					gameoverLose.setText("GAME OVER");
					Instruct.setVisible(false);
					gameoverLose.setVisible(true);
					ReturnLose.setVisible(true);
					question.setVisible(false);
					line2.setVisible(false);
					answer.setVisible(false);
					answerField.setVisible(false);
					answerField.setEditable(false);
					Mult.setVisible(false);
					Addition.setVisible(false);
					Subtract.setVisible(false);
					Division.setVisible(false);
					remarksField.setVisible(false);
					answerField.setVisible(false);
					answerField.setEditable(false);
				}
		        
				}
			}
		}
				
				
				public String getCorrectResponse() {
					String response ="";
					rightCounter1++;
					switch(random.nextInt(2)) {
						case 0: response = "Good Job"; break;
						case 1: response = "You Got It Right!"; break;
						case 2: response = "You Win!"; break;
					}
					return response;
				}
				
				public String getWrongResponse() {
					String response ="";
					wrongCounter1++;
					switch(random.nextInt(2)) {
						case 0: response = "Oh No You Got It Wrong!"; break;
						case 1: response = "Try Again!"; break;
						case 2: response = "I Believe In You!"; break;
					}
					return response;
				}
				
				public int getRandomNumber() {
					return random.nextInt(15);
					
				}
				public String setQuestion(String operator) {
					digit1 = getRandomNumber();
					digit2 = getRandomNumber();
					
					switch(operator) {
						case "*": correctAnswer = digit1 * digit2; break;
						case "+": correctAnswer = digit1 + digit2; break;
						case "-": correctAnswer = digit1 - digit2; break;
						case "/": 
						if(digit1 == 0) {
								digit1++;
								if(digit2 == 0)
									digit2++;
						}
						else if(digit2 == 0)
							digit2++;
							
						correctAnswer = digit1 / digit2; 
						break;
					}
					return "How Much is " + digit1 + operator + digit2 + " ? ";
				}
				
	
		
	}
	
	

