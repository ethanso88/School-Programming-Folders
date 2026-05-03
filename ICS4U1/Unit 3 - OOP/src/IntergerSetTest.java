public class IntergerSetTest {

    public static void main(String[] args) {

        int[] numArray = {1,3};
        IntegerSet a = new IntegerSet(numArray);
        System.out.println("a = " + a.toSetString());

        IntegerSet b = new IntegerSet();
        System.out.println("b = " + b.toSetString());

        b.insertElement(1);
        b.insertElement(6);
        System.out.println("b = " + b.toSetString());

        IntegerSet c = a.union(b);
        IntegerSet d = new IntegerSet();

        System.out.println("a = " + a.toSetString());
        System.out.println("b = " + b.toSetString());
        System.out.println("c = " + c.toSetString());
        System.out.println("d = " + d.toSetString());

        a.insertElement(6);

        System.out.println("a = " + a.toSetString());

        System.out.println(c.isEqualto(a));
    }

}
