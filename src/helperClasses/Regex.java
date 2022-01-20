package helperClasses;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

public class Regex{
    String strQuery;

    /**
     * Contrutor da classe Regex
     * Inicializa uma String que guarda a query.
     *
     * @param query query introduzida
     */
    public Regex(String query){
        this.strQuery=query;
    }

    /**
     * Método que separa a query segunda uma expressão regular e guarda
     * a informação útil contida na query guardado essa informação
     * numa ArrayList.
     *
     * @return a ArrayList com a informação filtrada
     */
    public ArrayList<String> regex (){
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

    /**
     *
     * @param strToTest
     * @return
     */
    public static boolean isString(String strToTest){
        boolean teste;
        teste = (strToTest.matches("\\\\d*[.]\\\\d+"));
        return !teste;
    }
}

