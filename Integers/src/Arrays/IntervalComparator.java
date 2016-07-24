package Arrays;

import java.util.Comparator;

/**
 * Created by arjun on 7/24/16.
 */
class IntervalComparator implements Comparator {
    public int compare(Object o1, Object o2){
        Interval i1 = (Interval)o1;
        Interval i2 = (Interval)o2;
        return i1.start - i2.start;
    }
}
