public class HugeIntegerTest {

    public static void main(String[] args) {
        HugeInteger num1 = new HugeInteger();
        HugeInteger num2 = new HugeInteger();
        HugeInteger num3 = new HugeInteger();
        HugeInteger num4 = new HugeInteger();

        num1.input("1234567890123456789012345678901234567890");
        num2.input("1234567890123456789012345678901234567890");
        num3.input("1234567890123456789012345678901234567891");
        num4.input("9000000000000000000000000000000000000000");

        System.out.println(num1.isEqualTo(num2));
        System.out.println(num1.isGreaterThan(num3));

        num1.add(num2).output();
        num3.subtract(num1).output();
        num2.subtract(num1).output();

        //these cases are not properly handled yet
        num1.subtract(num3).output(); //underflow
        num4.add(num1).output(); //overflow

    }
}