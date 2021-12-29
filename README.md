# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

## step1
### 기능 요구사항
- 간단한 사다리 게임을 구현한다.
- n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- 사다리가 있으면 -를 표시하고 없으면 " " (공백문자)를 표시한다. 양옆에는 |로 세로를 표시한다.
- 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
  
### 프로그래밍 요구사항
- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
  
### 구현 내용
다음과 같은 두 개의 클래스로 기능 구현
- Ladder Class
  - generateLadder()
    - 사다리 생성 / Main.startGame 에서 호출
  - printLadder()
    - 사다리 출력 / Main.startGame 에서 호출
  - randomChar()
    - 랜덤 int 생성 후 char 반환 / generateLadder 에서 호출
  - isValidate(int players, int height)
    - 입력값에 대한 유효성 검사 수행 / generateLadder 에서 호출
    
- Main Class
  - startGame()
    - init, input values, generate & print ladder 역할 수행 / main 에서 호출
  - inputInt(String msg)
    - 입출력 담당 / startGame 에서 호출
  
  
## step2
### 기능 요구사항
- 1단계와 동일
  
### 프로그래밍 요구사항
- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- 메서드가 한 가지 일만 하도록 최대한 작게 만들어라.
- 들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 구현 순서를 고려하면서 프로그래밍한다.
- naming convention을 지키면서 프로그래밍한다.
  
### 구현 내용
step1 에서 구현한 코드 리팩토링 수행
- Ladder -> Ladder 와 Line 클래스로 분리
- GameController 클래스 생성, Main 클래스의 대부분의 메서드 GameController 로 이전
- 2차원 배열 -> 2차원 ArrayList 로 변경

Line Class
- 사다리 게임에서 하나의 층을 담당
- 실질적으로 랜덤 사다리 요소를 만들고 출력하는 기능 수행
  
Ladder Class
- Line Class 로 이루어진 ArrayList 를 관리하고 Line 의 메서드를 호출하는 역할 수행
  
GameController Class
- 게임 시작부터 종료까지 일련의 과정을 컨트롤하는 역할 수행
- Ladder 인스턴스를 생성하여 사다리 생성, 출력 메서드 호출
- 입력 및 유효성 검사 수행
- 추후 게임 결과를 확인하는 메서드 추가할 예정
  
Main Class
- GameController 인스턴스를 생성하여 게임 시작
  
