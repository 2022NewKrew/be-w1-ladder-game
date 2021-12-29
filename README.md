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

### TODO
* gradle을 기존 코드 구조에서 적용하기 어렵다.
  * 2일차는 gradle 프로젝트를 만든 후 기존 코드를 옮기는 방식으로 구조 리팩토링 진행
* 작업별로 commit 해보기??
  * 왜 안했었을까요 ㅠㅠ