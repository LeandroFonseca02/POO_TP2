import java.io.IOException;

import helperClasses.*;

public class Client {
    public static void main(String[] args) {
        try {
            Extract objExtract = new Extract("./resources/Customer_Data.csv");
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            Table objTable = objTransform.getDataStorage();
            //All a = new All(objTable);


            DistinctCount dc = new DistinctCount(objTable, "Age");
//            Sum s = new Sum(objTable, "Age");
//            System.out.println(s.Output());
//            Average av = new Average(objTable, "Age");
//            System.out.println(av.Output());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}