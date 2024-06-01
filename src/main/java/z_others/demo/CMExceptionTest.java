package z_others.demo;

import java.util.ArrayList;
import java.util.List;

public class CMExceptionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("xxxxx");
        list.add("xxxxx1");
        list.add("xxxxx2");
        list.add("xxxxx3");
        list.add("xxxxx4");

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("xxxxx")) {
//                list.remove(i);
//            }
//            System.out.println(i + ": " +  list.get(i));
//        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(i + ": " +  list.get(i));
        }
    }
}
