# be-w1-ladder-game

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
* 매 커밋마다 길게 커밋메세지 남기기
* 코드 Refactoring
* 요구사항은 Refactoring 이후에 계획을 세워야 한다