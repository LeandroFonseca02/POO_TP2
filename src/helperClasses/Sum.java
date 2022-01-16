package helperClasses;

import java.util.*;

public class Sum {
    private double sum;
    private ArrayList<String> extractedColumn;

    /**
     * Contrutor da classe helperClasses.Sum.
     * Existe uma extração de uma coluna a partir dos dados do ficheiro
     * para uma ArrayList de Strings, e soma todos os elementos da mesma
     * guardado esse valor.
     *
     * @param data objeto table, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     */
    public Sum(Table data, String column){
        extractedColumn = new ArrayList<>();
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
    public void sumList(){
        for(String s: extractedColumn){
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
    public double Output(){
        return this.sum;
    }
}
