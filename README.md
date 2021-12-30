# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

## 기능 요구사항

- [x] 간단한 사다리 게임을 구현한다.

- [x] n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.

- [x] 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.

- [x] 사다리가 있으면 `-` 를 표시하고 없으면 `"` (공백문자) 를 표시한다. 양 옆에는 `|` 로 세로를 표시한다.

- [x] 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.

- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.

- [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.

- [x] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.

  - [x] `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

    


## 프로그래밍 요구사항

- [x] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- [x] 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
- [x] 들여쓰기(indend) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
- [x] else를 사용하지 마라.
- [x] 구현 순서를 고려하면서 프로그래밍한다.
- [x] naming convention을 지키면서 프로그래밍한다.
- [x] 배열 대신 ArrayList와 Generic을 활용해 구현한다.
- [ ] **로직을 구현하는 코드에 단위 테스트가 존재해야 한다. 단, UI 처리 로직(System.in, System.out)은 테스트에서 제외한다.**
- [ ] 각각의 역할에 맞도록 **패키지를 분리하고 접근 제어자를 적절히 사용**하도록 리팩토링한다.



## 코드 리뷰 피드백

- [x] Input, Ouput 클래스에 private 생성자 만들기
- [ ] 입력단 예외처리
- [x] 상수를 변수로 바꾸기 & 사용되지 않는 인스턴스 변수 선언하지 않기
- [x] String[] 대신 List 사용하기
- [ ] Ladder 객체의 Player에 대한 책임 분리하기
- [ ] Line 클래스의 Random 변수 한번만 생성되게 하기
- [ ] Line 클래스의 setConnection 로직 직관적으로 고쳐보기
- [ ] README에 구현 내용도 설명하기
- [ ] Ouput 클래스의 로직 줄이기
