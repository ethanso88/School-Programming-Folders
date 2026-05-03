import java.util.Scanner;

public class Rational {

    //fields
    private int numerator;
    private int denominator;

    //default rational constructor
    Rational() {

        numerator = 1;
        denominator = 2;

    }

    //constructor method
    Rational(int num, int denom) {

        //simplify the rational always
        Rational temp = simplify(num, denom);

        numerator = temp.getNumerator();
        denominator = temp.getDenominator();

    }

    //getters and setters
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //toString method
    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    //utility methods

    //gcd finds the greatest common denominator b/w two numbers
    public int gcd(int num1, int num2) {

            //The gcd of num1 and num2 is defined recursively as follows:
            // If num2 is equal to 0, then gcd(num1, num2) is num1
            if (num2 == 0)
                return num1;
            // otherwise, gcd(num1, num2) is gcd(num2, num1 % num2), where % is the remainder operator
            else
                return gcd(num2, num1 % num2);

    }

    //simplify fractions to their lowest form
    public Rational simplify(int num, int denom) {

        while (gcd(num, denom) > 1) {

            num = num / gcd(num,denom);
            denom = denom / gcd(num,denom);

        }

        return new Rational(num,denom);

    }

    //add two rationals
    public Rational add(Rational r2) {

        //mentally we are multiplying both sides by opposite denominators to get the same denominator
        Rational r3 = new Rational(numerator*r2.denominator + r2.numerator*denominator,
                denominator * r2.denominator);
        //when creating a rational it automatically simplifies it

        return r3;

    }

    //subtract two rationals
    public Rational subtract(Rational r2) {

        Rational r3 = new Rational(numerator*r2.denominator - r2.numerator*denominator,
                denominator * r2.denominator);

        return r3;

    }

    //multiply two rationals
    public Rational mutiply(Rational r2) {

        Rational r3 = new Rational(numerator * r2.numerator,
                denominator * r2.denominator);

        return r3;

    }

    //divide two rationals
    public Rational divide(Rational r2) {

        Rational r3 = new Rational(numerator * r2.denominator,
                denominator * r2.numerator);

        return r3;
    }

    //print rational
    public void printRational() {

        System.out.println(numerator + "/" + denominator);

    }

    //print rational in the form of a decimal
    public void printRationalDecimal(int decimalPlaces) {

        System.out.printf("%."+decimalPlaces+"f\n", (double) numerator/denominator);

    }




    }
