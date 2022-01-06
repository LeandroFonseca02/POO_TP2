import java.util.*;

public class Sum {
    private double sum;
    private ArrayList<String> extractedColumn;

    Sum(ArrayList<HashMap<String,String>> data, String column){
        extractedColumn = new ArrayList<>();
        sumList();
    }

    public ArrayList<String> ExtractColumn(ArrayList<HashMap<String,String>> data, String column){
        for (HashMap<String, String> map : data) {
            if (map.containsKey(column))
                extractedColumn.add(map.get(column));
        }
        return extractedColumn;
    }

    public void sumList(){
        for(String s: extractedColumn){
            sum += Double.parseDouble(s);
        }
    }

    public int numberOfElements(){
        return this.extractedColumn.size();
    }

    public double Output(){
        return this.sum;
    }
}
