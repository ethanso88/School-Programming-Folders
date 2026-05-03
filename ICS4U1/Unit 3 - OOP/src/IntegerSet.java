import java.util.Arrays;

//template class
public class IntegerSet {

    //fields
    private boolean[] setArray = new boolean[101]; //0-100 num

    //constructor method
    IntegerSet(int[] dataArray) {

        //set inputted numbers to true
        for (int index : dataArray)
            setArray[index] = true;

    }

    //default constructor (note the default array in the object class setArray is automatically set to false)
    IntegerSet() {

        Arrays.fill(setArray, false);

    }

    //getters and setters
    public boolean[] getSetArray() {
        return setArray;
    }

    public void setSetArray(boolean[] setArray) {
        this.setArray = setArray;
    }

    //toString method to display fields to the console
    @Override
    public String toString() {
        return "IntegerSet{" +
                "integerArray=" + Arrays.toString(setArray) +
                '}';
    }

    //utility methods

    //this method creates a third set that is the set-theoretic union of two existing sets
    //(i.e., an element of the third set’s array is set to true if that element is true in either or both of the existing sets
    // otherwise, the element of the third set is set to false)
    public IntegerSet union(IntegerSet otherSet) {

        //make new third set
        IntegerSet unionSet = new IntegerSet();

        //make a for loop to check all numbers 0-100 of the two sets
        for (int num = 0; num < setArray.length; num++) {

            if (this.getSetArray()[num] || otherSet.getSetArray()[num])
                unionSet.getSetArray()[num] = true;
            else
                unionSet.getSetArray()[num] = false;

        }

        return unionSet;

    }

    //Method intersection creates a third set which is the set-theoretic intersection of two existing sets
    //(i.e., an element of the third set’s array is set to false if that element is false in either or both of the existing sets
    // otherwise, the element of the third set is set to true)
    public IntegerSet intersection(IntegerSet otherSet) {

        //make new third set
        IntegerSet intersectSet = new IntegerSet();

        //make a for loop to check all numbers 0-100 of the two sets
        for (int num = 0; num < setArray.length; num++) {

            if (this.getSetArray()[num] || otherSet.getSetArray()[num])
                intersectSet.getSetArray()[num] = true;
            else
                intersectSet.getSetArray()[num] = false;

        }

        return intersectSet;

    }

    //Method insertElement inserts a new integer k into a set (by setting a[k] to true)
    public void insertElement(int k) {

        this.setArray[k] = true;

    }


    //Method deleteElement deletes integer m (by setting a[m] to false)
    public void deleteElement(int m) {

        setArray[m] = false;

    }

    //Method toSetString returns a string containing a set as a list of numbers separated by spaces.
    // Include only those elements that are present in the set. Use --- to represent an empty set.
    public String toSetString() {

        String temp = "{ "; //start of printing the set of numbers
        boolean empty = true; //to track empty sets

        //check array for numbers or if it is empty
        for(int index = 0; index < setArray.length; index++) {

            if (setArray[index]){
                empty = false;
                temp += index + " ";

            }
        }

        if (empty == true)
            return temp + "---" + " }";
        else
            return temp + " }";

    }

    //Method isEqualTo determines whether two sets are equal
    public boolean isEqualto(IntegerSet set2) {

        //check for an instance of not being equal
        for (int index = 0; index < setArray.length; index++) {

            if (this.getSetArray()[index] != set2.getSetArray()[index])
                return false;
        }

        //otherwise if it gets through the loop
        return true;

    }

}
