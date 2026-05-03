public class ComplexTest {

    public static void main(String[] args) {

        //create sample objects
        Complex n1 = new Complex(0,0);
        Complex n2 = new Complex(2,2);

        //test toString
        System.out.println(n1.toString());
        System.out.println(n2.toString());

        //test set/get
        n1.setRealNum(1);
        n1.setImagNum(1);
        System.out.println(n1.getRealNum());
        System.out.println(n1.getImagNum());

        //test utility methods
        System.out.println(n1.addComplex(n2));
        System.out.println(n1.subtractComplex(n2));
        n1.printComplex();


    }

}
