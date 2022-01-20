package helperClasses;

import java.util.*;

public class Average extends Sum {
    private double average;

    /**
     * Contrutor da classe helperClasses.Average.
     * Existe uma extração de uma coluna a partir dos dados do ficheiro
     * para uma ArrayList de Strings, realizando uma média aos valores
     * extraídos.
     *
     * @param data objeto tabela, onde os dados estão guardados.
     * @param column chave da coluna a extraír os elementos.
     */
    public Average(Table data, String column) {
        super(data, column);
        calculateAverage(super.output(), super.numberOfElements());
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
    public double output(){
        return average;
    }

    public String toString(){
        return"A média dos elementos da coluna "+super.column+" é: "+output();
    }
}
