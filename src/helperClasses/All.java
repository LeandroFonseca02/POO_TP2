package helperClasses;

import Exceptions.NoLinesTableException;

public class All implements Command{
    Table data;
    /**
     * Construtor da classe All.
     *
     * @param data tabela na qual vai trabalhar
     */
    public All(Table data){
        this.data=new Table(data);
    }
    public void printTable() throws NoLinesTableException {data.printTable();}
}
