package assignment_1;
/**
 * Class representing a student with a unique ID and an answer.
 */
public class Student {
    private String id;
    private String answer;
    /**
     * Constructor to create a student with a unique ID.
     * @param id The unique ID of the student.
     */
    public Student(String id) {
        this.id = id;
    }
    /**
     * Gets the ID of the student.
     * @return The ID of the student.
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the answer provided by the student.
     * @param answer The answer to be set for the student.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    /**
     * Gets the answer provided by the student.
     * @return The answer of the student.
     */
    public String getAnswer() {
        return answer;
    }
}
