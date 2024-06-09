package assignment_1;
import java.util.HashMap;
import java.util.Map;
/**
 * Class representing the voting service which handles question configuration,
 * answer submissions, and outputting statistics.
 */
class VotingService {
    private Question question;
    private Map<String, String> submissions;
    /**
     * Constructor to create a VotingService instance.
     */
    public VotingService() {
        this.submissions = new HashMap<>();
    }
    /**
     * Configures the question for the voting service.
     * @param question The question to be configured.
     */
    public void configureQuestion(Question question) {
        this.question = question;
    }
    /**
     * Submits an answer for a student.
     * Only the last submission of the student is kept.
     * @param student The student submitting the answer.
     */
    public void submitAnswer(Student student) {
        // Validate and store the student's answer
        if (question.isValidAnswer(student.getAnswer())) {
            submissions.put(student.getId(), student.getAnswer());
        } else {
            System.out.println("Invalid answer from student ID: " + student.getId());
        }
    }
    /**
     * Outputs the statistics of the submissions.
     */
    public void outputStatistics() {
        // Create a map to count the occurrences of each answer
        Map<String, Integer> stats = new HashMap<>();
        for (String answer : submissions.values()) {
            String[] splitAnswers = answer.split(",");
            for (String ans : splitAnswers) {
                stats.put(ans.trim(), stats.getOrDefault(ans.trim(), 0) + 1);
            }
        }
        // Print the statistics
        for (String answer : question.getCandidateAnswers()) {
            System.out.println(answer + " : " + stats.getOrDefault(answer, 0));
        }
    }
}
