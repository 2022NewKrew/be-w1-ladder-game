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

## 사다리 게임 2단계 구현

### 코드 리뷰 피드백

- 상수 표기법은 대문자 + underscore(_)
  - 참고: [오라클 명명법](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
    ```java
      private static final String column = "|";
      private static final String connected = "-";
      private static final String notConnected = " ";
    ``` 
- 파일 끝에는 new line을 넣을 것
  - 참고 : https://minz.dev/19
- 한 번의 스트림 체인으로 변경
  ```java
        List<List<String>> stringLadder = new ArrayList<>();

        for (List<Boolean> booleanRow : this.ladder) {
            stringLadder.add(createRowString(booleanRow));
        }
  ```

### 피어세션 및 자체 피드백

- 2차원 배열을 ArrayList, Generic 만으로 구현하면 복잡
  ```java
    private final List<List<Boolean>> ladder;
  ```
  
## 사다리 게임 3단계 구현

### 코드 리뷰 피드백

- 길이 제한이 변경될 경우에는 생성자에서 길이 제한 값을 받아서 상수 설정

### 피어세션 및 자체 피드백

- `Line`의 `createRowString()`과 `toString()`을 통합할 수 있음
- 길이 제한이 변경될 경우 사다리 줄과 공백을 나타내는 문자열도 변경 필요

## 사다리 게임 4단계 구현

### 코드 리뷰 피드백

- 모든 파일의 EOF에 NL 삽입
- 루프에서 `repeat()` 여러 번 호출하지 않도록 변경
- `LabelListTest`에서 5자보다 작은 입력을 받았을 때 5자로 출력하는 테스트 추가
- `StringLineGenerator`의 `toString()` 파라미터 변경
- `PointGenerator`의 `addPoint()` 메소드명 `appendPoint()` 로 변경
- 입력 제한 초과 메시지 출력 채널 변경

### 피어세션 및 자체 피드백

- 