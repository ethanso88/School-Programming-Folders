
//User template class to create object user to hold the user's score and name
public class User {

    //fields
    private String userInitials;
    private double highScore;

    //constructor method
    public User(String userInitials, double highScore) {
        this.userInitials = userInitials;
        this.highScore = highScore;
    }

    //getters and setters
    public String getUserInitials() {
        return userInitials;
    }

    public void setUserInitials(String userInitials) {
        this.userInitials = userInitials;
    }

    public double getHighScore() {
        return highScore;
    }

    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }

    //toString method
    @Override
    public String toString() {
        return "User{" +
                "currentUserInitials='" + userInitials + '\'' +
                ", highScore=" + highScore +
                '}';
    }

}
