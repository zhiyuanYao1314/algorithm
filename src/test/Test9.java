package test;

import java.util.*;

public class Test9 implements Cloneable{

    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    public static void main(String[] args) throws CloneNotSupportedException {


        List<Integer> lists = new ArrayList<>();
        Collections.reverse(lists);
        Iterator iterator = lists.iterator();

        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }

        lists.add(1);
        lists.add(2);

        for (Integer i :lists){
            lists.remove(i);
        }

        Test9 t = new Test9();
        Test9 tt = (Test9)t.clone();

        Collections.copy(new ArrayList<>(), lists);


    }
}
