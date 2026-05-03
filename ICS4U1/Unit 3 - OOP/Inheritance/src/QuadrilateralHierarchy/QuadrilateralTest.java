package QuadrilateralHierarchy;

public class QuadrilateralTest {

    public static void main(String[] args) {

        Trapezoid t1 = new Trapezoid(new Point(0,0), new Point(10,0), new Point(8,5), new Point(2,5));

        System.out.printf("Coordinates of Trapezoid are: \n%s\n", t1.toString());
        System.out.printf("Height is %.1f\n", t1.getHeight());
        System.out.printf("Area is %.2f\n", t1.calculateArea());


        Parallelogram p1 = new Parallelogram(new Point(0,0), new Point(10,0), new Point(14,5), new Point(4,5));

        System.out.printf("Coordinates of Parallelogram are: \n%s\n", p1.toString());
        System.out.printf("Height is %.1f\n", p1.getHeight());
        System.out.printf("Area is %.2f\n", p1.calculateArea());


        Rectangle r1 = new Rectangle(new Point(0,0), new Point(10,0), new Point(10,5), new Point(0,5));

        System.out.printf("Coordinates of Rectangle are: \n%s\n", r1.toString());
        System.out.printf("Height is %.1f\n", r1.getHeight());
        System.out.printf("Area is %.2f\n", r1.calculateArea());


        Square s1 = new Square(new Point(0,0), new Point(5,0), new Point(5,5), new Point(0,5));

        System.out.printf("Coordinates of Square are: \n%s\n", s1.toString());
        System.out.printf("Height is %.1f\n", s1.getHeight());
        System.out.printf("Area is %.2f\n", s1.calculateArea());


    }

}
