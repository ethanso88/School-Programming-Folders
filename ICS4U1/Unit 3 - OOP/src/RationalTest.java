public class RationalTest {

    public static void main(String[] args) {

        Rational r1 = new Rational();
        Rational r2 = new Rational(3,7);

        r1.printRational();
        r2.printRational();

        Rational r3 = r1.add(r2);
        r3.printRational();

        Rational r4 = r1.subtract(r2);
        r4.printRational();

        Rational r5 = r1.mutiply(r2);
        r5.printRational();

        Rational r6 = r1.divide(r2);
        r6.printRational();

        r6.printRationalDecimal(3);

    }

}
