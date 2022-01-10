package helperClasses;
import java.util.*;

public class DistinctCount {
    private Set<String> extractedColumn;

    /**
     * Contrutor da classe DistictCount.
     * Inicializa um novo Set o qual irá conter o output desejado.
     * Executa a função Extractcolumn que extrai uma coluna dos dados
     * e guarda no Set extractedColumn.
     *
     * @param data arraylist de hashmaps, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     */
    DistinctCount(ArrayList<HashMap<String,String>> data, String column){
        extractedColumn=new HashSet<>();
        extractedColumn=ExtractColumn(data,column);
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
    public int Output(){
        return this.extractedColumn.size();
    }

    public void printExtractedColumn(Set<String> extractedColumn){
        for(String s: extractedColumn){
            System.out.println(s);
        }
    }
}

