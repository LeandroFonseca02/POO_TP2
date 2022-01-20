import helperClasses.*;

import java.io.IOException;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            StringBuilder strPath = new StringBuilder("./resources/");
            String strFileName = scanner.nextLine();
//            String strFileName = "Customer_Data.csv";
            strPath.append(strFileName);
            Extract objExtract = new Extract(strPath.toString());
            Transform objTransform = new Transform(objExtract.getStrMatrixData());
            Load objLoad = new Load(objTransform.getDataStorage(),scanner);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}