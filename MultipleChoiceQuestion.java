package assignment_1;
import java.util.List;

/**
 * Class representing a multiple-choice question.
 * Multiple answers can be selected for this type of question.
 */

class MultipleChoiceQuestion extends Question{
    /**
     * Constructor to create a multiple-choice question with the given candidate answers.
     * @param candidateAnswers List of possible answers for the question.
     */
    public MultipleChoiceQuestion(List<String> candidateAnswers) {
        super(candidateAnswers);
    }
    /**
     * Validates if the provided answer(s) are valid for this question.
     * For multiple-choice questions, the answer can be a combination of answers separated by commas.
     * @param answer The answer string to be validated.
     * @return true if all parts of the answer are valid, false otherwise.
     */
    @Override
    public boolean isValidAnswer(String answer) {
        // For multiple-choice questions, assume answer can be a combination like "A,B"
        // Split the answer by commas to handle multiple selections
        String[] splitAnswers = answer.split(",");
        for (String ans : splitAnswers) {
            // Check if each split answer is a valid candidate answer
            if (!getCandidateAnswers().contains(ans.trim())) {
                return false;
            }
        }
        return true;
    }
}
