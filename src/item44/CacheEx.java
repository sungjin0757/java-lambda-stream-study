package item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheEx {
    public static void main(String[] args){
        /**
         * 템플릿 메소드 패턴
         * 오늘날 다시 구현한다면 함수 객체를 받는 정적 팩터리나 생성자를 제공했을 것
         * 인스턴스 메서드를 재정의 했기 때문에 size()와 같은 함수를 사용할 수 있었음
         * 만약 함수 객체를 받는 형식이었다면 사용하지 못함. 왜냐면 맵의 인스턴스가 존재하지 않기 때문.
         */
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 100;
            }
        };

        /**
         * 람다를 사용한 함수형 인터페이스.
         */
        EldestEntryRemovalFunction function = (m, e) ->{
            if(m.size() > 100){
                return true;
            }
            return false;
        };
    }
}
