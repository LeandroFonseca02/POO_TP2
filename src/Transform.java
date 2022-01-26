import java.util.*;
import helperClasses.Table;

public class Transform {
    private ArrayList<HashMap<String,String>> dataStorage;
    private int intNumLines;
    private int intNumCols;

    /**
     * Construtor da classe Transform.
     * Recebe a«uma matriz de strings e transforma numa ArrayList de HashMap's.
     *
     * @param strMatrixData matriz de strings com conteúdo da tabela.
     */
    Transform(String[][]strMatrixData){
        this.dataStorage = new ArrayList<>();
        transformData(strMatrixData);
        this.intNumLines = strMatrixData.length-1;
        this.intNumCols = strMatrixData[0].length;
    }

    /**
     * Método que converte uma matriz de String's para uma ArrayList de HashMap's.
     * Percorre a matriz e adiciona os elementos na ArrayList de HashMap's.
     *
     * @param strMatrixData matriz de strings com conteúdo da tabela.
     */
    private void transformData(String[][] strMatrixData) {
        for(int j = 0; j<strMatrixData[0].length; j++){
            for(int i = 1; i<strMatrixData.length; i++){
                HashMap<String,String> map = new HashMap<>();
                map.put(strMatrixData[0][j], strMatrixData[i][j]);
                this.dataStorage.add(map);
            }
        }
    }

    /**
     * Método que retorna uma Tabela.
     *
     * @return objeto tabela com o conteúdo da matriz.
     */
    public Table getDataStorage() {return new Table(this.dataStorage,this.intNumLines,this.intNumCols);}
}
