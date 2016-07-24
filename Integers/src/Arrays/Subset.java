package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arjun on 7/10/16.
 */
public class Subset {

//    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        for(int i = 0 ; i < Math.pow(2,a.size()); i++){
//            ArrayList<Integer> set = new ArrayList<Integer>();
//            int num = i;
//            int mask = 1;
//            int pos =0;
//            while(num > 0 && pos < a.size()){
//                if((num & mask) > 0 ){
//                    set.add(a.get(pos));
//                }
//                //System.out.print("added element:" + a.get(pos) + "pos:" + pos + "mask:" + mask + "***");
//                mask = mask << 1;
//                pos++;
//
//            }
//            //System.out.print("-----Added Set of size :" + set.size() + " ---- ");
//            res.add(set);
//         }
//
//        Collections.sort(res, new Comparator<List<Integer>>() {
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return o1.get(0).compareTo(o2.get(0));
//            }});
//       return res;
//    }
}
