package assignment_1;
import java.util.List;

/**
 * Class representing a single-choice question.
 * Only one answer can be selected for this type of question.
 */

class SingleChoiceQuestion extends Question{
    /**
     * Constructor to create a single-choice question with the given candidate answers.
     * @param candidateAnswers List of possible answers for the question.
     */
    public SingleChoiceQuestion(List<String> candidateAnswers) {
        super(candidateAnswers);
    }
    /**
     * Validates if the provided answer is valid for this question.
     * For single-choice questions, the answer must be one of the candidate answers.
     * @param answer The answer string to be validated.
     * @return true if the answer is a valid candidate answer, false otherwise.
     */
    @Override
    public boolean isValidAnswer(String answer) {
        // Check if the answer is a valid candidate answer
        return getCandidateAnswers().contains(answer);
    }

}
