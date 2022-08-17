# Hashtable<K, V>
- Hashtable<K, V> 는 HashMap<K, V> 와 비교해 멀티 쓰레드에도 안전하다는 특징이 있다
- 이외에는 HashMaP<K, V>과 완전히 동일한 특징을 가진다
- 즉, 동일한 key 값의 중복을 허용하지 않으며, 입출력 순서도 일치하지 않을 수 있다
- 주요 메서드 또한 사용 방법 및 문법이 같다

```java

Map<Integer, String> hTable1 = new Hashtable<>();

```
