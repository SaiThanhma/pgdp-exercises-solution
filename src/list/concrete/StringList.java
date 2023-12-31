package list.concrete;

import list.LinkedList;
import list.ListElement;

public class StringList extends LinkedList<char[]> {

    public StringList(char[] data){
        concat(data);
    }

    public StringList(){}

    public void concat(char[] data){
        this.insert(data);
    }

    public int length(){
        return lengthRecursive(head, 0);
    }

    private int lengthRecursive(ListElement<char[]> current, int result){
        if(current == null){
            return result;
        }
        return lengthRecursive(current.getNext(), result + current.getValue().length);
    }

    @Override
    public String toString(){
        return toStringRecursive(head, new StringBuilder());
    }

    private String toStringRecursive(ListElement<char[]> current, StringBuilder result){
        if(current == null){
            return result.toString();
        }
        return toStringRecursive(current.getNext(), result.append(current.getValue()));
    }

    public boolean isPalindrome(){
        return isPalindromeRecursive(toString(), 0);
    }
    private boolean isPalindromeRecursive(String s, int counter) {
        if(counter >= s.length()/2){
            return true;
        }
        if(s.charAt(counter) != s.charAt(s.length() - 1 - counter)){
            return false;
        }
        return isPalindromeRecursive(s, counter + 1);
    }

    @Override
    public void reverse(){
        super.reverse();
        reverseRecursive(head);
    }

    private void reverseRecursive(ListElement<char[]> current){
        if(current == null){
            return;
        }
        reverseArray(current.getValue());
        reverseRecursive(current.getNext());
    }

    private void reverseArray(char[] arr){
        reverseArrayRecursive(arr, 0);
    }

    private void reverseArrayRecursive(char[] arr, int counter) {
        if(counter  >= arr.length/2){
            return;
        }
        char tmp = arr[counter];
        arr[counter] = arr[arr.length - 1 - counter];
        arr[arr.length - 1 - counter] = tmp;
        reverseArrayRecursive(arr, counter + 1);
    }

    @Override
    public boolean contains(char[] value) {
        if(value.length == 0){
            return true;
        }
        return containsRecursive(toString(), value, 0);
    }

    private boolean containsRecursive(String string, char[] value, int counterString){
        if(string.length() <= counterString){
            return false;
        }
        if(machtesPattern(string, value, counterString, 0)){
            return true;
        }
        return containsRecursive(string, value, counterString + 1);
    }

    private boolean machtesPattern(String string, char[] value, int counterString, int counterValue){
        if(value.length <= counterValue){
           return true;
        }
        if(string.length() <= counterString || string.charAt(counterString) != value[counterValue]){
            return false;
        }
        return machtesPattern(string, value, counterString + 1, counterValue + 1);
    }
}