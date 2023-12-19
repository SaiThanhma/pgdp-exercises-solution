package list;

public class LinkedList <T> implements Iterable<T>{

    protected ListElement<T> head;
    protected ListElement<T> tail;
    protected int size;

    public ListElement<T> getHead() {
        return head;
    }

    public void setHead(ListElement<T> head) {
        this.head = head;
    }

    public ListElement<T> getTail() {
        return tail;
    }

    public void setTail(ListElement<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void insert(T value) {
        //appends the value in the list
        ListElement<T> element = new ListElement<T>(value);
        if(size == 0){
            head = element;
            tail = element;
        }
        else {
            tail.next = element;
            tail = element;
        }
        ++size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        ListElement<T> current = head;

        for (int i = 0; i < size; i++) {
            out.append(current.toString());
            if (i != size - 1) {
                out.append(", ");
            }
            current = current.next;
        }
        out.append("]");
        return out.toString();
    }

    public void reverse() {
        ListElement<T> tmpHead = head;
        ListElement<T> tmptail = tail;
        head.reverseRecursive();
        tail = tmpHead;
        head = tmptail;
    }

    public boolean contains(T value) {
        return head.containsRecursive(value);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator(head);
    }

    public class Iterator implements java.util.Iterator<T> {
        ListElement<T> current;

        public Iterator(ListElement<T> e) {
            current = e;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            ListElement<T> ret = current;
            current = current.next;
            return ret.getValue();
        }
    }
}
