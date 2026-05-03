//import for JRadioButton
import javax.swing.*;

//this class is the template class for the Quiz option object
//the quiz option object just allows to set a radiobutton as a correct or incorrect answer
public class QuizOption extends JRadioButton {

    //field to tell if it's correct
    private Boolean correct;

    //constructor method
    public QuizOption(String text, Boolean correct) {
        super(text);
        this.correct = correct;
    }

    //getters and setters
    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    //toString method
    @Override
    public String toString() {
        return "QuizOption{" +
                "correct=" + correct +
                '}';
    }
}
