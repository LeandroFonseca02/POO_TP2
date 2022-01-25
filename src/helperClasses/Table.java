package helperClasses;
import Exceptions.NoLinesTableException;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private ArrayList<HashMap<String,String>> table;
    private int intNumLines;
    private int intNumCols;
    private TableFormatter tableFormatter;

    /**
     * Primeiro Construtor da classe Table.
     * Inicializa uma instância da classe Table, guardado os dados do
     * ficheiro lido bem como o seu número de linhas e o seu número de colunas.
     * Inicializa a partir de outro objeto da classe Table
     *
     * @param data objeto do tipo Table
     */
    public Table(Table data){
        this.table = data.getTable();
        this.intNumLines = data.getIntNumLines();
        this.intNumCols = data.getIntNumCols();
        this.tableFormatter = new TableFormatter(this.getTable(),this.intNumLines,this.intNumCols);
    }

    /**
     * Segundo construtor da classe Table.
     * Inicializa com os dados lidos do ficheiro o número de linhas e colunas.
     *
     * @param data dados lidos do ficheiro
     * @param intNumLines número de linha
     * @param intNumCols número de colunas
     */
    public Table(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
        this.tableFormatter = new TableFormatter(this.getTable(),this.intNumLines,this.intNumCols);
    }

    /**
     * Devolve o número de linhas dos dados.
     *
     * @return número de linhas
     */
    public int getIntNumLines() {return intNumLines;}

    /**
     * Devolve o número de colunas dos dados.
     *
     * @return número de colunas
     */
    public int getIntNumCols() {return intNumCols;}

    /**
     *  Imprime os dados formatados numa tabela.
     *  Lança exceção caso não exista valores a imprimir.
     *
     * @throws NoLinesTableException lançada quando a Tabela têm 0 linhas.
     */
    public void printTable() throws NoLinesTableException {this.tableFormatter.printTable();}

    /**
     *  Devolve os dados do ficheiro
     *
     * @return ArrayList de hashmaps que contem os dados
     */
    public ArrayList<HashMap<String, String>> getTable() {return table;}
}
