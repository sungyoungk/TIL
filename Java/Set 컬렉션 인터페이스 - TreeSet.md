# Set 컬렉션 인터페이스 - TreeSet 구현 클래스
  - `Set<E>`의 기능에 크기에 따른 정렬 및 검색 기능이 추가된 컬랙션이다
  - `HashSet<E>`는 입력 순서가 보장되지 않고, `LinkedHashSet<E>` 은 입력순서가 보장된다
  - **`TreeSet<E>`은 입력순서와 상관없이 크기순으로 출력한다**
  - `TreeSet<E>` 은 다른 클래스와 달리 `NavigableSet<E>` 와 `SortedSet<E>` 를 부모 인터페이스로 두고있다
  - `Set<E>` 으로 선언하면 `SortedSet<E>`, `NavigableSet<E>` 기능을 사용할 수 없으므로 `TreeSet<E>` 으로 선언해야 한다

      <img width="148" alt="스크린샷 2022-08-16 오후 6 29 59" src="https://user-images.githubusercontent.com/101084642/184846830-5caecb46-e88f-4a58-862a-1538c9760e49.png">

```java
Set<String> treeSet = new TreeSet<>();
treeSet.first()                          // 삐빅!! 애러발생, Set<E> 메서드만 사용가능!

TreeSet<E> treeSet = new TreeSet<>();
treeSet.first()                          // (o) 
```

## 🔎 TreeSet<E> 의 주요 매서드
  
  #### 📌 데이터 검색
  
  - **`first()`** : Set 원소 중 가장 작은 원소값 리턴
  - **`last()`** : Set 원소 중 가장 큰 원소값 리턴
  - **`lower(E element)`** : 매개변수로 입력된 원소보다 작은 원소 중 가장 큰 수
  - **`higher(E element)`** : 매개변수로 입력된 원소보다 큰 원소 중 가장 작은 수
  - **`floor(E element)`** : 매개변수로 입력된 원소보다 같거나 작은 가장 큰 수
  - **`celling(E element)`** : 매개변수로 입력된 원소보다 같거나 큰 가장 작은 수
  
  #### 📌 데이터 꺼내기
  
  - **`pollFirst()`** : Set 원소 중 가장 작은 원소값을 꺼내 리턴 (데이터가 꺼내어져 사라짐)
  - **`pollLast()`** : Set 원소 중 가장 큰 원소값을 꺼내 리턴 (데이터가 꺼내어져 사라짐) 
  
  #### 📌 데이터 부분 집합 생성
  
  - **`headSet(E toElement)`** : toElement 미만의 모든 원소로 구성된 Set<E>을 리턴(toElement미포함)
  - **`headSet(E toElement, boolean inclusive)`** : toElement 미만/이하인 모든 완소로 구성된 Set을 리턴(inclusive = true 이면 toElement 포함, false 이면 미포함)
  - **`tailSet(E fromElement)`** : toElement 이상인 모든 원소로 구성된 Set<E> 을 리턴(fromElement 포함)
  - **`tailSet(E fromElement, boolean inclusive)`** : fromElement 초과/이상인 모든 원소로 구성된 Set<E> 리턴(inclusive = true 이면 fromElement 포함, false 이면 미포함
  - **`subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`** : fromElement 초과/이상인 toElement 미만/이하인 원소들로 이루어진 Set<E> 리턴(inclusive = true 이면 toElement 포함, false 이면 미포함)
  - **`descendingSet()`** : 내림차순의 의미가 아니라 현재 정렬 리준을 반대로 변환
  
  <br>
  
  #### ✅ 데이터 꺼내기와 출력
  ```java
  
  public class TreeSetAdd {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 50; i > 0; i -=2) {
            treeSet.add(i);
        }
        System.out.println(treeSet.toString());
    }
  
  ```
  
  #### ✅ 데이터 검색
  ```java
  
  // 1. first
        System.out.println(treeSet.first());       // -> 2
        
        // 2. last
        System.out.println(treeSet.last());        // -> 50
        
        // 3. lower(E element)
        System.out.println(treeSet.lower(26));    // -> 24
        
        // 4. higher
        System.out.println(treeSet.higher(26));   // -> 28
        
        // 5. floor(E element)
        System.out.println(treeSet.floor(24));     // -> 24
        System.out.println(treeSet.floor(25));    // -> 24
        
        // 6. ceiling(E element)
        System.out.println(treeSet.ceiling(25));  // -> 26
        System.out.println(treeSet.ceiling(26));  // -> 26
  
  ```

  
