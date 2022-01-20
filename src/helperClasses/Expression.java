package helperClasses;

public class Expression {
    String signal;
    String column;
    int number;
    public Expression(String column, String signal, String number){
        this.signal=signal;
        this.column=column;
        this.number=Integer.parseInt(number);
    }

    public boolean transformSignal(int condition){
        switch(signal){
            case ">":
                return (condition>number);

            case "<":
                return (condition<number);

            case ">=":
                return (condition>=number);

            case "<=":
                return (condition<=number);

            case "=":
                return (condition==number);

            case "!=":
                return (condition!=number);

            default:
                return false;
        }

    }

    public String getColumn() {
        return column;
    }
}
