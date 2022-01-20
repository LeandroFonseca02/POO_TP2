import helperClasses.*;

import java.util.*;

public class Load {
    Table objTable;
    Load(Table table, Scanner scanner) throws Exception {
        this.objTable = new Table(table);
        this.processOutput(scanner);
    }

    public void processOutput(Scanner scanner) throws Exception {
        Regex objRegex = new Regex(scanner.nextLine());
        ArrayList<String> arrayListCommand = objRegex.regex();
        Collections.reverse(arrayListCommand);
        Table objTableTemp = this.objTable;
        for(String strMatch : arrayListCommand) {
            switch (strMatch) {
                case "ALL":
                    All all = new All(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) all.printTable();
                    break;
                case "DISTINCTCOUNT":
                    DistinctCount dc = new DistinctCount(objTableTemp, arrayListCommand.get(arrayListCommand.indexOf(strMatch)-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(dc);
                    break;
                case "COUNTROWS":
                    CountRows cr = new CountRows(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(cr);
                    break;
                case "SUM":
                    Sum sum = new Sum(objTableTemp, arrayListCommand.get(arrayListCommand.indexOf(strMatch)-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(sum);
                    break;
                case "AVERAGE":
                    Average avg = new Average(objTableTemp, arrayListCommand.get(arrayListCommand.indexOf(strMatch)-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(avg);
                    break;
                case "CALCULATE":
                    break;
                case "FILTER":
                case "&&":
                    Filter filter = new Filter(objTableTemp, new Expression(arrayListCommand.get(arrayListCommand.indexOf(strMatch)-1), arrayListCommand.get(arrayListCommand.indexOf(strMatch)-2), arrayListCommand.get(arrayListCommand.indexOf(strMatch)-3)));
                    objTableTemp = new Table(filter.getOutputTable());
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) objTableTemp.printTable();
                    break;
            }
        }
    }
}
