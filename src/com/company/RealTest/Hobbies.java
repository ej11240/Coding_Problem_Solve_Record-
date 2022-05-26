package com.company.RealTest;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        List<String> testList = new ArrayList<String>();
        for(Map.Entry<String,String[]> entry : hobbies.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
//            System.out.println(key);
//            System.out.println(Arrays.stream(value).anyMatch(hobby::equals));
            if(Arrays.stream(value).anyMatch(hobby::equals)) testList.add(key);
        }
        return testList;
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");


        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
    }
}
