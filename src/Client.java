import java.io.IOException;

import helperClasses.*;

public class Client {
    public static void main(String[] args) {
        try {
            Extract objExtract = new Extract("./resources/Customer_Data.csv");
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            Table objTable = objTransform.getDataStorage();
            //All a = new All(objTable);


//            CountRows countRows = new CountRows(objTable);
//            System.out.println(countRows);
            DistinctCount dc = new DistinctCount(objTable, "Geography");
            System.out.println(dc);
//            Sum s = new Sum(objTable, "Balance");
//            System.out.println(s.Output());
//            Average av = new Average(objTable, "Tenure");
//            System.out.println(av.Output());
        } catch (IOException e) {
            System.out.println("Ficheiro nao encontrado");
        }
    }
}