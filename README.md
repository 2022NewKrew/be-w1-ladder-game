be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

#1일차
### 요구사항
* 간단한 사다리 게임을 구현한다.
* n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
* 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
* 사다리가 있으면 -를 표시하고 없으면 " " (공백문자)를 표시한다. 양옆에는 |로 세로를 표시한다.
* 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
* 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* 메서드가 한 가지 일만 하도록 최대한 작게 만들자

### 피드백 수정사항
* 클래스 split
* 특수 문자나 값들을 상수화
* 랜덤 생성 규칙 변경
  * 개수를 정해두는 방식에서 각각의 가로바를 확률에 따라 생성하는 방식으로
* 주석으로 처리되었던 것을 삭제
* Auto Formatting 적용

---
#2일차
### 요구사항
* 1일차 요구사항은 그대로
* 들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다.
  * if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* 구현 순서를 고려하면서 프로그래밍한다.
* naming convention을 지키면서 프로그래밍한다

### DONE
* 구현 순서를 고려하면서 프로그래밍
* indent depth 조정

---
#3일차
### 전날 피드백
* 클래스의 단일책임원칙을 바탕으로 리팩토링할 것
* static 키워드 다시 확인
* 주석에 return 값 다시 확인
* 매직넘버 상수화
* 인자는 최대한 줄이기!

### 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
* 배열 대신 ArrayList와 Generic을 활용해 구현한다.

### TODO


### DONE
* 이름 부여 - NameLine 객체 추가
* 객체 내부의 배열을 ArrayList로 변화
* HBL 객체 내의 상수 변경 및 출력 구문 수정
* 가로 막대가 연속으로 위치하지 않게 하는 조건 추가 

---
4일차

### 요구사항
* 로직을 구현하는 코드에 단위 테스트가 존재해야 한다.
  * 단, UI 처리 로직(System.in, System.out)은 테스트에서 제외한다.
* 각각의 역할에 맞도록 패키지를 분리하고 접근 제어자를 적절히 사용하도록 리팩토링한다.

### 전날 피드백
* 파일 위치를 변경하였지만 이전 위치에서 지워지지 않은 파일들 존재
* 코드 에러 존재 ==> 오늘 것 하면서 이미 해결되었음
* NPE 해결을 위한 트릭 제안
* private 붙여지지 않은 멤버 변수 존재
* 배열 객체가 인자로 한번만 쓰이는 경우 따로 지역변수로 빼지 말 것
* Manager 객체에서 DTO 객체를 만들지 말것??
* 여러 String을 더할거라면 String + String 대신 StringBuilder 사용
* 변수 및 클래스 이름 조정
* 리스트를 getter 함수로 꺼내는 것은 위험.
  * 불변 객체로 만들거나, 방어적 복사본을 외부로 보낸다.
* 가로줄 출력부분의 길이가 바뀔 수 있으니 repeat과 상수를 이용하자.
* 입력 검사 추가
* 인스턴스가 만들어지는 것을 막기 위해 private 생성자 만들기
  * 안그러면 기본 생성자가 생긴다.
* OutputView 객체의 부담을 줄여주자.
* Ladder가 nameLine을 책임져야 하는가?
  * 그럼 nameLine을 어디다 두지???
  * 상위에 LadderGame 객체를 만들어야하나

### Done
* package 이름 변경
* 단위 테스트 추가
* 제거 하지 않은 파일들 제거
* Minor Refactoring Issue
  * 멤버 변수에 private 키워드 추가
  * 변수 및 클래스 이름 조정
  * 일회성 배열 객체를 지역변수에서 인자로 변경
  * NPE 트릭
  * private 생성자 만들기 
* 출력 구문 수정
  * 어떠한 값이 출력될 것인가에 대한 로직을 각각의 도메인에서 구현하도록 변경
  * OutputView 내에서는 단순 출력만 할 수 있도록
  * StringBuilder 사용
  * HorizBarLine 내의 상수들을 수정이 용이하도록 변경
* 입력
  * 입력값으로 들어온 이름의 길이가 0인 경우 다시 입력받도록 수정
  * 입력값으로 들어온 사다리의 높이가 자연수가 아닌경우 다시 입력받도록 수정
  * DTO 객체 생성의 책임을 일단은 main함수로 변경
* 코드의 수정에 맞춰 테스트 코드를 수정
  
### TODO
* 객체 리팩토링 ==> 다음번에...
  * Ladder 객체를 두개로 나눈다?
  * HorizBarLine과 NameLine의 상위객체를 만들까?
