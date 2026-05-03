package arrays;

import java.util.Scanner;

/*
(SalaryTable) A company pays its salespeople on a commission basis.
The salespeople receive $200 per week plus 9% of their gross sales for that week.
For example, a salesperson who grosses $5000 in sales in a week receives $200 plus 9% of $5000, or a total of $650.
Write an application that determines how many of the salespeople earned salaries in each of the following ranges
(assume that each salesperson’s salary is truncated to an integer amount):

$200–299
$300–399
$400–499
$500–599
$600–699
$700–799
$800–899
$900–999
$1000 and over

Store the tallies in an array and summarize the results in tabular format with appropriate column headings.
 */

public class SalaryTable {

    //declare array as a static ‘field’
    static int[] salaryRangeArray = new int[11];    //11 as size since array handles the ‘hundreds’ digits (from 2 to 10)
                                                    //we won't use index 0 or 1; start at 2

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String answer;
        double sales;

        // 1. Repeat till the user quits
        do {
            // 2. Get the employee's sales'
            System.out.println("How much did you sell?");
            sales = input.nextDouble();

            // 3. set the salary range based on their sales
            setSalaryRange(sales);

            // 4. check if there are more employees
            System.out.println("Are there more employees? (y/n)");
            answer = input.next();

        } while (answer.equalsIgnoreCase("y"));

        // 5. display the salary table
        displaySalaryTable();

    }

    //this method finds the salary range based on inputted sales revenue
        //counts how many of the salespeople earned salaries in their specific range
    private static void setSalaryRange(double sales) {

        //1. calculate salary
        int salary = (int) (200 + 0.09 * sales);

        //2. Increment the corresponding salary index
        if ((salary / 100) >= 10)   //if calculated index greater than 10 just increment 1000+ index
            ++salaryRangeArray[10];
                //++ or increment is just done before
        else                        //else increment calculated index
            ++salaryRangeArray[salary / 100];

    }

    //method displays the salary table
    private static void displaySalaryTable() {

        //1. Display title and headings
        System.out.println("Salary Results");
        System.out.printf("%s\t\t%s\n", "Salary Range", "# of salespeople");

        //2. Display the data for each salary range up to $999
        for (int x = 2; x < salaryRangeArray.length - 1; x++)
            System.out.printf("%d00-%d99\t\t\t\t%d\n", x, x, salaryRangeArray[x]);

        //3. Display the data for salary range $1000+
        System.out.printf("1000+\t\t\t\t%d\n", salaryRangeArray[10]);


    }


}
