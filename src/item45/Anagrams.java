package item45;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();

        try(Scanner s = new Scanner(dictionary)){
            while(s.hasNext()){
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        /**
         * stream을 과도하게 사용한 버젼
         * 읽기 굉장히 어려움.
         */
        try(Stream<String> words = Files.lines(Paths.get(args[0]))){
            words.collect(
                    Collectors.groupingBy(w -> w.chars().sorted()
                            .collect(StringBuilder::new, (sb,c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(g -> g.size() >=minGroupSize)
                    .map(g -> g.size() + ": "+g)
                    .forEach(System.out::println);
        }

        /**
         * 간결한 버젼
         */
        try(Stream<String> words = Files.lines(Paths.get(args[0]))){
            words.collect(Collectors.groupingBy(w -> alphabetize(w)))
                    .values().stream()
                    .filter(g -> g.size() >=minGroupSize)
                    .map(g -> g.size() + ": "+g)
                    .forEach(System.out::println);
        }

        for (Set<String> value : groups.values()) {
            if(value.size() >= minGroupSize){
                System.out.println(value.size() + " : "+value);
            }
        }
    }

    private static String alphabetize(String s){
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
