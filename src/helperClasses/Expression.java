package helperClasses;

public class Expression {
    String strOperator;
    String strColumn;
    String strToCompare;
    public Expression(String column, String signal, String value){
        this.strOperator=signal;
        this.strColumn=column;
        this.strToCompare = value;
    }

    public boolean isConditionTrue(String strCompareTo){
        if(Regex.isString(this.strToCompare)){
            switch(strOperator){
                case "=":
                    return (strCompareTo.equals(strToCompare));
                case "!=":
                    return (!strCompareTo.equals(strToCompare));
                default:
                    return false;
            }
        }else {
            double dblCompareTo = Double.parseDouble(strCompareTo);
            double dblNumCompare = Double.parseDouble(this.strToCompare);
            switch(strOperator){
                case ">":
                    return (dblCompareTo > dblNumCompare);
                case "<":
                    return (dblCompareTo < dblNumCompare);
                case ">=":
                    return (dblCompareTo >= dblNumCompare);
                case "<=":
                    return (dblCompareTo <= dblNumCompare);
                case "=":
                    return (dblCompareTo == dblNumCompare);
                case "!=":
                    return (dblCompareTo != dblNumCompare);
                default:
                    return false;
            }
        }
    }

    public String getColumn() {
        return this.strColumn;
    }
}
