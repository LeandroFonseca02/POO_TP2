import helperClasses.*;

import java.io.IOException;
import java.util.*;

enum Command {
    ALL,
    DISTINCTCOUNT,
    AVERAGE,
    SUM,
    COUNTROWS
}


public class Client {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            StringBuilder s = new StringBuilder("./resources/");
            String filename = in.nextLine();
            s.append(filename);
            String column;
            Extract objExtract = new Extract(s.toString());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            Table objTable = objTransform.getDataStorage();
            Regex r = new Regex(in.nextLine());
            ArrayList<String> arr = r.regex();
            Collections.reverse(arr);
            Table temp = objTable;
            for(String ds : arr) {
                switch (ds) {
                    case "ALL":
                        All all = new All(temp);
                        all.printTable();
                        break;
                    case "DISTINCTCOUNT":
                        DistinctCount dc = new DistinctCount(temp, arr.get(arr.indexOf(ds)-1));
                        System.out.println(dc);
                        break;
                    case "COUNTROWS":
                        CountRows cr = new CountRows(temp);
                        System.out.println(cr);
                        break;
                    case "SUM":
                        Sum sum = new Sum(temp, arr.get(arr.indexOf(ds)-1));
                        System.out.println(sum);
                        break;
                    case "AVERAGE":
                        Average avg = new Average(temp, arr.get(arr.indexOf(ds)-1));
                        System.out.println(avg);
                        break;
                    case "CALCULATE":
                        break;
                    case "FILTER":
                    case "&&":
                        Filter filter = new Filter(temp, new Expression(arr.get(arr.indexOf(ds)-1), arr.get(arr.indexOf(ds)-2), arr.get(arr.indexOf(ds)-3)));
                         temp = new Table(filter.qualquer());
                        break;
                    default:

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}