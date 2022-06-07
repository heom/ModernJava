# ModernJava
- Modern Java Lambda/StreamAPI 연습하기

## Lambda
- 요약
  - ![FunctionalInterface](https://user-images.githubusercontent.com/42602972/171814400-8e19413e-4b72-4165-bdad-4ea20ca8f38e.png)
------------
- 참조
  - [src/study/Lambda.java](https://github.com/heom/ModernJava/blob/master/src/study/Lambda.java)

## StreamAPI
- Programming Paradigm
  - 명령형 프로그래밍
    - 무엇(What)을 할 것인지 나타내기보다 어떻게(How) 할 건지를 설명하는 방식
    - 종류
      - 절차지향 프로그래밍: 수행되어야 할 순차적인 처리 과정을 포함하는 방식 (C, C++)
      - 객체지향 프로그래밍: 객체들의 집합으로 프로그램의 상호작용을 표현 (C++, Java, C#)
  - 선언형 프로그래밍
    - 어떻게 할건지(How)를 나타내기보다 무엇(What)을 할 건지를 설명하는 방식
    - 종류
      - 함수형 프로그래밍: 순수 함수를 조합하고 소프트웨어를 만드는 방식 (클로저, 하스켈, 리스프)
------------
- Java
  - Java는 객체지향 언어이기 때문에 기본적으로 함수형 프로그래밍이 불가능
  - 다만, JDK8부터 Stream API와 람다식, 함수형 인터페이스 등을 지원하면서 Java를 이용해 함수형 인터페이스 사용가능
------------ 
- 특징
  - 원본의 데이터를 변경하지 않는다.
  - 일회용이다.
  - 내부 반복으로 작업을 처리한다.
------------
- 연산종류
  - 생성
    - Stream 객체를 생성하는 단계
    - **[중요]** Stream은 재사용이 불가능하므로, 닫히면 다시 생성해주어야 한다.
  - 가공
    - 원본의 데이터를 별도의 데이터로 가공하기 위한 중간 연산
    - 연산 결과를 Stream으로 다시 반환하기 때문에 연속해서 중간 연산을 이어갈 수 있다.
  - 출력
    - 가공된 데이터로부터 원하는 결과를 만들기 위한 최종 연산
    - **[중요]** Stream의 요소들을 소모하면서 연산이 수행되기 때문에 1번만 처리가능하다.
------------
- Stream 생성
  - Collection의 Stream 생성
    - Collection 인터페이스에는 stream()이 정의되어 있기 때문에, Collection 인터페이스를 구현한 객체들(List, Set 등)은 모두 이 메소드를 이용해 Stream을 생성
  - 배열의 Stream 생성
    - 배열의 원소들을 소스로하는 Stream을 생성하기 위해서는 Stream의 of 메소드 또는 Arrays의 stream 메소드를 사용
  - 원시 Stream 생성
    -  int와 long 그리고 double과 같은 원시 자료형들을 사용하기 위한 특수한 종류의 Stream(IntStream, LongStream, DoubleStream) 들도 사용할 수 있으며, Intstream같은 경우 range()함수를 사용하여 기존의 for문을 대체
------------
- Stream 가공(중간연산)
  - 가공하기 단계의 파라미터로는 앞서 설명하였던 함수형 인터페이스들이 사용되며, 여러 개의 중간연산이 연결되도록 반환값으로 Stream을 반환
  - 종류
    - 필터링 - Filter
      - Filter는 Stream에서 조건에 맞는 데이터만을 정제하여 더 작은 컬렉션을 만들어내는 연산
      - Java에서는 filter 함수의 인자로 함수형 인터페이스 Predicate를 받고 있기 때문에, boolean을 반환하는 람다식을 작성하여 filter 함수를 구현
    - 데이터 변환 - Map
      - Map은 기존의 Stream 요소들을 변환하여 새로운 Stream을 형성하는 연산
      - 장된 값을 특정한 형태로 변환하는데 주로 사용되며, Java에서는 map 함수의 인자로 함수형 인터페이스 function을 받음
    - 정렬 - Sorted
      - Stream의 요소들을 정렬하기 위해서는 sorted를 사용해야 하며, 파라미터로 Comparator를 넘길 수도 있음
      - Comparator 인자 없이 호출할 경우에는 오름차순으로 정렬이 되며, 내림차순으로 정렬하기 위해서는 Comparator의 reverseOrder를 이용
    - 중복 제거 - Distinct
      - Stream의 요소들에 중복된 데이터가 존재하는 경우, 중복을 제거하기 위해 distinct를 사용
      - distinct는 중복된 데이터를 검사하기 위해 Object의 equals() 메소드를 사용
    - 특정 연산 수행 - Peek
      - Stream의 요소들을 대상으로 Stream에 영향을 주지 않고 특정 연산을 수행하기 위한 peek 함수가 존재
      - peek 함수는 Stream의 각각의 요소들에 대해 특정 작업을 수행할 뿐 결과에 영향을 주지 않음
      - peek 함수는 파라미터로 함수형 인터페이스 Consumer를 인자로 받음
    - 원시 Stream <-> Stream
      - 작업을 하다 보면 일반적인 Stream 객체를 원시 Stream으로 바꾸거나 그 반대로 하는 작업이 필요한 경우가 있음
      - 일반적인 Stream 객체는 mapToInt(), mapToLong(), mapToDouble()이라는 특수한 Mapping 연산을 지원하고 있으며,   
        그 반대로 원시객체는 mapToObject를 통해 일반적인 Stream 객체로 바꿀 수 있음
------------
- Stream 출력(최종 연산)
  - 최댓값/최솟값/총합/평균/갯수- Max/Min/Sum/Average/Count
    - min이나 max 또는 average는 Stream이 비어있는 경우에 값을 특정할 수 없다. 그렇기 때문에 다음과 같이 Optional로 값 반환
    - sum 메소드와 count 메소드에대해 Optional이 아닌 원시 값을 반환하도록 구현
  - 데이터 수집 - collect~~~~
    - Stream의 요소들을 List나 Set, Map, 등 다른 종류의 결과로 수집하고 싶은 경우에는 collect 함수를 이용
    - collect 함수는 어떻게 Stream의 요소들을 수집할 것인가를 정의한 Collector 타입을 인자로 받아서 처리
    - 일반적으로 List로 Stream의 요소들을 수집하는 경우가 많은데, 이렇듯 자주 사용하는 작업은 Collectors 객체에서 static 메소드로 제공
    - 원하는 것이 없는 경우에는 Collector 인터페이스를 직접 구현하여 사용
    - Collectors 종류
      - Collectors.toList()
        - Stream에서 작업한 결과를 List로 반환
      - Collectors.joining()
        - Stream에서 작업한 결과를 1개의 String으로 이어붙이기를 원하는 경우
        - 총 3개의 인자를 받을 수 있는데, delimiter / prefix / suffix
      - Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
        - Stream에서 작업한 결과의 평균값이나 총합 등을 구하기 위해서는 Collectors.averagingInt()와 Collectors.summingInt()를 이용
        - 만약 1개의 Stream으로부터 갯수, 합계, 평균, 최댓값, 최솟값을 한번에 얻고 싶은 경우, Collectors.summarizingInt()를 이용
          - 갯수: getCount()
          - 합계: getSum()
          - 평균: getAverage()
          - 최소: getMin()
          - 최대: getMax()
      - Collectors.groupingBy()
        - Stream에서 작업한 결과를 특정 그룹으로 묶기를 원할 때 사용
        - 결과는 Map으로 반환 받으며, 매개변수로 함수형 인터페이스 Function을 필요
      - Collectors.partitioningBy()
        - Collectors.groupingBy()와 달리, 함수형 인터페이스 Predicate를 받아 Boolean을 Key값으로 partitioning
  - 조건 검사 - Match
    - Stream의 요소들이 특정한 조건을 충족하는지 검사하고 싶은 경우에는 match 함수를 이용
    - match 함수는 함수형 인터페이스 Predicate를 받아서 해당 조건을 만족하는지 검사를 하게 되고, 검사 결과를 boolean으로 반환
    - 종류
      - anyMatch: 1개의 요소라도 해당 조건을 만족하는가
      - allMatch: 모든 요소가 해당 조건을 만족하는가
      - nonMatch: 모든 요소가 해당 조건을 만족하지 않는가
  - 특정 연산 수행 - forEach
    - Stream의 요소들을 대상으로 어떤 특정한 연산을 수행하고 싶은 경우에는 forEach 함수를 이용
    - peek()는 중간 연산으로써 실제 요소들에 영향을 주지 않은 채로 작업을 진행하고 Stream을 반환,  
      하지만 forEach()는 최종 연산으로써 실제 요소들에 영향을 줄 수 있으며, 반환값이 존재하지 않음
        
        
          
                      

      
        
        
------------      
- 참조
  - [src/study/StreamAPI.java](https://github.com/heom/ModernJava/blob/master/src/study/StreamAPI.java)
