import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = List.of(1,2,3);  // THROWS AN EXCEPTION!
        List<Integer> list = new ArrayList<>(List.of(1,2,3));

        list.add(4);

        for (var entry : list){
            System.out.println(entry);
        }
    }
}