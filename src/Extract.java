import java.io.*;
public class Extract {

    private String[][] data;
    private int intNumColumns, intNumLines;

    Extract(String path) throws IOException {
        countColumnsAndLines(path);
        data=new String[getIntNumLines()][getIntNumColumns()];
        readFile(data, path);
    }
    public void readFile(String[][] data, String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int i = 0;
        while((line= br.readLine())!= null){
            String[] SplittedString = line.split(",");
            for(int j = 0; j<SplittedString.length; j++){
                data[i][j]=SplittedString[j];
            }
            i++;
        }
        br.close();
    }
    public void countColumnsAndLines(String path) throws IOException {
        BufferedReader counter = new BufferedReader(new FileReader(path));
        int lines = 1;
        String[] lineSplitted = counter.readLine().split(",");
        String line;
        setIntNumColumns(lineSplitted.length);
        while((line = counter.readLine())!=null){lines++;}
        setIntNumLines(lines);
        counter.close();
    }
    public void setIntNumColumns(int value){this.intNumColumns = value;}
    public void setIntNumLines(int value){
        this.intNumLines = value;
    }
    public int getIntNumColumns(){
        return this.intNumColumns;
    }
    public int getIntNumLines(){
        return this.intNumLines;
    }
    public String[][] getOutput(){return data;}
}
