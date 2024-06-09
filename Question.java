package assignment_1;
import java.util.List;
/**
 * Abstract class representing a question with candidate answers.
 * Subclasses should define the validation logic for the answers.
 */
abstract class Question {
    private List<String> candidateAnswers;
    /**
     * Constructor to create a question with the given candidate answers.
     * @param candidateAnswers List of possible answers for the question.
     */
    public Question(List<String> candidateAnswers) {
        this.candidateAnswers = candidateAnswers;
    }
    /**
     * Gets the candidate answers for the question.
     * @return List of candidate answers.
     */
    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }
    /**
     * Abstract method to validate if the provided answer is valid for this question.
     * @param answer The answer string to be validated.
     * @return true if the answer is valid, false otherwise.
     */
    public abstract boolean isValidAnswer(String answer);
}
