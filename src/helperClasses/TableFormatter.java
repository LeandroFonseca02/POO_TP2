package helperClasses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TableFormatter {
    private ArrayList<HashMap<String,String>> table;
    private ArrayList<Integer> listMaxChar;
    private int intNumLines;
    private int intNumCols;


    public TableFormatter(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
        this.listMaxChar = getCharSizeOfColumns();
    }

    public int getIntNumCols() {return this.intNumCols;}

    public int getIntNumLines() {return this.intNumLines;}

    public ArrayList<HashMap<String, String>> getTable() {return table;}

    public ArrayList<Integer> getListMaxChar() {return listMaxChar;}

    public ArrayList<Integer> getCharSizeOfColumns(){
        ArrayList<Integer> listMaxChar = new ArrayList<>();
        int intMaxChar = 0;
        int intCounter = 0;
        for (int i = 0; i < this.getIntNumCols(); i++) {
            for (int j = 0; j < this.getIntNumLines(); j++) {
                for (Map.Entry<String,String> entry : this.getTable().get(intCounter).entrySet()) {
                    intMaxChar = Math.max(entry.getValue().length(), intMaxChar);
                    intMaxChar = Math.max(entry.getKey().length(), intMaxChar);
                    intCounter++;
                }
            }
            listMaxChar.add(intMaxChar);
            intMaxChar = 0;
        }

        for (Integer integer : listMaxChar) {
            intMaxChar += integer;
        }
        listMaxChar.add(intMaxChar);

        return listMaxChar;
    }

    public void printTable(){
        StringBuilder strHorizontalSep = new StringBuilder();
        ArrayList<String> stringArrayListFormatter = new ArrayList<>();
        int intCounter = 0;

        for(int i = 0; i < this.getListMaxChar().size() -1; i++){
            stringArrayListFormatter.add("%" + this.getListMaxChar().get(i) + "s");
        }

        System.out.println("-".repeat(this.getListMaxChar().get(this.getListMaxChar().size()-1) + (this.getIntNumCols() *3) +1));
        System.out.print("| ");

        for (int i = 0; i < this.getIntNumCols(); i++) {
            String strKey = "";
            for (int j = 0; j < this.getIntNumLines(); j++) {
                for (Map.Entry<String,String> entry : this.getTable().get(intCounter).entrySet()) {
                    strKey = entry.getKey();
                    intCounter++;
                }
            }
            strHorizontalSep.append("+").append("-".repeat(this.getListMaxChar().get(i) + 2));
            System.out.printf(stringArrayListFormatter.get(i) + " | ", strKey);
        }

        strHorizontalSep.append("+");
        System.out.println("\n"+strHorizontalSep);

        for (int i = 0; i < this.getIntNumLines(); i++) {
            String strValue;
            System.out.print("| ");
            intCounter = i;
            for (int j = 0; j < this.getIntNumCols(); j++) {
                for (Map.Entry<String,String> entry : this.getTable().get(intCounter).entrySet()) {
                    strValue = entry.getValue();
                    System.out.printf(stringArrayListFormatter.get(j) + " | ", strValue);
                    intCounter += getIntNumLines();
                }
            }
            System.out.print("\n");
        }
        System.out.println(strHorizontalSep);
    }
}


