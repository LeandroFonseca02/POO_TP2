package helperClasses;
import Enumerators.*;

import Exceptions.ImpossibleCalculateException;

import java.util.*;
import java.lang.*;
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
    public ArrayList<String> regex () throws ImpossibleCalculateException {
        final String functionNameRegex = "\\w*[=<>!&|]*";
        final Pattern fnPattern = Pattern.compile(functionNameRegex, Pattern.CASE_INSENSITIVE | Pattern.COMMENTS);
        final Matcher fnMatcher = fnPattern.matcher(this.strQuery);
        ArrayList<String> expression = new ArrayList<>();
        while (fnMatcher.find()) {
            if(!fnMatcher.group(0).equals("") && !fnMatcher.group(0).equals("Customer_Data")){
                expression.add(fnMatcher.group(0));
            }
        }
        check(expression);
        clean(expression);
        return expression;
    }

    private void check(ArrayList<String> expression) throws ImpossibleCalculateException {
        int counter=0;
        for(String s: expression) {
            if (s.equals("CALCULATE") && !teste(expression.get(counter+1))) {
                throw new ImpossibleCalculateException("");
            }
            counter++;
        }
    }

    private boolean teste(String ass){
        boolean flag = false;
        for(AggregationCommand agg: AggregationCommand.values()){
            if(ass.equals(agg.toString())) flag =true;
        }
        return flag;
    }

    private void clean(ArrayList<String> expression){
        int counter=expression.size();
        String s;
        for (int i = 0; i<counter; i++){
            s=expression.get(i);
            if(s.equals("CALCULATE")){
                expression.remove(i);
                counter--;
            }
        }
    }

    /**
     * Método para saber se o conteúdo duma Strong é um número
     * @param strToTest string a verificar
     * @return boolean com valor se a String é um número
     */
    public static boolean isNumber(String strToTest){
        return (strToTest.matches("\\d*[.]*\\d+"));
    }
}

