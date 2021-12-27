import java.io.IOException;

public class Client {
    public static void main(String[] args){
        try{
            Extract objExtract = new Extract("./resources/Customer_Data.csv");
            System.out.println("Numero Linhas : " + objExtract.getIntNumLines() + "\nNumero Colunas : " + objExtract.getIntNumColumns());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
        }catch (IOException ioException){
            System.out.println("Ficheiro nao encontrado");
        }

    }
}