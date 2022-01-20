package helperClasses;

public class Expression {
    String strOperator;
    String strColumn;
    int intNumCompare;
    public Expression(String column, String signal, String number){
        this.strOperator=signal;
        this.strColumn=column;
        this.intNumCompare=Integer.parseInt(number);
    }

    public boolean transformSignal(int intCompareTo){
        switch(strOperator){
            case ">":
                return (intCompareTo > this.intNumCompare);
            case "<":
                return (intCompareTo < this.intNumCompare);
            case ">=":
                return (intCompareTo >= this.intNumCompare);
            case "<=":
                return (intCompareTo <= this.intNumCompare);
            case "=":
                return (intCompareTo == this.intNumCompare);
            case "!=":
                return (intCompareTo != this.intNumCompare);
            default:
                return false;
        }
    }

    public String getColumn() {
        return this.strColumn;
    }
}
