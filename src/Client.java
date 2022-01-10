import java.io.IOException;
import java.util.*;
import helperClasses.*;

public class Client {
    public static void main(String[] args){
        try{
            Extract objExtract = new Extract("./resources/Customer_Data.csv");
            //System.out.println("Numero Linhas : " + objExtract.getIntNumLines()  + "\nNumero Colunas : " + objExtract.getIntNumColumns());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            TableFormatter objTableFormatter = new TableFormatter(objTransform.getDataStorage(), objExtract.getIntNumLines()-1, objExtract.getIntNumColumns());
            objTableFormatter.printTable();

        }catch (IOException ioException){
            System.out.println("Ficheiro nao encontrado");
        }
    }
}