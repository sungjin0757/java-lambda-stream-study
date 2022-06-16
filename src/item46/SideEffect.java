package item46;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class SideEffect {
    public static void main(String[] args) throws IOException {
        Map<String, Long> freq = new HashMap<>();
        File file= new File(args[0]);

        /**
         * 반복 코드보다 길고, 읽기 어렵고, 유지보수도 어려운 코드
         * forEach가 그저 스트림이 수행한 연산 결과를 보여주는 일 이상을 하는 것은 별로 좋지 않다.
         * 계산 결과를 보고할 때만 사용하자.
         */
//        try(Stream<String> words = new Scanner(file).tokens()){
//            words.forEach(w ->{
//                freq.merge(w.toLowerCase(), 1L, Long::sum);
//            });
//        }

        /**
         * 스트림을 제대로 활용한 코드
         */
        try(Stream<String> words = new Scanner(file).tokens()){
            freq = words
                    .collect(groupingBy(String :: toLowerCase, counting()));
        }

    }
}
