import Exceptions.ImpossibleConditionException;
import Exceptions.NoLinesTableException;
import Exceptions.NoNumberFieldException;
import Exceptions.ImpossibleCalculateException;
import helperClasses.*;

import java.util.*;

public class Load {
    Table objTable;

    /**
     * Construtor da classe Load
     * Recebe um objeto Table e o scanner
     * Lança uma exceção caso não exista valores a apresentar,
     * no caso de uma query que não tenha resultados.
     *
     * @param table objeto Table
     * @param scanner Scanner de inputs
     * @throws NoLinesTableException
     */
    Load(Table table, Scanner scanner) throws NoLinesTableException, NoNumberFieldException, ImpossibleConditionException, ImpossibleCalculateException {
        this.objTable = new Table(table);
        this.processOutput(scanner);
    }

    /**
     * Recebe uma query pelo scanner.
     * Inicializa um objeto da classe Regex,
     * para receber uma ArrayList com a informação filtrada da query.
     * Inverte essa ArrayList para percorrer a query filtrada do fim
     * para o início.
     * Encontra na Arraylist comandos para executar e enquanto existir
     * comandos a executar, irá aplicá-los no objeto Table.
     * Lança uma exceção para o caso de não haver valores a apresentar.
     *
     * @param scanner
     * @throws NoLinesTableException 
     */
    public void processOutput(Scanner scanner) throws NoLinesTableException, NoNumberFieldException, ImpossibleConditionException, ImpossibleCalculateException {
        Regex objRegex = new Regex(scanner.nextLine());
        ArrayList<String> arrayListCommand = objRegex.regex();
        Collections.reverse(arrayListCommand);
        Table objTableTemp = this.objTable;
        int intCounter = 0;
        for(String strMatch : arrayListCommand) {
            switch (strMatch) {
                case "ALL":
                    All all = new All(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) all.printTable();
                    break;
                case "DISTINCTCOUNT":
                    DistinctCount dc = new DistinctCount(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(dc);
                    break;
                case "COUNTROWS":
                    CountRows cr = new CountRows(objTableTemp);
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(cr);
                    break;
                case "SUM":
                    Sum sum = new Sum(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(sum);
                    break;
                case "AVERAGE":
                    Average avg = new Average(objTableTemp, arrayListCommand.get(intCounter-1));
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) System.out.println(avg);
                    break;
                case "FILTER":
                case "&&":
                    Filter filter = new Filter(objTableTemp, new Expression(arrayListCommand.get(intCounter-1), arrayListCommand.get(intCounter-2), arrayListCommand.get(intCounter-3)));
                    objTableTemp = new Table(filter.getOutputTable());
                    if(strMatch.equals(arrayListCommand.get(arrayListCommand.size()-1))) objTableTemp.printTable();
                    break;
            }
            intCounter++;
        }
    }
}
