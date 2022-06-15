package item43;

import java.util.HashMap;
import java.util.Map;

public class MethodRefEx {
    public static void main(String[] args){
        Map<String, Integer> map =new HashMap<>();
        // 람다의 길이가 길어짐. 메소드 참조로 간결화 가능.
        String key = "A";
        map.merge(key, 1, (cnt, incr) -> cnt + incr);

        // 메서드 참조
        map.merge(key, 1, Integer::sum);

    }
}
