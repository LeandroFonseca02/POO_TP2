package helperClasses;

public class CountRows {
    private int intNumLinhas;

    public CountRows(Table table){
        this.intNumLinhas = table.getIntNumLines();
    }

    public String toString(){return ("A tabela têm " + this.intNumLinhas + " linhas!");}

}
