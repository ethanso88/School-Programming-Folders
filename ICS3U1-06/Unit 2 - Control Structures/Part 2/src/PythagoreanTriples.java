//HEADER
/*
Name: Ethan So
Date: 3/26/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(PythagoreanTriples) A right triangle can have sides whose lengths are all integers.
The set of three integer values for the lengths of the sides of a right triangle is called a Pythagorean triple.
The lengths of the three sides must satisfy the relationship that the sum of the squares of two of the sides
is equal to the square of the hypotenuse.

Write an application to find all Pythagorean triples for side1, side2 and the hypotenuse, all no larger than 500.
Use a triple-nested for loop that tries all possibilities. This method is an example of “brute-force” computing.
You will learn in more advanced computer science courses that for many interesting problems there is no known algorithmic approach
other than using sheer brute force.

Sample output:
3 4 5
5 12 13
6 8 10
etc…

Major Skills: Algorithm, for loop, nested for loops, brute force
*/

public class PythagoreanTriples {

    public static void main(String[] args) {

        //variables
        int hypotenuse;
        int smaller1, smaller2;
        int count = 0;


        //For values of a = 1-500
        for (int a = 1; a <= 500; a++) {

            //For values of b = 1-500
            for (int b = a + 1; b <= 500; b++) {

                //For values of c = 1-500
                for (int c = b + 1; c <= 500; c++) {

                    //They are guaranteed to be a triangle as each side is +1 greater than the other
                    //In consecutive order
                    //don't need to test with triangle formation rule
                    //this also avoids duplicate triangles and guarantees that c will always be the hypotenuse

                    //Test if they are a Right triangle
                    //Use Pythagorean Theorem
                    if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {

                        //Display the value if true
                        System.out.printf("%d %d %d\n", a, b, c);
                        count++;
                    }
                }
            }
        }

        //Display number of pythagorean triples
        System.out.printf("The number of pythagorean triples is %d", count);

    }

}
