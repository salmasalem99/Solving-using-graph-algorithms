
import java.util.Comparator;
public class costComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight o1, Flight o2) {
        if(o1.cost>o2.cost)
            return 1;
        else if(o1.cost<o2.cost)
            return -1;
        return 0;
    } 
}
