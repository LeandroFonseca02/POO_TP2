package helperClasses;

public class All {
    Table data;
    /**
     * Construtor da classe All.
     *
     * @param data tabela na qual vai trabalhar
     */
    public All(Table data){
        this.data=new Table(data);
    }
    public void printTable(){
        data.printTable();
    }
}
