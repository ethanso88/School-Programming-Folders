public class EnhancedRectangleTest {

    public static void main(String[] args) {

        Point[] pointTestArray = new Point[4]; //array to hold the coordinates of the Rectangle

        //assign coordinates to test the rectangle
        pointTestArray[0] = new Point(0,0);
        pointTestArray[1] = new Point(0,2);
        pointTestArray[2] = new Point(2,2);
        pointTestArray[3] = new Point(2,0);

        EnhancedRectangle myRect = new EnhancedRectangle(pointTestArray);

        //test method in Rectangle class
        if (myRect.isRect())
            System.out.println("Rectangle created");
        else
            System.out.println("Points do NOT form a rectangle");

        if (myRect.isSquare())
            System.out.println("Rectangle is a square");
        else
            System.out.println("Rectangle is NOT a square");

        System.out.printf("Length %.2f units\n", myRect.getLength());
        System.out.printf("Width %.2f units\n", myRect.getWidth());
        System.out.printf("Perimeter %.2f units\n", myRect.getPerimeter());
        System.out.printf("Area %.2f units\n", myRect.getArea());

        System.out.println();

        //change one point to test that we NO longer have a rectangle
        myRect.getPointArray()[0].setY(0.5);
        if (myRect.isRect())
            System.out.println("Rectangle created");
        else
            System.out.println("Points do NOT form a rectangle");

    }

}
