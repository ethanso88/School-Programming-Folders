package ShapeHierarchy;

import java.util.ArrayList;

public class ShapeTest {

    public static void main(String[] args) {

        ArrayList<Shape> shapeList = new ArrayList<Shape>(); //empty bracket is to call its constructor

        shapeList.add(new Circle(1));
        shapeList.add(new Circle(2));

        shapeList.add(new Cube(1));
        shapeList.add(new Cube(2));

        shapeList.add(new Square(1));
        shapeList.add(new Square(2));

        shapeList.add(new Sphere(1));
        shapeList.add(new Sphere(2));

        //enhanced for loop
        for (Shape currentShape : shapeList) {

            System.out.println(currentShape);
            System.out.printf("%.2f units squared\n",currentShape.calculateArea());

            //check if a shape is 3D
            if (currentShape instanceof ThreeDimensionalShape) {

                //down casting (sending it down the hierarchy)
                ThreeDimensionalShape current3dShape = (ThreeDimensionalShape) currentShape;
                System.out.printf("%.2f units cubed\n", current3dShape.calculateVolume());

            }

        }

    }

}
