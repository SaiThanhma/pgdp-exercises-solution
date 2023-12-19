package list.concrete;

import list.LinkedList;
import list.ListElement;

public class SortedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void insert(T value) {
        head = insertRecursive(head, new ListElement<>(value));
        ++size;
    }

    private ListElement<T> insertRecursive(ListElement<T> current, ListElement<T> element) {
        if(current == null){
            if(tail == null){
                tail = element;
            }
            else{
                tail.setNext(element);
                tail = element;
            }
            return tail;
        }
        if(current.getValue().compareTo(element.getValue()) >= 0){
            element.setNext(current);
            return element;
        }
        current.setNext(insertRecursive(current.getNext(), element));
        return current;
    }
}