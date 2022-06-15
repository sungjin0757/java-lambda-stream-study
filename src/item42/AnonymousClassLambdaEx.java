package item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassLambdaEx {
    public static void main(String[] args){
        //옛날에 많이 사용하는 방식
        //익명 클래스 방식은 코드의 길이가 너무 길어지기 때문에 함수형 프로그래밍에 적합하지 않음.
        List<String> words = new ArrayList<>();
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        //람다 형식
        Collections.sort(words, (o1,o2)->{
            return Integer.compare(o1.length(), o2.length());
        });

        // 생성자 메서드를 활용하여 더욱 간결하게 만듬
        Collections.sort(words, Comparator.comparingInt(String :: length));

        words.sort(Comparator.comparingInt(String :: length));
    }
}
