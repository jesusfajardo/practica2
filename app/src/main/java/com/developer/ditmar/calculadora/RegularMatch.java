package com.developer.ditmar.calculadora;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularMatch {
    public String mathexpression;
    public String regx;
    public RegularMatch(String mathexpression, String regx) {
        this.mathexpression = mathexpression;
        this.regx = regx;
    }
    public ArrayList<String> match() {
        ArrayList<String> matchesslist = new ArrayList<>();
        Pattern pattern = Pattern.compile(this.regx);
        Matcher matcher = pattern.matcher(this.mathexpression);
        while (matcher.find()) {
            matchesslist.add(this.mathexpression.substring(matcher.start(), matcher.end()));
        }
        return matchesslist;
    }
}
