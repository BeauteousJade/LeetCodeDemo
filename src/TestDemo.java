import java.util.HashMap;
import java.util.Map;

public class TestDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(5, 1);
        map.put(4, 1);
        map.put(2, 1);
        map.put(100, 1);

        System.out.println(map.keySet());
    }

}
