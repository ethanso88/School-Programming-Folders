package performanceTasks;

// Ethan So
// 4/25/2024

//a template class to ‘build’ books
public class Book {

    //fields
    private String title;
    private String author;
    private int numberOfPages;
    private int publicationYear;
    private String isbn;    //not all caps since it is not a constant
    private double cost;


    //constructor method
    public Book(String title, String author, int numberOfPages, int publicationYear, String isbn, double cost) {

        //no validation code
        this.title = title;
        this.author = author;
        this.isbn = isbn;

        //call set method since validation code
        this.numberOfPages = numberOfPages;
        this.publicationYear = publicationYear;
        this.cost = cost;

    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {

        //validation code
        if (numberOfPages > 0)
            this.numberOfPages = numberOfPages;
        else
            this.numberOfPages = 1;  //default value
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {

        //validation code
        if (publicationYear >= 0 && publicationYear <= 2024)
            this.publicationYear = publicationYear;
        else
            this.publicationYear = 0;   //default value
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {

        //validation code
        if (cost >= 0)
            this.cost = cost;
        else
            this.cost = 0;  //default value
    }

    //toString method to display object on the console
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publicationYear=" + publicationYear +
                ", isbn='" + isbn + '\'' +
                ", cost=" + cost +
                '}';
    }

}
