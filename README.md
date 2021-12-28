# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

## 기능 요구사항

- [x] 간단한 사다리 게임을 구현한다.
- [x] n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- [x] 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- [x] 사다리가 있으면 `-` 를 표시하고 없으면 `"` (공백문자) 를 표시한다. 양 옆에는 `|` 로 세로를 표시한다.
- [x] 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.



## 프로그래밍 요구사항

- [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
- [ ] 들여쓰기(indend) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.

- [ ] else를 사용하지 마라.
- [ ] 구현 순서를 고려하면서 프로그래밍한다.
- [ ] naming convention을 지키면서 프로그래밍한다.



## 클래스 구현 순서

- 클래스를 구현할 때 다음 순서를 지켜 구현한다.

  ```java
  package 패키지명
  
  import ...
  
  class Ladder {
      //상수 및 클래스 변수
  
      //인스턴스 변수
  
      //생성자
  
      //메서드
  }
  ```

  

## Naming Convention

- 자바는 낙타 표기법(Camel Case)를 따른다.
- 클래스명은 대문자로 시작, 변수 메소드는 소문자로 시작
- 클래스 이름 예 : Rectangle, LaundryList, StudentDirectory
- 변수 이름 예 : firstName, description, mediaController
- 메소드 이름 예 : getFirstName(), cancelOrder(), isDeleted()
