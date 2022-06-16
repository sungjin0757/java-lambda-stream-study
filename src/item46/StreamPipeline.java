package item46;

import item42.Operation;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class StreamPipeline {
    /**
     * toMap 수집기를 사용하여 문자열을 열거 타입 상수에 매핑한다.
     */
    private static final Map<String, Operation> stringToEnum = Stream
            .of(Operation.values()).collect(toMap(Objects::toString, e -> e));

    public static void main(String[] args){
        Map<String, Long> freq = new HashMap<>();

        /**
         * 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
         */
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        /**
         * 각 키와 해당 키의 특정 원소를 연관 짓는 맵을 생성하는 수집기
         * key : artist , value : Best Album
         */
        List<Album> albums = new ArrayList<>();
        Map<Artist, Album> topHits = albums.stream()
                .collect(toMap(Album :: getArtist, a -> a, BinaryOperator.maxBy(comparing(Album::getSales))));
    }
}

class Artist{

}

class Album{
    Artist artist;
    int sales;

    public Artist getArtist() {
        return artist;
    }

    public int getSales() {
        return sales;
    }
}
