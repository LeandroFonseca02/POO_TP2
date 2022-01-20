package helperClasses;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

public class Regex{
    String strQuery;

    public Regex(String query){
        this.strQuery=query;
    }

    public ArrayList<String> regex () throws java.lang.Exception{
        final String functionNameRegex = "\\w*[=<>!&|]*";
        final Pattern fnPattern = Pattern.compile(functionNameRegex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        final Matcher fnMatcher = fnPattern.matcher(this.strQuery);
        ArrayList<String> expression = new ArrayList<>();
        while (fnMatcher.find()) {
            if(!fnMatcher.group(0).equals("") && !fnMatcher.group(0).equals("Customer_Data")){
                expression.add(fnMatcher.group(0));
            }
        }
        return expression;
    }

    public static boolean isString(String strToTest){
        boolean teste;
        teste = (strToTest.matches("\\\\d*[.]\\\\d+"));
        return !teste;
    }
}

