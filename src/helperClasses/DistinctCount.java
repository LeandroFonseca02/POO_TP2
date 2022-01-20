package helperClasses;

import java.util.*;

public class DistinctCount {
    private Set<String> extractedColumn;
    private String strColumn;

    /**
     * Contrutor da classe DistictCount.
     * Inicializa um novo Set o qual irá conter o output desejado.
     * Executa a função Extractcolumn que extrai uma coluna dos dados
     * e guarda no Set extractedColumn.
     *
     * @param data objeto tabela, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     */
    public DistinctCount(Table data, String column){
        this.extractedColumn=new HashSet<>();
        this.strColumn = column;
        this.extractedColumn=ExtractColumn(data.getTable(),strColumn);
        this.output();
    }

    /**
     * Extrai uma coluna de dados para um Set, eliminando os elementos repetidos.
     *
     * @param data arraylist de hashmaps, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     * @return retorna o Set com os elementos da coluna extraída.
     */
    private Set<String> ExtractColumn(ArrayList<HashMap<String,String>> data, String column){
        for (HashMap<String, String> map : data) {
            if (map.containsKey(column))
                extractedColumn.add(map.get(column));
        }
        return extractedColumn;
    }

    /**
     * Retorna o Set de elementos de uma coluna extraída dos dados.
     *
     * @return Set de elementos da coluna.
     */
    public int output(){
        return this.extractedColumn.size();
    }

    /**
     * Retorna uma string com as informações do objeto
     *
     * @return string com as informações e output
     */
    public String toString(){
        return ("A coluna " + this.strColumn + " têm " + this.output() + " valores distintos!");
    }
}

