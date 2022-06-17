package item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelGoodEx {
    static long pi(long n){
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger :: valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    /**
     * 병렬 버전
     */
    static long piParallel(long n){
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger :: valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
