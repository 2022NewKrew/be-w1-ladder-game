# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

---

# 구현 단계별 피드백

## 사다리 게임 1단계 구현

### 코드 리뷰 피드백

- 메서드 이름, 파라미터 이름을 봤을 때 역할 짐작이 어려움
  - `makeLadders(int j)`, `getLadder`, `makeLadder`
  - 메서드 이름만으로 유추할 수 있거나 주석으로 확인할 수 있도록 수정
- 사다리 세로선과 가로선을 구분하도록 수정 필요
- 변수를 받을 때는 구현체인 ArrayList를 사용하지 말고 List를 사용할 것
  ```java
  List<ArrayList<String>> ladders = makeLadders(n, h);
  ```
  
### 피어세션 및 자체 피드백

- 사다리를 재사용 가능한 객체로 만드는 것이 좋을듯
- IntelliJ와 Github 연동 시 Token 사용
- 참고: [객체 지향 생활 체조 원칙](https://hyunjungchoi.tistory.com/105)