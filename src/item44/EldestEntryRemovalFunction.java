package item44;

import java.util.Map;

/**
 * 함수형 인터페이스, 굳이 불필요. 표준형이 존재.
 */
@FunctionalInterface
public interface EldestEntryRemovalFunction<K,V> {
    boolean remove(Map<K,V> map, Map.Entry<K,V> eldest);
}
