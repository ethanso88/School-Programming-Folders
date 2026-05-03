public class RectangleTest {

    public static void main(String[] args) {

        //create some sample objects (instances)
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(-5, 3);
        Rectangle r3 = new Rectangle(5, -3);
        Rectangle r4 = new Rectangle(-1, -1);

        //tested out the toString
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());

        //test set/get
        r4.setLength(2.5);
        r3.setWidth(4.0);
        System.out.println(r1.getLength());
        System.out.println(r2.getWidth());

        //test utility method
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getArea());

    }

}
