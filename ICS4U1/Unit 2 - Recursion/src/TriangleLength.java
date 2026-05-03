public class TriangleLength {

    public static void main(String[] args) {

        System.out.println(perimeter(2, 1.5));

    }

    private static double perimeter(int n, double length) {

        //base case
        if (n==0)
            return length;
        //recursive call
        else
            return (double) 3/2 * perimeter(n-1, 2*length);


    }

}


