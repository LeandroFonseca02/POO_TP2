package helperClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class Filter {
    Table table;
    String column;
    ArrayList<Integer> list;
    public Filter(Table table, Expression expression){
        this.table = new Table(table.getTable(), table.getIntNumLines(), table.getIntNumCols());
        this.column = expression.getColumn();
        list=new ArrayList<>();
        filterTable(expression);
    }

    public void filterTable(Expression expression){
        int counter = 0;
        for(HashMap<String, String> map :  table.getTable()){
            if(map.containsKey(column)){

                if(expression.transformSignal(Integer.parseInt(map.get(column)))){
                    list.add(counter);
                }
                counter++;
            }
        }
    }

    public Table qualquer(){
        ArrayList<HashMap<String,String>> map = new ArrayList<>();
        int counter = 0;
        for(int i = 0; i<table.getIntNumCols(); i++){
            for(int j = 0; j<table.getIntNumLines(); j++) {
                if (list.contains(j))
                    map.add(table.getTable().get(counter));
                counter++;
            }
        }
        return new Table(map, list.size(), table.getIntNumCols());
    }
}
