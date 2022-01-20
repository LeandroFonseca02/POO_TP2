import Exceptions.NoLinesTableException;
import helperClasses.*;

import java.util.*;

public class Load {
    Table objTable;
    Load(Table table, Scanner scanner) throws NoLinesTableException {
        this.objTable = new Table(table);
        this.processOutput(scanner);
    }

    public void processOutput(Scanner scanner) throws NoLinesTableException {
        Regex objRegex = new Regex(scanner.nextLine());
        ArrayList<String> arrayListCommand = objRegex.regex();
        Collections.reverse(arrayListCommand);
        Table objTableTemp = this.objTable;
        int intCounter = 0;
        for(String strMatch : arrayListCommand) {
            switch (strMatch) {
                case "ALL":
                    All all = new All(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) all.printTable();
                    break;
                case "DISTINCTCOUNT":
                    DistinctCount dc = new DistinctCount(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(dc);
                    break;
                case "COUNTROWS":
                    CountRows cr = new CountRows(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(cr);
                    break;
                case "SUM":
                    Sum sum = new Sum(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(sum);
                    break;
                case "AVERAGE":
                    Average avg = new Average(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(avg);
                    break;
                case "CALCULATE":
                    break;
                case "FILTER":
                case "&&":
                    Filter filter = new Filter(objTableTemp, new Expression(arrayListCommand.get(intCounter-1), arrayListCommand.get(intCounter-2), arrayListCommand.get(intCounter-3)));
                    objTableTemp = new Table(filter.getOutputTable());
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) objTableTemp.printTable();
                    break;
            }
            intCounter++;
        }
    }
}
