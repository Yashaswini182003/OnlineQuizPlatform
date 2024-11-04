package onlinequizplatform;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform 
{

	private List<Question> questions;
    private int score;
    
    class Question {
        private String questionText;
        private List<String> options;
        private int correctAnswerIndex;

        public Question(String questionText, List<String> options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<String> getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(int answerIndex) {
            return answerIndex == correctAnswerIndex;
        }
    }


    public OnlineQuizPlatform() {
        questions = new ArrayList<>();
        score = 0;
        createQuestions();
    }

    private void createQuestions() {
        List<String> options1 = List.of("A. 2", "B. 3", "C. 4", "D. 5");
        questions.add(new Question("What is 2 + 2?", options1, 2)); // Correct answer: C. 4

        List<String> options2 = List.of("A. Rome", "B. Paris ", "C. Oslo", "D. Dublin");
        questions.add(new Question("What is the capital of France?", options2, 1)); // Correct answer: B. 2

        List<String> options3 = List.of("A. Mercury", "B. Venus", "C. Earth", "D. Mars");
        questions.add(new Question("Which planet is known as the Red Planet?", options3, 3)); // Correct answer: D. Mars
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Quiz Platform!");
        System.out.println("Please answer the following questions:\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.getQuestionText());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-" + q.getOptions().size() + "): ");
            int userAnswer = scanner.nextInt() - 1; // Convert to zero-based index

            if (q.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.getOptions().get(q.correctAnswerIndex) + "\n");
            }
        }

        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close();
    }
	public static void main(String[] args) 
	{
		OnlineQuizPlatform quizPlatform = new OnlineQuizPlatform();
        quizPlatform.startQuiz();

	}

}
