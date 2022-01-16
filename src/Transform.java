import java.util.*;
import helperClasses.Table;

public class Transform {
    private ArrayList<HashMap<String,String>> dataStorage;
    int intNumLines;
    int intNumCols;
    Transform(String[][]strMatrixData){
        dataStorage = new ArrayList<>();
        transformData(strMatrixData, dataStorage);
        this.intNumLines = strMatrixData.length-1;
        this.intNumCols = strMatrixData[0].length;
    }
    private void transformData(String[][] strMatrixData, ArrayList<HashMap<String,String>> dataStorage) {
        for(int j = 0; j<strMatrixData[0].length; j++){
            for(int i = 1; i<strMatrixData.length; i++){
                HashMap<String,String> map = new HashMap<>();
                map.put(strMatrixData[0][j], strMatrixData[i][j]);
                dataStorage.add(map);
            }
        }
    }
    public Table getDataStorage() {
        return new Table(this.dataStorage,this.intNumLines,this.intNumCols);
    }
}
