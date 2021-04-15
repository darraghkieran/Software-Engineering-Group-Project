package artemislite;

public class MultiChoiceQuiz {

	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String correctAnswer;
	
	
	public MultiChoiceQuiz() {
		
	}
	
	/**
	 * @param question
	 * @param choice1
	 * @param choice2
	 * @param choice3
	 * @param choice4
	 * @param correctAnswer
	 */
	public MultiChoiceQuiz(String question, String choice1, String choice2, String choice3, String choice4,
			String correctAnswer) {
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.correctAnswer = correctAnswer;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the choice1
	 */
	public String getChoice1() {
		return choice1;
	}
	/**
	 * @param choice1 the choice1 to set
	 */
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	/**
	 * @return the choice2
	 */
	public String getChoice2() {
		return choice2;
	}
	/**
	 * @param choice2 the choice2 to set
	 */
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	/**
	 * @return the choice3
	 */
	public String getChoice3() {
		return choice3;
	}
	/**
	 * @param choice3 the choice3 to set
	 */
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	/**
	 * @return the choice4
	 */
	public String getChoice4() {
		return choice4;
	}
	/**
	 * @param choice4 the choice4 to set
	 */
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
		
}
