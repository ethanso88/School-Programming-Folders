import java.util.Arrays;

public class HugeInteger {

    //fields
    private int[] integerArray;

    //constructor
    public HugeInteger() {
        integerArray = new int[40];
    }

    //input method to fill the array
    public void input(String integerString) {

        //convert the string to a character array
        char[] integerCharArray = integerString.toCharArray();

        //set the start index to place the first digit (biggest digit)
        //[][][start index][][][last index for smallest num], the smallest number is on the right I think
        int startIndex = integerArray.length - integerCharArray.length;

        //keep track of which current digit is being set in the char array
        int currentDigitIndex = 0;

        //assign the digits from the char array
        for (int index = startIndex; index < integerArray.length; index++) {
            integerArray[index] = integerCharArray[currentDigitIndex] - '0'; //need to convert char to int
            currentDigitIndex++;
        }

    }

    //output method
    public void output() {

        int firstDigitIndex = 0;

        //determine the first digit to display
        do {

            if (integerArray[firstDigitIndex] == 0)
                firstDigitIndex++;
            else
                break;

        } while (firstDigitIndex < integerArray.length);

        //print the digits, either 0 or the number
        if (firstDigitIndex == integerArray.length) //no number in the array
            System.out.println(0);
        else
            for (int index = firstDigitIndex; index < integerArray.length; index++)
                System.out.print(integerArray[index]);

        System.out.println();

    }

    //add method
    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();

        int carry = 0;

        for (int index = integerArray.length - 1; index >= 0; index--) {
            int sum = integerArray[index] + other.integerArray[index] + carry;
            result.integerArray[index] = sum % 10;
            carry = sum / 10;
        }

        return result;
    }

    //subtract method
    public HugeInteger subtract(HugeInteger other) {
        HugeInteger result = new HugeInteger();

        int borrow = 0;

        for (int index = integerArray.length - 1; index >= 0; index--) {
            int difference = integerArray[index] - other.integerArray[index] - borrow;

            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.integerArray[index] = difference;
        }

        return result;
    }

    //equal to method
    public boolean isEqualTo(HugeInteger other) {
        return Arrays.equals(integerArray, other.integerArray);
    }

    //not equal to method
    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }

    //greater than method
    public boolean isGreaterThan(HugeInteger other) {
        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] > other.integerArray[index]) {
                return true;
            } else if (integerArray[index] < other.integerArray[index]) {
                return false;
            }
        }
        return false;
    }

    //less than method
    public boolean isLessThan(HugeInteger other) {
        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] < other.integerArray[index]) {
                return true;
            } else if (integerArray[index] > other.integerArray[index]) {
                return false;
            }
        }
        return false;
    }

    //greater than or equal to method
    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return isGreaterThan(other) || isEqualTo(other);
    }

    //less than or equal to method
    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return isLessThan(other) || isEqualTo(other);
    }

    //is zero method
    public boolean isZero() {
        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] != 0) {
                return false;
            }
        }
        return true;
    }

    //note: multiply, divide and remainder are not implemented
}
