package item47;

import java.util.*;

public class PowerSet {
    public static final <E> Collection<Set<E>> of(Set<E> s){
        List<E> src = new ArrayList<>(s);
        if(src.size() > 30){
            throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30개). : "+s);
        }
        return new AbstractList<Set<E>>() {
            @Override
            public Set<E> get(int index) {
                Set<E> res = new HashSet<>();
                for(int i = 0; index!=0; i++, index >>= 1){
                    if((index & 1) == 1){
                        res.add(src.get(i));
                    }
                }
                return res;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }
        };
    }

}
