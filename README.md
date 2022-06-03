# ModernJava
- Modern Java Lambda/StreamAPI 연습하기

## Lambda
- 요약
![FunctionalInterface](https://user-images.githubusercontent.com/42602972/171814400-8e19413e-4b72-4165-bdad-4ea20ca8f38e.png)
- 정리
  - [참조](https://github.com/heom/ModernJava/blob/master/src/Study/Lambda.java)
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
- StreamAPI
  - Java는 객체지향 언어이기 때문에 기본적으로 함수형 프로그래밍이 불가능
  - 다만, JDK8부터 Stream API와 람다식, 함수형 인터페이스 등을 지원하면서 Java를 이용해 함수형 인터페이스 사용가능
  - 특징
    - 원본의 데이터를 변경하지 않는다.
    - 일회용이다.
    - 내부 반복으로 작업을 처리한다.
    