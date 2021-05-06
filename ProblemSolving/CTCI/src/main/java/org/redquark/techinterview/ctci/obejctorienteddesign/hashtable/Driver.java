package org.redquark.techinterview.ctci.obejctorienteddesign.hashtable;

public class Driver {

    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
        customHashMap.put(1, "Cracking The Coding Interview");
        customHashMap.put(2, "System Design Interview");
        customHashMap.put(3, "Design Data Intensive Applications");
        customHashMap.put(4, "Introduction To Algorithms");
        System.out.println("Size: " + customHashMap.size());

        System.out.println(customHashMap.get(2));
        System.out.println(customHashMap.get(3));

        customHashMap.remove(1);
        System.out.println("Size: " + customHashMap.size());
        System.out.println(customHashMap.get(1));
    }
}
