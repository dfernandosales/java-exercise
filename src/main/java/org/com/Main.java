package org.com;


import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Main.processNumber("111221");
    }

    public String countAndSay(int n) {

        return "";
    }

    public static String processNumber(String number) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        String countAndSay = "";
        // sliding window []
        //[1,2,1,1]
        String[] split = number.split("");

        for (int i = 0; i < split.length; i++) {
            if(i < split.length - 1 && Objects.equals(split[i], split[i+1])) {
               //increase window
                //validate window boundary
                for (int j = i; j < split.length; j++) {
                    if(!Objects.equals(split[j], split[j + 1])) {
                        stringIntegerHashMap.put(split[j], j-i+1);
                        i = j;
                        break;
                    }
                }
            } else {
                stringIntegerHashMap.put(split[i], 1);
            }

            countAndSay += stringIntegerHashMap.get(split[i]) + split[i];
            stringIntegerHashMap.clear();
        }
        System.out.println(stringIntegerHashMap);
        return null;
    }
}