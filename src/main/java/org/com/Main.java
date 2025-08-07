package org.com;


import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Input: %-8s Output: %-8s Expect: %s%n", "21", processNumber("21"), "1211");
        System.out.printf("Input: %-8s Output: %-8s Expect: %s%n", "1211", processNumber("1211"), "111221");
        System.out.printf("Input: %-8s Output: %-8s Expect: %s%n", "111221", processNumber("111221"), "312211");
        System.out.printf("Input: %-8s Output: %-8s Expect: %s%n", "312211", processNumber("312211"), "13112221");
    }

    public static String processNumber(String number) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        StringBuilder countAndSay = new StringBuilder();
        String[] split = number.split("");
        for (int i = 0; i < split.length; i++) {
            if(i < split.length - 1 && Objects.equals(split[i], split[i+1])) {
               //increase window
                //validate window boundary
                for (int j = i; j < split.length; j++) {
                    if(j == split.length-1 || !Objects.equals(split[j], split[j + 1])) {
                        stringIntegerHashMap.put(split[j], j-i+1);
                        i = j;
                        break;
                    }
                }
            } else {
                stringIntegerHashMap.put(split[i], 1);
            }

            countAndSay.append(stringIntegerHashMap.get(split[i])).append(split[i]);
            stringIntegerHashMap.clear();
        }
        return countAndSay.toString();
    }
}