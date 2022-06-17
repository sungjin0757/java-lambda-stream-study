package item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamIteratorEx {
    public static void main(String[] args){

        /**
         * 컴파일 오류
         */
//        for(ProcessHandle ph : ProcessHandle.allProcesses() :: iterator) {
//
//        }

        /**
         * 스트림을 반복하기 위한 '끔찍한' 우회 방법
         */
        for(ProcessHandle ph : (Iterable<? extends ProcessHandle>) ProcessHandle
                .allProcesses() :: iterator){

        }

        /**
         * 어댑터를 활용한 for-each
         */
        for(ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())){

        }
    }

    /**
     * Stream<E> 를 Iterable<E>로 중개해주는 어댑터
     */
    public static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }

    /**
     * Iterable<E> 를 중개해주는 어댑터
     */
    public static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
