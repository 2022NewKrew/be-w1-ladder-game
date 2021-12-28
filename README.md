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
- LadderGenerator Class
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
