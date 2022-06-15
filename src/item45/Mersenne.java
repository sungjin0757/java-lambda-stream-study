package item45;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Mersenne {
     static Stream<BigInteger> primes(){
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args){
         primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                 .filter(m -> m.isProbablePrime(50))
                 .limit(20)
                 .forEach(System.out::println);

        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(m -> m.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": "+mp));
    }
}
