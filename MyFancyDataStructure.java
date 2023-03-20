import java.util.*;

class Value implements Comparable<Value>{
    // This is a final field, so the int variable 'value' can only be set once.
    final int value;

    static private boolean SORT_LOWER;

    //constructor
    Value(int value) {
        this.value = value;
    }
    
    //getter
    public int getValue() {
        return value;
    }
    
    //method that returns a boolean
    public static boolean isSortLower(){
        return SORT_LOWER;
    }

    //method that returns a boolean
    public static boolean isSortHigher(){
        return !SORT_LOWER;
    }

    //setter
    public static void setSortLower(){
        SORT_LOWER = true;
    }

    //setter
    public static void setSortHigher() {
        SORT_LOWER = false;
    }

    //toString method returning the value
    public String toString() {
        String number = Integer.toString(this.value);
        return number;
    }

    //compareTo method
    public int compareTo(Value value) {
        if (isSortLower()) {
            return Integer.compare(this.value, value.value);
        }
        return Integer.compare(value.value, this.value);
    }
}

class PreferLowerValues implements Comparator<Value> {
    public int compare(Value value1, Value value2) {
        // set to sort lower values first
        return value2.compareTo(value1);
    }
}

class PreferHigherValues implements Comparator<Value> {
    public int compare(Value value1, Value value2) {
       return value1.compareTo(value2);
    }
}

class MyFancyDataStructure {
}
