package list;

public class ListElement<T> {
    protected T value;
    protected ListElement<T> next;

    public ListElement(T value) {
        this.value = value;
    }

    public ListElement(T value, ListElement<T> next) {
        this.value = value;
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(ListElement<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public ListElement<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    //Implement helper function if needed

    public ListElement<T> reverseRecursive() {
        if(next == null){
            return this;
        }

        ListElement<T> head = next.reverseRecursive();
        next.next = this;
        next = null;
        return head;
    }

    public boolean containsRecursive(T value){
        if(this.value.equals(value)){
            return true;
        }
        if(next == null){
            return false;
        }
        return next.containsRecursive(value);
    }
}
