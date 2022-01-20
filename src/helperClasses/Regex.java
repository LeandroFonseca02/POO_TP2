package helperClasses;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

// https://regex101.com/

/*
COUNTROWS(FILTER(Customer_Data, Customer_Data[Age]>=18 && Customer_Data[IsActiveMember]=1))

CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))

AVERAGE(Customer_Data[Tenure])

SUM(Customer_Data[Balance])
*/

public class Regex{
    String query;
    public Regex(String query){
        this.query=query;
    }
    public ArrayList<String> regex () throws java.lang.Exception{
        final String functionNameRegex = "\\w*[=<>!&|]*";
        //"\\w+\\(*\\)*" ;//"((\\w+)+)\\(([^()]*)\\)";

        final Pattern fnPattern = Pattern.compile(functionNameRegex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        final Matcher fnMatcher = fnPattern.matcher(this.query);
        ArrayList<String> expression = new ArrayList<>();
        while (fnMatcher.find()) {
            if(!fnMatcher.group(0).equals("") && !fnMatcher.group(0).equals("Customer_Data")
                    && !fnMatcher.group(0).equals("(") && !fnMatcher.group(0).equals(")")
                    && !fnMatcher.group(0).equals("))")){
                //System.out.println("Full match: " + fnMatcher.group(0));
                expression.add(fnMatcher.group(0));
            }


            //System.out.println("Full match: " + fnMatcher.group(1));
            //System.out.println("Full match: " + fnMatcher.group(1));
            //String[] lst2 = fnMatcher.group(1).split(",\\s*");
            //for(String s:lst2)
            //    System.out.println("params: " + s);
                /*
                String[] lst = fnMatcher.group(1).split("\\s+");
                System.out.println(Arrays.toString(lst));

                String[] lst2 = fnMatcher.group(0).split(",\\s*");

                List<String> res = new ArrayList<>();
                for (String s:lst2) {
                    res.add(s.split("\\s+")[0]);
                }
                System.out.println(res);
                */
        }
        return expression;
    }
}

