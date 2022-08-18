# Map 컬렉션 인터페이스 - LinkedHashMap

- LinkedHashMap<K, V> 는 HashMap<K, V>의 특성에 **`입력 데이터 순서정보를 추가로 가지고 있는 컬렉션`** 이다
- 저장데이터를 출력하면, 입력 순서대로 출력된다
- HashMap<K, V> 는 key를 HashSet<E> 로 관리하지만, `LinkedHashMap<K,V>는 key를 LinkedHashSet<E>로 관리`한다
- key의 순서정보를 가지고 있기때문에, LinkedHashMap<K, V> 또한 순서정보를 가지게 된다
  
<br>

## 🔎 HashMap<K, V> 주요 메서드

- 입력 순서대로 출력 되는것을 제외하고는 HashMap<K, V> 와 사용법이 완벽히 동일하다 <br>
#### `Map<Integer, String> lhMap1 = new LinkedHashMap<>();`
