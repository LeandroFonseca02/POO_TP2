package helperClasses;

public class Expression {
    String strOperator;
    String strColumn;
    String strToCompare;

    /**
     * Costrutor da classe Expression.
     * Instância um objeto da classe Expression que irá representar uma
     * expressão na query.
     * Inicializando váriaveis que representam a chave da coluna, à qual
     * será aplicada a expresssão, o sinal da expressão, e a referência
     * de comparação.
     *
     * @param column chave da coluna.
     * @param signal sinal da expressão.
     * @param value o que irá ser comparado.
     */
    public Expression(String column, String signal, String value){
        this.strOperator=signal;
        this.strColumn=column;
        this.strToCompare = value;
    }

    /**
     * Traduz o sinal de comparação presente na expressão e compara
     * com a referência de comparação.
     * Este método faz ainda uma verificação, para saber se se trata
     * de um número ou de uma String para poder aplicar diferentes
     * comparações.
     *
     * @param strCompareTo
     * @return
     */
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

    /**
     * Devolve a chave da coluna que irá ser aplicada a expressão
     *
     * @return chave da coluna
     */
    public String getColumn() {
        return this.strColumn;
    }
}
