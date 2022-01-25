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
     * @throws ImpossibleCalculateException lançada quando comando CALCULATE é mal usado.
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
        checkCalculateUsage(expression);
        deleteCalculate(expression);
        return expression;
    }

    /**
     * Método para lançar exceção caso o comando CALCULATE seja mal usado.
     *
     * @param arrayList arrayList de comandos a verificar
     * @throws ImpossibleCalculateException lançada quando comando CALCULATE é mal usado.
     */
    private void checkCalculateUsage(ArrayList<String> arrayList) throws ImpossibleCalculateException {
        int intCounter = 0;
        for(String string: arrayList) {
            if (string.equals("CALCULATE") && !isAggregationCommand(arrayList.get(intCounter+1))) {
                throw new ImpossibleCalculateException("");
            }
            intCounter++;
        }
    }

    /**
     * Método para verficar se uma String é um comando de agregação
     *
     * @param strCommand string a verificar
     * @return booleano com valor se é comando de agregação
     */
    private boolean isAggregationCommand(String strCommand){
        boolean bolFlag = false;
        for(AggregationCommands aggregationCommand: AggregationCommands.values()){
            if(strCommand.equals(aggregationCommand.toString()))
                bolFlag =true;
        }
        return bolFlag;
    }

    /**
     * Método para retirar o comando CALCULATE de uma arraylist
     *
     * @param arrayList para retirar o comando
     */
    private void deleteCalculate(ArrayList<String> arrayList){
        int intLength = arrayList.size();
        String strCommands;
        for (int i = 0; i<intLength; i++){
            strCommands = arrayList.get(i);
            if(strCommands.equals("CALCULATE")){
                arrayList.remove(i);
                intLength--;
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

