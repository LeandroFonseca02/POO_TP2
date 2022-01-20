package helperClasses;
import Exceptions.NoLinesTableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TableFormatter {
    private ArrayList<HashMap<String,String>> table;
    private ArrayList<Integer> listMaxChar;
    private int intNumLines;
    private int intNumCols;

    /**
     * Contrutor da classe TableFormatter.
     * Inicializa uma nova ArrayList de Hashmap's onde os valores da tabela serão guardados.
     * Ininicializa os numeros de linhas e colunas da tabela a ser trabalhada.
     * Executa a função getCharSizeOfColumns calcula o máximo de caracteres por coluna
     * e guarda numa ArrayList listMaxChar.
     *
     * @param data ArrayList de Hashmap's, onde os dados estão guardados.
     * @param intNumLines numero de linhas da tabela.
     * @param intNumCols numero de colunas da tabela.
     */
    public TableFormatter(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
        this.listMaxChar = getCharSizeOfColumns();
    }

    /**
     * Método para calcular o número máximo de caracteres por coluna.
     * Percorre a tabela e guarda o tamanho máximo de cada coluna numa ArrayList.
     *
     * @return ArrayList com o número máximo de caracteres das colunas.
     */
    private ArrayList<Integer> getCharSizeOfColumns(){
        ArrayList<Integer> listMaxChar = new ArrayList<>();
        int intMaxChar = 0;
        int intCounter = 0;
        for (int i = 0; i < this.intNumCols; i++) {
            for (int j = 0; j < this.intNumLines; j++) {
                for (Map.Entry<String,String> entry : this.table.get(intCounter).entrySet()) {
                    intMaxChar = Math.max(entry.getValue().length(), intMaxChar);
                    intMaxChar = Math.max(entry.getKey().length(), intMaxChar);
                    intCounter++;
                }
            }
            listMaxChar.add(intMaxChar);
            intMaxChar = 0;
        }

        for (Integer integer : listMaxChar) {
            intMaxChar += integer;
        }
        listMaxChar.add(intMaxChar);

        return listMaxChar;
    }

    /**
     * Método para imprimir a tabela formatada.
     * Calcula os separadores e os formatadores de cada coluna.
     */
    public void printTable() throws NoLinesTableException {
        if(intNumLines == 0) throw new NoLinesTableException("");
        StringBuilder strHorizontalSep = new StringBuilder();
        ArrayList<String> stringArrayListFormatter = new ArrayList<>();
        int intCounter = 0;

        for(int i = 0; i < this.listMaxChar.size() -1; i++){
            stringArrayListFormatter.add("%" + this.listMaxChar.get(i) + "s");
        }

        System.out.println("-".repeat(this.listMaxChar.get(this.listMaxChar.size()-1) + (this.intNumCols *3) +1));
        System.out.print("| ");

        for (int i = 0; i < this.intNumCols; i++) {
            String strKey = "";
            for (int j = 0; j < this.intNumLines; j++) {
                for (Map.Entry<String,String> entry : this.table.get(intCounter).entrySet()) {
                    strKey = entry.getKey();
                    intCounter++;
                }
            }
            strHorizontalSep.append("+").append("-".repeat(this.listMaxChar.get(i) + 2));
            System.out.printf(stringArrayListFormatter.get(i) + " | ", strKey);
        }

        strHorizontalSep.append("+");
        System.out.println("\n"+strHorizontalSep);

        for (int i = 0; i < this.intNumLines; i++) {
            String strValue;
            System.out.print("| ");
            intCounter = i;
            for (int j = 0; j < this.intNumCols; j++) {
                for (Map.Entry<String,String> entry : this.table.get(intCounter).entrySet()) {
                    strValue = entry.getValue();
                    System.out.printf(stringArrayListFormatter.get(j) + " | ", strValue);
                    intCounter += intNumLines;
                }
            }
            System.out.println();
        }
        System.out.println(strHorizontalSep);
    }
}


