package ua.com.kisit.courseshop2025.bl;

import java.util.ArrayList;
import java.util.List;

public class MainTst
{

    public MainTst() {
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        for (Integer i : arr) {
            System.out.println(i);
        }

        arr.remove(0);

        arr.clear();




    }
}
