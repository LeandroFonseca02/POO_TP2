import java.util.*;

public class Transform {
    private ArrayList<HashMap<String,String>> dataStorage;
    Transform(String[][]strMatrixData){
        dataStorage = new ArrayList<>();
        transformData(strMatrixData, dataStorage);
    }
    private void transformData(String[][] strMatrixData, ArrayList<HashMap<String,String>> dataStorage) {
        for(int j = 0; j<strMatrixData[0].length; j++){
            for(int i = 1; i<strMatrixData.length; i++){
                HashMap<String, String> map = new HashMap<>();
                map.put(strMatrixData[0][j], strMatrixData[i][j]);
                dataStorage.add(map);
            }
        }
    }
    public ArrayList<HashMap<String, String>> getDataStorage() {
        return dataStorage;
    }
}
