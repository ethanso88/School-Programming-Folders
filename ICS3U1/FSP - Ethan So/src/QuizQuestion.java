
//this class is the template class for the Quiz Question object
//the quiz question object is an object to represent the contents of a question in a quiz in the Assessment class
public class QuizQuestion {

    //Each question should have the question itself, the answer, and the score (if correct or not)
    private String question;
    private String answer;
    private Boolean correct;

    //constructor method
    public QuizQuestion(String question, String answer, Boolean correct) {
        this.question = question;   //for quiz label
        this.answer = answer;       //for displaying the answer in a dialog box
        this.correct = correct;     //for determining if the question was answered correctly
    }

    //getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    //toString method
    @Override
    public String toString() {
        return "QuizQuestion{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                '}';
    }

}
