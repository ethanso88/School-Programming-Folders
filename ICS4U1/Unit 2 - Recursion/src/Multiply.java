public class Multiply {

    public static void main(String[] args) {

        System.out.println(multiply(3,5));

    }

    private static int multiply(int num1, int num2) {

        if (num2 == 0)
            return 0;
        else
            return num1 + multiply(num1, --num2);

    }

}
