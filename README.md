# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

- [PR가이드](https://github.com/code-squad/codesquad-docs/tree/master/codereview-auto)

# 기능목록
## 1단계
### 요구사항
- [x] n개의 사람을 입력받는다.
    - [x] 0 을 입력받으면 에러처리를 한다.
- [x] m개의 사다리 개수를 입력받는다.
    - [x] 0을 입력받으면 에러처리를 한다.
- [x] 사다리 라인은 랜덤한 값에따라 있거나 없을 수 있다.
    - [x] 사다리가 있다면 - 표시를 한다.
    - [x] 사다리가 없다면 " " 처리를 한다.
    - [x] 양옆에는 |로 표기한다.
- [x] 사다리의 상태를 화면에 출력한다.

### 피드백 반영
- [x] Ladder 클래스의 2차원 배열을 List로 변경한다.
  - [참고자료] https://icarus8050.tistory.com/83
- [x] 외부로 내부 인자값을 내보낼 때 unmodifiableList를 사용한다.
  - [참고자료] https://soft.plusblog.co.kr/71
- [x] Ladder 클래스를 여러 개로 쪼개본다.
- [x] 매직넘버를 상수로 선언한다.
  - [참고자료] https://javabom.tistory.com/28
- [ ] unit 테스트를 공부한다.
  - [참고자료] https://scshim.tistory.com/175
- [x] RandomUtil 생성자의 접근제한자를 private로 변경한다.


## 2단계
- [x]  메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - [x] 메서드가 한 가지 일만 하도록 최대한 작게 만든다.
- [x]  들여쓰기(indent) depth를 2단계에서 1단계로 줄인다.
    - if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
- [x]  else를 사용하지 않는다.
- [x]  구현 순서를 고려하면서 프로그래밍한다.
    - 클래스 구현 순서
      1. 상수 및 클래스 변수
      2. 인스턴스 변수
      3. 생성자
      4. 메서
- [x]  naming convention을 지키면서 프로그래밍한다.
