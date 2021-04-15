package artemislite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mark
 *
 */
public class MiniGames {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		
		// nasa game
		/*
		if(nasaQuiz() == true) {
			System.out.println("Congrats! You have won your major development!");
		} else {
			System.out.println("Try again loser!");
		}
		*/

		/*
		Map<String, String> map = new HashMap<>();
		map.put("How many months are there in 12 years?\n a) 144\n b) 142\n c) 124\n", "a");
		map.put("What is NASA's motto?\n a) To infity and beyond\n b) For the love of space exploration\n c) For the benefit of all\n", "c");
		map.put("Which mission of NASA brought the first human to the Moon?\n a) apollo\n b) mercury\n c)gemini\n",
				"a");
		map.put("What is 25 - 4 x 3?\n a)63\n b)13\n c)37\n ", "b");

		Set<String> keySet = map.keySet();
		// converting set to list
		List<String> keyList = new ArrayList<>(keySet);

		int size = keyList.size();

		int ans = 0;
		Scanner sc = new Scanner(System.in);
		for (String s : map.keySet()) {
			// System.out.print("Enter a string: ");
			String str = "";

			int randIdx = new Random().nextInt(size);
			String randomKey = keyList.get(randIdx);
			String randomValue = map.get(randomKey);
			// System.out.println("key: " + randomKey + ", value: " + randomValue);
			System.out.println(randomKey);
			str = sc.nextLine();
			// reads string
			if (str.equals(randomValue)) {
				ans++;

			}
		}
		sc.close();


		System.out.println("Your Score is " + ans);

	
	*/
		
	}
		
	public static void quizLevelOne() {
		
		Map<String, String> map = new HashMap<>();
		map.put("How many months are there in 12 years?\n a) 124\n b) 142\n c) 144\n", "c");
		map.put("What is NASA's motto?\n a) To infity and beyond\n b) For the love of space exploration\n c) For the benefit of all\n", "c");
		map.put("Which mission of NASA brought the first human to the Moon?\n a) apollo\n b) mercury\n c)gemini\n",
				"a");
		

		Set<String> keySet = map.keySet();
		// converting set to list
		List<String> keyList = new ArrayList<>(keySet);

		int size = keyList.size();

		int ans = 0;
		Scanner sc = new Scanner(System.in);
		for (String s : map.keySet()) {
			// System.out.print("Enter a string: ");
			String str = "";

			int randIdx = new Random().nextInt(size);
			String randomKey = keyList.get(randIdx);
			String randomValue = map.get(randomKey);
			// System.out.println("key: " + randomKey + ", value: " + randomValue);
			System.out.println(randomKey);
			str = sc.nextLine();
			// reads string
			if (str.equals(randomValue)) {
				ans++;

			}
		}
		System.out.println("Your Score is " + ans);
	}	
		
		public static void quizLevelTwo() {
			
			Map<String, String> map = new HashMap<>();
			
			map.put("Which planet has the most moons?\n a) Neptune\n b) Jupiter\n c) Saturn\n", "c");
			map.put("What is 4/5 as a decimal?\n a) 0.8\n b) 0.45\n c) 4.5\n", "a");
			map.put("Which mission of NASA brought the first human to the Moon?\n a) apollo\n b) mercury\n c)gemini\n",
					"a");
			

			Set<String> keySet = map.keySet();
			// converting set to list
			List<String> keyList = new ArrayList<>(keySet);

			int size = keyList.size();

			int ans = 0;
			Scanner sc = new Scanner(System.in);
			for (String s : map.keySet()) {
				// System.out.print("Enter a string: ");
				String str = "";

				int randIdx = new Random().nextInt(size);
				String randomKey = keyList.get(randIdx);
				String randomValue = map.get(randomKey);
				// System.out.println("key: " + randomKey + ", value: " + randomValue);
				System.out.println(randomKey);
				str = sc.nextLine();
				// reads string
				if (str.equals(randomValue)) {
					ans++;

				}
			}
			
		

			System.out.println("Your Score is " + ans);
		}
		
		
		public static void quizLevelThree() {
			
Map<String, String> map = new HashMap<>();
			
			map.put("Uranus has only been visited by which spacecraft?\n a) The ArtemisLite\n b) The Voyager 2\n c) The Orion 2\n", "c");
			map.put("Which is the second smallest planet?\n a) Mars\n b) Jupiter\n c) Earth\n", "a");
			map.put("What is 25 - 4 x 3?\n a)63\n b)13\n c)37\n ", "b");

			Set<String> keySet = map.keySet();
			// converting set to list
			List<String> keyList = new ArrayList<>(keySet);

			int size = keyList.size();

			int ans = 0;
			Scanner sc = new Scanner(System.in);
			for (String s : map.keySet()) {
				// System.out.print("Enter a string: ");
				String str = "";

				int randIdx = new Random().nextInt(size);
				String randomKey = keyList.get(randIdx);
				String randomValue = map.get(randomKey);
				// System.out.println("key: " + randomKey + ", value: " + randomValue);
				System.out.println(randomKey);
				str = sc.nextLine();
				// reads string
				if (str.equals(randomValue)) {
					ans++;

				}
			}
			
			
			
		}
		
	
	
	public static boolean nasaQuiz() {
		
		MultiChoiceQuiz q1 = new MultiChoiceQuiz("NASA stands for the National ____ and Space Administration. Fill in the blank.", "Astronomy", "Aeronautics", "Acrobatic", "Airplane", "B");
		MultiChoiceQuiz q2 = new MultiChoiceQuiz("When was NASA founded?", "1945", "1958", "1969", "1980", "B");
		MultiChoiceQuiz q3 = new MultiChoiceQuiz();
		q3.setQuestion("True or false? The first person in space was an American.");
		q3.setChoice1("True");
		q3.setChoice2("False");
		q3.setCorrectAnswer("B");
		MultiChoiceQuiz q4 = new MultiChoiceQuiz("NASA quarantined the astronauts who landed on the moon when they returned to Earth?.Why?", "Moon germs", "Rest", "Adjusting to gravity", "Dizziness", "A");
		MultiChoiceQuiz q5 = new MultiChoiceQuiz("Which of these is not an Apollo command module name?", "Garfield", "Gumdrop", "Charlie Brown", "Casper", "A");

		ArrayList<MultiChoiceQuiz> questions = new ArrayList<MultiChoiceQuiz>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);

		int score = 0;
		Scanner userInput = new Scanner(System.in);
		boolean correctInput = false;
		
		System.out.println(" ");
		
		for (MultiChoiceQuiz question : questions) {

			System.out.println("Question : "  + question.getQuestion() + "\n");
			System.out.println("\t A. " + question.getChoice1());
			System.out.println("\t B. " + question.getChoice2());
			if(question.getChoice3() != null) {
				System.out.println("\t C. " + question.getChoice3());
			}
			if(question.getChoice4() != null) {
				System.out.println("\t D. " + question.getChoice4());
			}
			// TODO - if a question only has 2 choices a business rule needs added to stop the use of "C" & "D" as options.
			do {
				String answer = userInput.nextLine();
				if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D")) {
					if (answer.equalsIgnoreCase(question.getCorrectAnswer())) {
						score++;
						correctInput = true;
					}
				} else {
					System.out.println("You have entered the wrong character");
				}
			} while (!correctInput);
			
		}


		System.out.println("You got " + score + "/" + questions.size());
		
		if(score >= questions.size() - 2) {
			return true;
		}
		return false;
		
		
		// System.out.println("Questions by www.nationalgeographic.com/science");
		
	}
	
	/*
		 //level 1 of minigame difficulty easy questions
		 HashMap<String, String> quiz1 = new HashMap<>();

		 quiz1.put("Which mission of NASA brought the first human to the Moon?\n" +
		 "a) Apollo Mission\n b) Gemini Mission\n c) Mercury Mission", "a");
		 quiz1.put("When did NASA launch their first mission to the sun?\n" +
		 "a) 2016\n b) 2017\n c) 2018\n", "c"); quiz1.put("What is NASA's motto\n" +
		 ("a) To infity and beyond\n b) For the love of space exploration\n c) For the benefit of all\n"
		 ), "c");

		 //level 2 minigame difficulty medium questions HashMap<String, String> quiz2
		 = new HashMap<>();

		 quiz2.put("How many months are there in 12 years?\n" +
		 "a) 124\n b) 142\n c) 144\n", "c"); quiz2.put("What is 4/5 as a decimal?\n" +
		 "a) 0.8\n b) 0.45\n c) 4.5\n" , "a"); quiz2.put("What is 25 - 4 x 3?\n" +
		 "a)63\n b)13\n c)37\n ", "b");


		 // level 3 minigame difficulty hardest questions HashMap<String, String>
		 quiz3 = new HashMap<>();

		 quiz3.put("What is the sun's outermost atmosphere called?\n" +
		 "a)Karena\n b)Alona\n c)Corona\n", "c");
		 quiz3.put("Which is the second smallest Planet?\n" +
		 " a)Mars\n b)Earth\n c)Jupiter\n", "a");
		 quiz3.put("Uranus has only been visited by which spacecraft?\n" +
		 "a)Artemis 1, b) The Voyager 2, c) The Orion", "b");

	 }


	 // TODO The main method is just here to test your game! String q1 =
	 "Which mission of Nasa brought the first human to the Moon?\n" +
	 "a) Apollo Mission\n b) Gemini Mission\n c) Mercury Mission";

	 String q2 = "When did Nasa launch their first mission to the sun?\n" +
	 "a) 2016\n b) 2017\n c) 2018\n";

	 String q3 = "What is 4/5s as a decimal?\n" + "a) 0.8\n b) 0.45\n c) 4.5\n";

	 String q4 = "What is 25 - 4 x 3?\n" + "a) 63\n b) 13\n c) 37\n";

	 Questions[] questions = { new Questions(q1, "a"), new Questions(q2, "c"), new
	 Questions(q3, "a"), new Questions(q4, "b") };


	 public static void playMinigame(Questions[] questions) { int score = 0;
	 Scanner userInput = new Scanner(System.in);

	 for (Questions question : questions) {
	 System.out.println(question.getQuestion()); String answer =
	 userInput.nextLine(); if (answer.equals(question.getAnswer())) { score++; } }

	 userInput.close(); System.out.println("You got " + score + "/" +
	 questions.length); }

	public void navigationGame() {

		// TODO - Thought this could be a simple math game!

		 Example

		 Q1. You are traveling at X speed what distance will you travel by X
		 distance??

		 A. wrong answer B. correct answer C. wrong answer D. wrong answer


		 Q2. What is X * Y - Z? A. correct answer

		 Add up all the correct answers up -> if you answer over 60% you win the game
		 and get a major development


		 return winner/loser;

	}

	 */

	public void whatIsArtemisGame() {

		// TODO - Thought this could be simple questions about the Artemis Project -
		// Could also have another game about the History of NASA

		/**
		 * Example
		 * 
		 * Q1. What is the name of the docking module?
		 * 
		 * A. LUNAR B. ORION C. SLS D. EXPLORER
		 * 
		 * 
		 * return winner/loser;
		 */

	}

	// Other Games ... ...

}
