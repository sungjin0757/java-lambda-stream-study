package item47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sublists {
    public static <E> Stream<List<E>> of(List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(Sublists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list){
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(e -> list.subList(0,e));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list){
        return IntStream.range(0, list.size())
                .mapToObj(s -> list.subList(s, list.size()));
    }
}
