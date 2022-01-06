import java.util.*;

public class Average extends Sum{
    private double average;
    Average(ArrayList<HashMap<String, String>> data, String column) {
        super(data, column);
        calculateAverage(super.Output(), super.numberOfElements());
    }

    public void calculateAverage(double sum, int elems){
         average=sum/elems;
    }

    public double Output(){
        return average;
    }
}
