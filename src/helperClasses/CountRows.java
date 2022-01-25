package helperClasses;

public class CountRows implements Aggregation{
    private int intNumLinhas;

    /**
     * Construtor da classe CountRows.
     * inicializa uma variável e guarda o número de linhas de um objeto Table.
     *
     * @param table objeto table a saber o número de linhas.
     */
    public CountRows(Table table){
        this.intNumLinhas = table.getIntNumLines();
    }

    /**
     * Devolve o número de linhas de um objeto Table
     *
     * @return
     */
    public String toString(){return ("A tabela têm " + this.intNumLinhas + " linhas!");}
}
