import Exceptions.NoLinesTableException;
import helperClasses.*;

import java.io.IOException;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strPath = new StringBuilder("./resources/");
//            String strFileName = scanner.nextLine();
        String strFileName = "Customer_Data.csv";
        strPath.append(strFileName);
        try {
            Extract objExtract = new Extract(strPath.toString());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            Load objLoad = new Load(objTransform.getDataStorage(),scanner);
        } catch (IOException ioException) {
            System.out.println("Não foi encontrado o ficheiro " + strPath.toString() + "!");
        } catch (NoLinesTableException noLinesTableException) {
            System.out.println("A tabela resultante têm 0 linhas, logo não pode ser apresentada!");
        }
    }
}