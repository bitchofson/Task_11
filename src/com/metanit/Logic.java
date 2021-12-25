package com.metanit;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



public class Logic {

    public static List<String> searchQuestion(String suggestions) {

        var match = Pattern.compile("([A-zА-я0-9,\\s]*\\?)").matcher(suggestions);

        List<String> mStr = new ArrayList<>();

        while (match.find()){
            mStr.add(match.group());
        }

        return mStr;
    }
}