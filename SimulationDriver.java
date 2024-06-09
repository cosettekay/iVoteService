package assignment_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Main class to simulate the iVote service process.
 * It configures a question, generates random students and answers,
 * submits the answers, and prints the results.
 */
public class SimulationDriver {
    public static void main(String[] args) {
        SimulationDriver driver = new SimulationDriver();
        driver.simulate();
    }
    /**
     * Simulates the entire process of the iVote service.
     */
    public void simulate() {
        Random random = new Random();

        // Step 1: Randomly select question type and create corresponding question
        Question question;
        if (random.nextBoolean()) {
            question = new SingleChoiceQuestion(List.of("1. Right", "2. Wrong"));
        } else {
            question = new MultipleChoiceQuestion(List.of("A", "B", "C", "D"));
        }

        // Step 2: Configure the question for VotingService
        VotingService votingService = new VotingService();
        votingService.configureQuestion(question);

        // Step 3: Generate a random number of students and their answers
        int numberOfStudents = random.nextInt(91) + 10; // Random number between 10 and 100
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(UUID.randomUUID().toString());
            String randomAnswer;
            if (question instanceof SingleChoiceQuestion) {
                randomAnswer = question.getCandidateAnswers().get(random.nextInt(question.getCandidateAnswers().size()));
            } else {
                // Generate random multiple answers for multiple-choice question
                int numOfAnswers = random.nextInt(question.getCandidateAnswers().size()) + 1; // at least one answer
                Set<String> selectedAnswers = new HashSet<>();
                while (selectedAnswers.size() < numOfAnswers) {
                    selectedAnswers.add(question.getCandidateAnswers().get(random.nextInt(question.getCandidateAnswers().size())));
                }
                randomAnswer = String.join(",", selectedAnswers);
            }
            student.setAnswer(randomAnswer);
            students.add(student);
        }
        // Print question type and number of students
        String questionType = (question instanceof SingleChoiceQuestion) ? "Single Choice" : "Multiple Choice";
        System.out.println("Question Type: " + questionType);
        System.out.println("Number of Students Answering: " + numberOfStudents);

        // Step 4: Submit all answers to VotingService
        for (Student student : students) {
            votingService.submitAnswer(student);
        }

        // Step 5: Output the results
        votingService.outputStatistics();
    }
}
