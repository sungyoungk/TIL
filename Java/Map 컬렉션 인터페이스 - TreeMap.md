# Map 컬렉션 인터페이스 - TreeMap

- Map<K, V> 의 주요 메서드 종류와 활용법은 동일하며, 정렬과 검색 관련 메서드가 추가된다
- TreeSet<E>과 매우 유사하나, 데이터가 쌍의 엔트리 형태로 저장되기 때문에, 검색/추출 관련 메서드가 포함된다

  <br>
  
## TreeMap<K, V> 주요 메서드 사용하기
  
  #### ✅ 객체 생성 및 데이터 삽입 - put()
  
```java
  public class TreeMapTest {
    public static void main(String[] args) {
        // 객체 생성 및 데이터 삽입
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for(int i = 20; i >0; i -= 2) {
            treeMap.put(i, i + "번째 데이터");
        }
        System.out.println(treeMap.toString());  // {2=2번째 데이터, 4=4번째 데이터 ...,20=20번재 데이터}
        
    }
}
```
  
<br>
  

#### ✅ 데이터 검색 - firstKey() / firstEntry() / lastKey() / lastEntry() / lowerKey() / higherKey()
  
```java
  
// 1. firstKey()
        System.out.println(treeMap.firstKey());  // 2

        //2. firstEntry()
        System.out.println(treeMap.firstEntry());  // 2=2번째 데이터

        // 3. lastKey()
        System.out.println(treeMap.lastKey());  //20

        // 4. lastEntry()
        System.out.println(treeMap.lastEntry());  // 20=20번째 데이터

        // 5. lowerKey(K key)
        System.out.println(treeMap.lowerKey(11));  // 10
        System.out.println(treeMap.lowerKey(10));  // 8

        // 6. higherKey(K key)
        System.out.println(treeMap.higherKey(11));  // 12
        System.out.println(treeMap.higherKey(10));  // 12
  
```
  
<br>
  
  
#### ✅ 데이터 꺼내기 - pollFirstentry() / pollLastEntry()
  - poll 메서드는 단순히 리턴을 하는것이 아니라, 데이터를 꺼낸다. 즉 해당 데이터는 더이상 Map 안에 없게 된다

```java
  
        // 7. pollFirstEntry
        System.out.println(treeMap.pollFirstEntry());  // 2=2번째 데이터
        System.out.println(treeMap.toString()); // {4=4번째 데이터, 6=6번째 데이터,... 20=20 번째 데이터}

        // 8. pollLastEntry()
        System.out.println(treeMap.pollLastEntry());  // 20=20번째 데이터
        System.out.println(treeMap.toString());  //  {..., 16=16번째 데이터, 18=18번째 데이터}
  
```
  
<br>
  

#### ✅ 데이터 부분집합(subMap)생성 - headMap() / tailMap()
  - (참고) subMap(6,8) : key가 6이상 10 미만의 Key값을 갖는 데이터로 Map<K, V> 객체를 구성해 리턴한다
  - 일반적으로 최소값은 포함, 최대값은 미포함인 경우가 많다(subMap()도 동일)
  
```java
  
  // 9. SortedMap<K, V> haedMap(K toKey)
        SortedMap<Integer, String> sortedMap = treeMap.headMap(8);
        System.out.println(sortedMap);                      // {4=4번째 데이터, 6=6번째 데이터} *2번째는 앞에서 빠졌으므로 없음

        // 10. NavigableMap<K, V>  hadMap( k toKey, boolean inclusive)
        NavigableMap<Integer, String> navigableMap = treeMap.headMap(8, true);
        System.out.println(navigableMap);                   // {4=4번째 데이터, 6=6번째 데이터, 8=8번째 데이터}

        // 11. SortedMap<K, V> tailMap(K toKey)
        sortedMap = treeMap.tailMap(14);
        System.out.println(sortedMap);                     // {14=14번째 데이터, 16=16번째 데이터, 18=18번째 데이터}

        // 12. NavigableMap<K, V> tailMap(K toKey, boolean inclusive)
        navigableMap = treeMap.tailMap(14, false);
        System.out.println(navigableMap);                  // {16=16번째 데이터, 18=18번째 데이터}

        // 13. SortedMap<K, V> subMap( k fromKey, K tokey)
        sortedMap = treeMap.subMap(6, 10);
        System.out.println(sortedMap);                     // {6=6번째 데이터, 8=8번째 데이터}

        // 14. NavigableMap<K, V> subMap( K fromKey, boolean inclusive, K toKey, boolean inclusive)
        navigableMap = treeMap.subMap(6, false, 10, false);
        System.out.println(navigableMap);                  // {8=8번째 데이터}
  
```
  
