import java.io.IOException;

import helperClasses.*;

public class Client {
    public static void main(String[] args) {
        try {
            Extract objExtract = new Extract("./resources/Customer_Data.csv");
            //System.out.println("Numero Linhas : " + objExtract.getIntNumLines()  + "\nNumero Colunas : " + objExtract.getIntNumColumns());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            TableFormatter objTableFormatter = new TableFormatter(objTransform.getDataStorage(), objExtract.getIntNumLines()-1, objExtract.getIntNumColumns());
            objTableFormatter.printTable();

            //helperClasses.DistinctCount dc = new helperClasses.DistinctCount(objTransform.getDataStorage(), "Age");
            Sum s = new Sum(objTransform.getDataStorage(), "Age");
            System.out.println(s.Output());
            Average av = new Average(objTransform.getDataStorage(), "Age");
            System.out.println(av.Output());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}