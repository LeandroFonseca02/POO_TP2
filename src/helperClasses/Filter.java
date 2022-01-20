package helperClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class Filter {
    Table objTable;
    String strColumn;
    ArrayList<Integer> intList;
    public Filter(Table table, Expression expression){
        this.objTable = new Table(table);
        this.strColumn = expression.getColumn();
        this.intList=new ArrayList<>();
        filterTable(expression);
    }

    public void filterTable(Expression expression){
        int counter = 0;
        for(HashMap<String, String> map :  this.objTable.getTable()){
            if(map.containsKey(this.strColumn)){
                if(expression.transformSignal(map.get(this.strColumn))){
                    this.intList.add(counter);
                }
                counter++;
            }
        }
    }

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
