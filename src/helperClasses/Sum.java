package helperClasses;

import Exceptions.NoNumberFieldException;
import Interfaces.Aggregation;

import java.util.*;

public class Sum implements Aggregation {
    private double sum;
    protected String column;
    private ArrayList<String> extractedColumn;

    /**
     * Contrutor da classe helperClasses.Sum.
     * Existe uma extração de uma coluna a partir dos dados do ficheiro
     * para uma ArrayList de Strings, e soma todos os elementos da mesma
     * guardado esse valor.
     *
     * @param data objeto table, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     * @throws NoNumberFieldException lançada quando a coluna não tem valor numérico.
     */
    public Sum(Table data, String column) throws NoNumberFieldException{
        extractedColumn = new ArrayList<>();
        this.column=column;
        ExtractColumn(data.getTable(), column);
        sumList();
    }

    /**
     * Extrai uma coluna de dados para uma ArrayList.
     *
     * @param data arraylist de hashmaps, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     * @return retorna a ArrayList com os elementos da coluna extraída.
     */
    public ArrayList<String> ExtractColumn(ArrayList<HashMap<String,String>> data, String column){
        for (HashMap<String, String> map : data) {
            if (map.containsKey(column))
                extractedColumn.add(map.get(column));
        }
        return extractedColumn;
    }

    /**
     *  Soma todos os elementos da ArrayList de Strings que contém os elementos
     *  da coluna extraída.
     *  Os valores são passados a double através de uma função parse.
     */
    public void sumList() throws  NoNumberFieldException{
        for(String s: extractedColumn){
            if(!Regex.isNumber(s)) throw new NoNumberFieldException("");
            sum += Double.parseDouble(s);
        }
    }

    /**
     * Retorna o número de elementos da coluna extraída.
     * @return número de elementos da coluna
     */
    public int numberOfElements(){
        return this.extractedColumn.size();
    }

    /**
     * Retorna a soma dos elementos da coluna extraída.
     * @return Soma dos elementos da coluna extraída
     */
    public double output(){
        return this.sum;
    }

    public String toString(){
        return "A soma dos elementos da coluna "+column+" é: "+output();
    }
}
