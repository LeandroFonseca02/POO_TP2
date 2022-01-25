package helperClasses;

import Exceptions.ImpossibleConditionException;
import Interfaces.Command;
import java.util.ArrayList;
import java.util.HashMap;

public class Filter implements Command {
    Table objTable;
    String strColumn;
    ArrayList<Integer> intList;

    /**
     * Contrutor da classe Filter.
     * Recebe um objeto do tipo Table para ser filtrado através de uma expressão
     *
     * @param table objeto do tipo Table
     * @param expression expressão a filtrar
     * @throws ImpossibleConditionException quando a condicao do filter é invalido
     */
    public Filter(Table table, Expression expression) throws ImpossibleConditionException{
        this.objTable = new Table(table);
        this.strColumn = expression.getColumn();
        this.intList=new ArrayList<>();
        filterTable(expression);
    }

    /**
     *  Método que filtra o objeto Table segundo a expressão
     *  presente na query.
     *
     * @param expression objeto Expression para filtrar a tabela.
     * @throws ImpossibleConditionException quando a condicao do filter é invalido
     */
    public void filterTable(Expression expression) throws ImpossibleConditionException {
        int counter = 0;
        for(HashMap<String, String> map :  this.objTable.getTable()){
            if(map.containsKey(this.strColumn)){
                if(expression.isConditionTrue(map.get(this.strColumn))){
                    this.intList.add(counter);
                }
                counter++;
            }
        }
    }

    /**
     *  Devolve um novo objeto Table que representa uma nova tabela de dados
     *  filtrada pela expressão.
     *
     * @return objeto Table com dados filtrados
     */
    public Table getOutputTable(){
        ArrayList<HashMap<String,String>> map = new ArrayList<>();
        int counter = 0;
        for(int i = 0; i<objTable.getIntNumCols(); i++){
            for(int j = 0; j<objTable.getIntNumLines(); j++) {
                if (this.intList.contains(j))
                    map.add(objTable.getTable().get(counter));
                counter++;
            }
        }
        return new Table(map, intList.size(), objTable.getIntNumCols());
    }
}
