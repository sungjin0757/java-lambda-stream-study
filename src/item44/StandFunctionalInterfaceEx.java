package item44;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class StandFunctionalInterfaceEx {
    public static void main(String[] args){
        UnaryOperator<String> unaryOperator = String :: toLowerCase;
        BinaryOperator<Integer> binaryOperator = Integer :: sum;
        Predicate<List> predicate = Collection :: isEmpty;
        Function<Long, List<Long>> function = Arrays :: asList;
        Supplier<LocalDateTime> supplier = LocalDateTime::now;
        Consumer<Double> consumer = System.out :: println;
    }
}
