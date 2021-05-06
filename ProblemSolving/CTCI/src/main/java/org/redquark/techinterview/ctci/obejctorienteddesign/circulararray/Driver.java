package org.redquark.techinterview.ctci.obejctorienteddesign.circulararray;

public class Driver {

    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArray<>(10);
        for (int i = 0; i < circularArray.length(); i++) {
            circularArray.set(i, (i + 1));
        }
        circularArray.rotate(4);
        System.out.println("After rotation by 4, the first value will be: " + circularArray.get(0));
        for (Integer i : circularArray) {
            System.out.println(i);
        }
    }
}
