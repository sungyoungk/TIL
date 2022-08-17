# 📌 Map<K, V>  컬렉션 인터페이스

#### 🌟 참고
       • Map<K, V> 컬렉션은 상속 구조상 List<E>, Set<E> 와 분리돼 있다
       
       • List<E>, Set<E> 가 Collection<E>를 상속받는 반면, Map<K, V>는 별도의 인터페이스로 존재한다 
       
       • 따라서, 저장 형태와 방식이 앞의 두 컬렉션과 다르다 
       
![스크린샷 2022-08-17 오전 11 30 14](https://user-images.githubusercontent.com/101084642/185021484-48481708-59a3-419b-b186-2933ed839143.png)

  
  <br>
  
## 🔎 Map<K, V> 컬렉션의 특징
  
#### 1. Key 와 Value 를 한 쌍으로 저장한다
- 한 쌍의 데이터를 **`엔트리(entry)`** 라고 하며, **`Map.entry`** 타입으로 정의된다  <br>
- 즉 Map<K, V> 은 엔트리 단위로 입력받는다
  
#### 2. Key는 중복 저장 불가, Value는 중복 가능
- Value 값이 같더라도 Key 로 구분 가능하므로, Value는 중복 허용하나, Key는 중복 불가이다

<br>

##  Map<K, V> 컬렉션의 주요 메서드

### 💡 데이터 추가
- **`put(K key, V value)`** : 입력 매개변수의 key, vlaue 를 Map 객체에 추가
- **`putAll(Map<? extends K, ? extends V> m)`** : 입력 매개변수의 Map 객체를 통째로 추가

### 💡 데이터 변경
- **`replace(K key, V value`** : Key에 해당하는 값을 Value 값으로 변경(old 값 리턴). 단, 해당 key 가 없으면 null 리턴
-  **`replace(K key, V oldValue, V newValue)`** : 해당 엔트리에서 oldValue를 newValue로 변경한다. 엔트리가 없으면 false 리턴

### 💡 데이터 정보 추출
- **`get(Object Key`** : 매개변수의 Key 값에 해당하는 oldValue를 리턴
- **`containsKey(Objet key)`** : 매개변수의 Key 값이 포함되어 있는지 여부
- **`containsValue(Object value)`** : 매개변수의 Value 값이 포함돼 있는지 여부
- **`keySet()`** : Map 데이터 중 Ket 만 뽑아 Set<E> 객체로 리턴
- **`entryset()`** : Map의 각 엔트리들을 Set<E> 객체로 담아 리턴
- **`size()`** : Map에 포함된 엔트리의 개수

### 💡 데이터 삭제
- **`remove(Object key)`** : 입력매개변수의 key를 갖는 엔트리 삭제(단, 해당 key가 없으면 아무런 동작을 하지 않음)
- **`remove(Object key, Object value)`** : 입력 매개변수의 (key, value) 를 갖는 엔트리 삭제( 단, 해당 엔트리가 없으면 아무런 동작도 하지 않음)
- **`clear()`** : Map 객채 내의 모든 데이터 삭제
       
<br>
       
       
## HashMap<K, V>
- Map<K, V> 의 대표적인 구현 클래스로, Key 값의 중복으르 허용하지 않는다
- Key 값의 중복 허용 매커니즘은 HashSet<E>과 완전히 동일하다
- 즉, hashCode() 값이 같고, equals() 메서드가 true 이면 같은 객체로 인식한다
- Key 값을 HashSet<E>로 구현한 Map<K, V> 객체다
- HashMap<K, V> 은 Key 값을 HashSet<E> 로 구현한 Map<K, V> 객체다(입출력 순서는 보장되지 않는다)
       
<br>
       
## HashMap<K, V> 주요 메서드
       
`데이터 추가`
```java
       
   
       
```

