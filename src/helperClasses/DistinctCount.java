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
        printExtractedColumn(extractedColumn);
    }

    /**
     * Extrai uma coluna de dados para um Set, eliminando os elementos repetidos.
     *
     * @param data arraylist de hashmaps, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     * @return retorna o Set com os elementos da coluna extraída.
     */
    public Set<String> ExtractColumn(ArrayList<HashMap<String,String>> data, String column){
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

    public void printExtractedColumn(Set<String> extractedColumn){
        int intMaxChar = this.strColumn.length();
        StringBuilder strFormatter = new StringBuilder();
        for(String s: extractedColumn){
            intMaxChar = Math.max(s.length(), intMaxChar);
        }
        System.out.println("-".repeat(intMaxChar +4));
        strFormatter.append("%").append(intMaxChar).append("s");
        System.out.printf("| " + strFormatter + " |\n", this.strColumn);
        System.out.println("-".repeat(intMaxChar +4));


        for(String s: extractedColumn){
            System.out.printf("| " + strFormatter + " |\n", s);
        }
        System.out.println("-".repeat(intMaxChar +4));
    }
}

