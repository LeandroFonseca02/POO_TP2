package JUnit;

import Exceptions.ImpossibleConditionException;
import helperClasses.Expression;
import helperClasses.Filter;
import helperClasses.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    public Table initMap(){
        ArrayList<HashMap<String,String>> map = new ArrayList<>();
        HashMap<String,String> Hash1 = new HashMap<>();
        Hash1.put("A", "1");
        HashMap<String,String> Hash4 = new HashMap<>();
        Hash4.put("A", "4");
        HashMap<String,String> Hash7 = new HashMap<>();
        Hash7.put("A", "7");
        HashMap<String,String> Hash2 = new HashMap<>();
        Hash2.put("B", "2");
        HashMap<String,String> Hash5 = new HashMap<>();
        Hash5.put("B", "5");
        HashMap<String,String> Hash8 = new HashMap<>();
        Hash8.put("B", "8");
        HashMap<String,String> Hash3 = new HashMap<>();
        Hash3.put("C", "Portugal");
        HashMap<String,String> Hash6 = new HashMap<>();
        Hash6.put("C", "Portugal");
        HashMap<String,String> Hash9 = new HashMap<>();
        Hash9.put("C", "França");
        map.add(Hash1);
        map.add(Hash4);
        map.add(Hash7);
        map.add(Hash2);
        map.add(Hash5);
        map.add(Hash8);
        map.add(Hash3);
        map.add(Hash6);
        map.add(Hash9);
        Table table = new Table(map,3,3);
        return table;
    }
    @Test
    void getOutputTable() throws ImpossibleConditionException {
        Table table = initMap();
        Filter filter = new Filter(table, new Expression("A", "=", "1"));
        assertEquals(1, filter.getOutputTable().getIntNumLines());
        assertEquals(3, filter.getOutputTable().getIntNumCols());
        Filter filter2 = new Filter(table, new Expression("C", "=", "Portugal"));
        assertEquals(2, filter2.getOutputTable().getIntNumLines());
        assertEquals(3, filter2.getOutputTable().getIntNumCols());
    }
}