package utils;

import model.Novel;

public class Util {

    public static String generateId(Integer year, String type, Integer lastIndex ) {
        return String.format("%d-%s-%05d",
                year,
                type.equals(Novel.class.getName()) ? "A" : "B",
                lastIndex + 1);
    }

}
