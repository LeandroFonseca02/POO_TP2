import java.io.*;
public class Extract {

    private final String[][] strMatrixData;
    private int intNumColumns, intNumLines;

    Extract(String strFilePath) throws IOException {
        countColumnsAndLines(strFilePath);
        strMatrixData = new String[this.getIntNumLines()][this.getIntNumColumns()];
        readFile(strMatrixData, strFilePath);
    }
    public void readFile(String[][] strMatrixData, String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String strLine;
        for (int i = 0; (strLine = bufferedReader.readLine()) != null; i++){
            String[] strSplittedLine = strLine.split(",");
            for (int j = 0; j < strSplittedLine.length; j++){
                strMatrixData[i][j] = strSplittedLine[j];
            }
        }
        bufferedReader.close();
    }
    public void countColumnsAndLines(String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String[] strSplittedLine = bufferedReader.readLine().split(",");
        int intNumLines;
        String strLine;
        setIntNumColumns(strSplittedLine.length);
        for (intNumLines = 1; (strLine = bufferedReader.readLine()) != null; intNumLines++);
        setIntNumLines(intNumLines);
        bufferedReader.close();
    }
    public void setIntNumColumns(int intNumColumns){this.intNumColumns = intNumColumns;}

    public void setIntNumLines(int intNumLines){this.intNumLines = intNumLines;}

    public int getIntNumColumns(){return this.intNumColumns;}

    public int getIntNumLines(){return this.intNumLines;}

    public String[][] getStrMatrixData(){return this.strMatrixData;}
}
