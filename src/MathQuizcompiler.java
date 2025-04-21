
public class MathQuizcompiler extends MathQuiz {
	public MathQuizcompiler(hangmanGameController gameController, String guessedVowel) {
		super(gameController, guessedVowel);
	}

	public String getCorrectResponse() {
		String response = "";
		rightCounter1++;

		switch (random.nextInt(5)) {
		case 0:
			response = "Excellent";
			break;
		case 1:
			response = "Very Good!";
			break;
		case 2:
			response = "Correct!";
			break;
		case 3:
			response = "That's Right!";
			break;
		case 4:
			response = "Awesome!";
			break;
		}
		return response;
	}

	public String getWrongResponse() {
		String response = "";
		wrongCounter1++;
		switch (random.nextInt(5)) {
		case 0:
			response = "Wrong!";
			break;
		case 1:
			response = "Sorry, Please Try Again";
			break;
		case 2:
			response = "Dont Give Up!";
			break;
		case 3:
			response = "Try Once More!";
			break;
		case 4:
			response = "Sorry, Incorrect!";
			break;
		}
		return response;
	}

	public int getRandomNumber() {
		return random.nextInt(15);

	}

	public String setQuestion(String operator) {
		digit1 = getRandomNumber();
		digit2 = getRandomNumber();

		switch (operator) {
		case "*":
			correctAnswer = digit1 * digit2;
			break;
		case "+":
			correctAnswer = digit1 + digit2;
			break;
		case "-":
			correctAnswer = digit1 - digit2;
			break;
		case "/":
			if (digit1 == 0) {
				digit1++;
				if (digit2 == 0)
					digit2++;
			} else if (digit2 == 0)
				digit2++;

			correctAnswer = digit1 / digit2;
			break;
		}
		return "How Much is " + digit1 + operator + digit2 + " ? ";
	}

}
