import java.util.*;

public class Average extends Sum{
    private double average;

    /**
     * Contrutor da classe Average.
     * Existe uma extração de uma coluna a partir dos dados do ficheiro
     * para uma ArrayList de Strings, realizando uma média aos valores
     * extraídos.
     *
     * @param data arraylist de hashmaps, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     */
    Average(ArrayList<HashMap<String, String>> data, String column) {
        super(data, column);
        calculateAverage(super.Output(), super.numberOfElements());
    }

    /**
     * Calcula a média de uma soma de elementos duma lista.
     *
     * @param sum soma de elementos de uma lista
     * @param elems número de elementos de uma lista
     */
    public void calculateAverage(double sum, int elems){
         average=sum/elems;
    }

    /**
     * Retorna a média dos elementos de uma lista
     * @return média dos elementos de uma list
     */
    public double Output(){
        return average;
    }
}
