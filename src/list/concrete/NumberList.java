package list.concrete;

import list.LinkedList;
import list.ListElement;

public class NumberList extends LinkedList<Integer> {

    public static NumberList add(NumberList first, NumberList second){
        return addRecursive(first.head, second.head, 0, new NumberList());
    }

    private static NumberList addRecursive(ListElement<Integer> first, ListElement<Integer> second, int carry, NumberList result){
        if(first == null && second == null){
            if(carry == 1){
                result.insert(carry);
            }
            return result;
        }
        if(first == null){
            int tmp = carry + second.getValue().intValue();
            result.insert(tmp % 10);
            carry = tmp > 9 ? 1 : 0;
            return addRecursive(null, second.getNext(), carry, result);
        }
        if(second == null){
            int tmp = carry + first.getValue().intValue();
            result.insert(tmp % 10);
            carry = tmp > 9 ? 1 : 0;
            return addRecursive(first.getNext(), null, carry, result);
        }
        int tmp = carry + first.getValue().intValue() + second.getValue().intValue();
        result.insert(tmp % 10);
        carry = tmp > 9 ? 1 : 0;
        return addRecursive(first.getNext(), second.getNext(), carry, result);
    }

    public NumberList() {
    }

    public NumberList(Integer value) {
        insert(value);
    }

    @Override
    public void insert(Integer value) {
        if(value.intValue() == 0){
            super.insert(value);
        }
        insertRecursive(value.intValue());
    }

    private void insertRecursive(int value) {
        if(value <= 0){
            return;
        }
        int leastdigit = value % 10;
        super.insert(Integer.valueOf(leastdigit));
        insertRecursive(value / 10);
    }

    public Integer crossSum(){
        return crossSumRecursive(head, 0);
    }

    private Integer crossSumRecursive(ListElement<Integer> current, int res){
        if(current == null){
            return res;
        }
        return crossSumRecursive(current.getNext(), current.getValue().intValue() + res);
    }
}
