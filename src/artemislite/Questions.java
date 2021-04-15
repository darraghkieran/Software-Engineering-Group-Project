/**
 * 
 */
package artemislite;

/**
 * @author aj93
 *
 */
public class Questions {
	
	//instance vars 
	private String question;
	private String answer;
	
	
	/**
	 * Default constructor
	 */
	public Questions() {
		
	}

	/**
	 * constructor with args 
	 * @param question
	 * @param answer
	 */
	public Questions(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

}
