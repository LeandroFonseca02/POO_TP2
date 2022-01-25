import Exceptions.*;
import helperClasses.*;

import java.io.IOException;
import java.util.*;
enum Aggregation{
    AVERAGE,
    SUM,
    DISTINCTCOUNT,
    COUNTROWS
};

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
        }catch (NoNumberFieldException noNumberFieldException){
            System.out.println("A coluna que está a tentar calcular o AVERAGE/SUM não são números!");
        }catch (ImpossibleConditionException impossibleConditionException) {
            System.out.println("A expressão que tentou calcular não é possível!");
        } catch (ImpossibleCalculateException e) {
            System.out.println("Pimbas");
        }
    }
}