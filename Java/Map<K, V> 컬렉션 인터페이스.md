# 📌 Map<K, V>  컬렉션 인터페이스

#### 🌟 참고
       • Map<K, V> 컬렉션은 상속 구조상 List<E>, Set<E> 와 분리돼 있다
       
       • List<E>, Set<E> 가 Collection<E>를 상속받는 반면, Map<K, V>는 별도의 인터페이스로 존재한다 
       
       • 따라서, 저장 형태와 방식이 앞의 두 컬렉션과 다르다 
  
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
- 
  
