package com.company;

import com.company.RealTest.Hobbies;

import java.util.*;

public class p1493{

        private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

        public void add(String hobbyist, String... hobbies) {
            this.hobbies.put(hobbyist, hobbies);
        }

        public List<String> findAllHobbyists(String hobby) {
            String returnName = "";
            for(Map.Entry<String,String[]> entry : hobbies.entrySet()) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                System.out.println(key);
                System.out.println(Arrays.stream(value).anyMatch(hobby::equals));
            }
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }

        public static void main(String[] args) {
            Hobbies hobbies = new Hobbies();
            hobbies.add("Steve", "Fashion", "Piano", "Reading");
            hobbies.add("Patty", "Drama", "Magic", "Pets");
            hobbies.add("Chad", "Puzzles", "Pets", "Yoga");


            System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
        }

}
