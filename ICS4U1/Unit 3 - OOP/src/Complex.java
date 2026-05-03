/*
Write a program to test your class. Use floating-point variables to represent the private data of the class.
Provide a constructor that enables an object of this class to be initialized when it is declared.
Provide a no-argument constructor with default values in case no initializers are provided.
Provide public methods that perform the following operations:
Add two Complex numbers: The real parts are added together and the imaginary parts are added together.
Subtract two Complex numbers: The real part of the right operand is subtracted from the real part of the left operand,
    and the imaginary part of the right operand is subtracted from the imaginary part of the left operand.
Print Complex numbers in the form (a, b), where a is the real part and b is the imaginary part.
 */

//template class
public class Complex {

    //fields
    private double realNum;
    private double imagNum;

    //constructor method
    Complex(double realNum, double imagNum) {

        this.realNum = realNum;
        this.imagNum = imagNum;

    }

    //default constructor
    Complex() {

        this.realNum = 1;
        this.imagNum = 1;

    }

    //getters and setters
    public double getRealNum() {
        return realNum;
    }

    public void setRealNum(double realNum) {
        this.realNum = realNum;
    }

    public double getImagNum() {
        return imagNum;
    }

    public void setImagNum(double imagNum) {
        this.imagNum = imagNum;
    }

    //toString method to display fields to console
    @Override
    public String toString() {
        return "Complex{" +
                "realNum=" + realNum +
                ", imagNum=" + imagNum +
                '}';
    }

    //utility methods

    //this method adds two complex numbers
    public Complex addComplex(Complex c2) {

        Complex c3 = new Complex(0,0);

        //add the real part of the numbers
        c3.setRealNum(this.getRealNum() + c2.getRealNum());

        //add the imaginary part of the numbers
        c3.setImagNum(this.getImagNum() + c2.getImagNum());

        return c3;

    }

    //this method subtracts two complex numbers
    public Complex subtractComplex(Complex c2) {

        //subtract the real part of the numbers
        double realSum = this.getRealNum() - c2.getRealNum();

        //subtract the imaginary part of the numbers
        double imagSum = this.getImagNum() - c2.getImagNum();

        return new Complex(realSum, imagSum);

    }

    //this method prints complex numbers in the form (a,b)
    public void printComplex() {

        System.out.printf("(%.2f,%.2f)", this.getRealNum(), this.getImagNum());

    }

}
