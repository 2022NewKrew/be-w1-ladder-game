# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

<br>

-----

## step1.

<br>

### 기능

- 간단한 사다리 게임 구현한다.
- `n`명의 사람과 `m`개의 사다리 개수를 입력할 수 있어야 한다.
- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- 사다리가 있으면 `-`를 표시하고, 없으면 ` `(공백문자)를 표시한다. 양 옆에는 `|`로 세로를 표시한다.
- 사다리 상태를 화면에 출력한다. 어느 시점에 출력한 것인지에 대한 제약은 없다.

<br>

### 프로그래밍 조건

- **메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.**
- 메서드가 한 가지 일만 하도록 최대한 작게 만든다.

<br>

### 구현

- ArrayList 활용
- 사다리를 생성하는 객체 `ladder.domain.Ladder`를 분리

<br>

----

## step 2.

<br>

### 프로그래밍 요구사항

- 들여쓰기 depth를 2단계에서 1단계로 줄인다.
- else를 사용하지 않는다.
- 구현 순서를 고려하면서 프로그래밍한다.
- naming convention을 지키면서 프로그래밍한다.

<br>

### 구현 & 피드백 반영

- naming convention 적용
  - ladder를 출력하는 함수 `print`를 `printLadder`로 변경
  - 새로 생성한 메소드에도 적용
- inner class 생성
  - 각 행을 의미하는 `Line` 클래스 생성

<br>


#### Line

- 사다리에서 한 행을 의미하는 클래스
- 각 줄 사이의 상태(이어져 있는지 유무)를 반영
- 2개의 메소드 구현
  - `setLine`: 랜덤하게 각 줄을 이을지 유무 설정하여 저장
  - `printLine`: 만들어낸 한 line을 출력하는 메소드

<br>

----------

## step 3.

<br>

### 기능

- 사다리 게임에 참여하는 사람의 이름을 부여
  - 조건에서 **5글자 제한**이라고 적힌 부분을 **출력**에 한하여 적용
  - 글자를 제한하는 부분을 변수로 설정하여, 이후 제한글자를 변경 가능
- 사람 이름은 쉼표 기준으로 구분
- 이름을 추가함에 따라, 사다리의 폭이 넓어지도록 조정
- 사다리 타기가 정상적으로 동작하기 위해, 양 쪽에 사다리가 생기지 않도록 조정
- ArrayList, Generic 활용
- 다양한 input이 들어옴에 따라, 새로운 클래스 `input`을 작성하여 간소화
  - `ladder.domain.LadderInput`이라는 신규 클래스를 작성하여 모든 인풋을 하나로 작성되게 축약


<br>

-------

## Step4.

<br>

### 변경사항

- 패키지 분리
  - **ladder**
    - **domain**
      - Input
      - Ladder
      - LadderInput
      - Line
    - **view**
      - ViewLadder
    - LadderGame
- 단위테스트 추가(단계를 진행하며 더 추가 예정)
  - LineTest: 왼쪽에 연결다리가 있을 때, 오른쪽에 연결다리가 생기지 않았는지 테스트
  - ViewLadderTest: input으로 받은 내용들이 출력될 때 5글자로 나타나는지 테스트