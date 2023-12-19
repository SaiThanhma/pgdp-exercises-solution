package list.concrete;

import list.LinkedList;
import list.ListElement;

public class TribonacciList extends LinkedList<Integer> {
    private Integer last;
    private Integer secondLast;
    private Integer thirdLast;

    public TribonacciList(int length) {
        insert(length);
    }

    @Override
    public void insert(Integer n) {
        if(last == null){
            last = Integer.valueOf(1);
            super.insert(last);
            --n;
            if(n == 0){
                return;
            }
        }
        if(secondLast == null){
            secondLast = Integer.valueOf(1);
            super.insert(secondLast);
            --n;
            if(n == 0){
                return;
            }
        }
        if(thirdLast == null){
            thirdLast = Integer.valueOf(1);
            super.insert(thirdLast);
            --n;
            if(n == 0){
                return;
            }
        }
        insertRecusive(n);
    }

    private void insertRecusive(int counter){
        if(counter <= 0){
            return;
        }
        Integer n = last.intValue() + secondLast.intValue() + thirdLast.intValue();
        super.insert(n);
        thirdLast = secondLast;
        secondLast = last;
        last = n;
        insertRecusive(--counter);
    }
}
