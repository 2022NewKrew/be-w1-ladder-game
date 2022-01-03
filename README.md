# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

---
## 1단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/ladder-game-step-1))
### 기능 요구사항
- 간단한 사다리 게임을 구현한다.
- n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- 사다리가 있으면 `-`를 표시하고 없으면 `" "` (공백문자)를 표시한다. 양옆에는 `|`로 세로를 표시한다.
- 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
### 프로그래밍 요구사항
- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
### 상세 구현사항
- `|`, `-`, `" "` (공백문자)를 상수로 선언하여 활용
- 인원 수 `n` 및 사다리 개수 `m`, 2차원 배열 `ladder` 멤버 변수 선언
- `Math.random`을 활용하여 라인을 그릴지에 대한 여부 결정
- 입력 및 초기화 → 사다리 완성 → 사다리 출력 순으로 구현
---
## 2단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/ladder-game-step-2))
### 기능 요구사항
- 1단계와 같다.
### 프로그래밍 요구사항
- **들여쓰기(indent) depth를 2단계에서 1단계로 줄여라**.
    - depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
- **else를 사용하지 마라.**
- **구현 순서를 고려하면서 프로그래밍한다.**
- **naming convention을 지키면서 프로그래밍한다.**
- 나머지는 이전 단계와 동일하게 적용한다.
### 상세 구현사항
1. 1단계에서의 피드백 반영
   - 사다리 전체 모양을 2차원 배열로 저장하는 대신 실제 라인을 그릴 부분만 데이터로 리펙토링하여 저장
     - 사다리의 각 층을 Line 클래스로 표현
     - Line에서의 각 지점들을 `ArrayList<Boolean>` 형태로 저장
   - 단순히 출력하는 부분에서 `StringBuilder`를 사용한 것을 `System.out.println` 또는 `System.out.print`로 변경
     - 기존에 Ladder.java의 출력을 담당했던 메소드인 `printLadder`를 view/LadderView.java로 옮긴 후 바로 출력하도록 변경
   - 기존에 사용하던 2차원 배열 `ladder`를 Ladder라는 이름의 일급 컬랙션으로 정의
     - Ladder 클래스를 정의하여 멤버 변수를 ArrayList만 가지는 일급 컬랙션으로 활용
2. 세부 변경사항
    - 패키지를 분리하여 model에는 사다리 데이터 자체를 저장할 Ladder, Line 클래스, view에는 그려주는 기능을 담당하는 LadderView 클래스 정의
    - Line 클래스에서는 `ArrayList<Boolean>` 형태의 데이터를 통해 사다리의 한 층을 표현
      - 각각의 위치에 선을 그릴지에 대한 유무 저장
    - Ladder 클래스에서는 `ArrayList<Line>` 형태의 데이터를 통해 사다리를 표현
    - Main 클래스에는 `main` 메소드만 존재하며 인원 수 및 사다리 높이를 입력받음
    - LadderView 클래스 내에서는 `main` 메소드에서 입력받은 정보와 Ladder 클래스를 통해 사다리 생성 및 출력 담당
      - indent 문제를 해결하기 위해 출력 부분의 2중 `for`문을 메소드로 분리
---
## 3단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84-3%EB%8B%A8%EA%B3%84-%EA%B5%AC%ED%98%84))
### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다. 
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
### 프로그래밍 요구사항
- **배열 대신 ArrayList와 Generic을 활용해 구현한다.**
- 나머지는 이전 단계와 동일하게 적용한다.
### 상세 구현사항
- 패키지를 좀 더 상세하게 분리 및 기능 추가
  - config: 설정과 관련된 내용들
    - Constants
      - 현재 사용되고 있는 상수들을 한 곳에 모아놓은 클래스
  - domain: 핵심 로직들 (입력, 조작, 유효성 검사)
    - GetInfos
      - 인원 수 및 사다리 높이를 입력받는 메소드들이 포함됨
      - 입력받을 때 요구사항에 맞게 입력됐는지 Validator 클래스를 통해 확인
    - ManipulateInfos
      - 입력된 이름 앞 뒤 공백을 없애거나 출력하기 위한 형식으로 바꿔주는 메소드들이 포함됨
      - 이름 출력 시 변환 방법
        ![image](https://user-images.githubusercontent.com/31435103/147546431-830733dc-a370-48d0-acf8-68b80ced661a.png)
    - Validator
      - 입력된 값이 올바른지, 각 라인을 그릴 수 있는지 확인해주는 메소드들이 포함됨
  - model: DTO들을 담음
    - Ladder
      - 기존 Ladder 클래스와 동일
    - Line
      - 기존 Line 클래스에 각 지점에서 라인을 그릴 때의 유효성 검사 기능 추가
  - view: 실제 UI를 담당
    - LadderView
      - 기존 LadderView 클래스애서 출력 부분만을 남김, 내용을 확인하는 부분은 Validator 클래스로 이동
      - 사다리를 입력받은 이름들과 함께 출력
- 기존 main 함수에서 입력 받는 부분을 GetInfos 클래스로 이동
---
## 3단계 추가 구현
### 피드백 반영
- 멤버 변수에 구현체 클래스 대신 인터페이스를 이용
    - `ArrayList` → `List`
- 클래스에서 getter 사용 → 외부에서 사용할 때 실행되는 로직을 클래스 안으로 이동
    - Ladder, Line과 관련된 로직을 클래스 내부로 이동
- 데이터와 뷰 분리 관점에서 뷰의 생성자에 데이터를 넘겨받는 것으로 수정
    - LadderView 생성자에 Ladder를 넘겨주도록 수정
- 메소드 명이 모호한 것들 수정
    - check가 들어간 메소드 명을 변경, 삭제
- 이름을 확인하는 메소드에서 Stream API의 noneMatch를 이용하여 가독성 증가
    - 이름 확인 방식을 완전히 변경
- `null`을 리턴하는 방식은 좋지 않으므로 size를 통한 유효성 검사가 더 좋을 것
    - `null`을 리턴하는 대신 다른 방식으로 검증하여 예외 처리를 하도록 변경
- 전체적으로 설계가 너무 과하며 불필요한 구현이 존재
    - 새롭게 리펙토링하여 좀 더 가독성 좋게 변경
### 추가 구현사항
- 기존에 데이터를 받는 기능, 데이터를 조작하는 기능 등 로직을 필요 이상으로 세분화했던 내용들을 각 클래스의 역할에 맞게 메소드를 이동
- 핵심 로직이 들어가는 domain 패키지와 UI를 그려주는 view 패키지로만 구성
- 게임을 시작하여 입력받는 클래스를 따로 두어 해당 클래스를 생성할 때 바로 게임을 시작 및 출력하도록 설계
- 입력 시 잘못된 값을 입력하면 예외를 발생하여 게임이 종료되도록 변경
- Names라는 새로운 클래스를 정의하여 입력받는 이름들을 생성자에 입력하여 출력에 알맞게 변경해주는 기능들을 넣어놓음
- getter를 사용하지 않기 위해 `toString`을 통해 각 클래스 별로 원하는 데이터를 출력할 수 있게 수정
- Stream API 적극 활용
---
## 4단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84-4%EB%8B%A8%EA%B3%84-%EA%B5%AC%ED%98%84))
### 기능 요구사항
- 3단계와 동일하다.
### 프로그래밍 요구사항
- **로직을 구현하는 코드에 단위 테스트가 존재해야 한다. 단, UI 처리 로직(System.in, System.out)은 테스트에서 제외한다.**
- 각각의 역할에 맞도록 **패키지를 분리하고 접근 제어자를 적절히 사용**하도록 리팩토링한다.
- 나머지는 이전 단계와 동일하게 적용한다.
### 피드백 반영
- 입력을 받는 메소드들의 이름이 get으로 시작하는데 getter로 보이기 때문에 ask로 시작하도록 변경
- Line 클래스 내 `ArrayList<Boolean> points`를 한 번 더 Wrapping하여 일급 컬렉션으로 변경
### 상세 구현사항
- 이전 단계에서 이미 패키지 분리를 적용하였기 때문에 동일한 구조로 진행
  - domain: 핵심 로직들을 담당하는 클래스를 포함
  - view: UI 출력 담당
- 단위 테스트 구현
  - 이름에 빈 칸만 입력할 경우, `,`만 입력할 경우 예외가 올바르게 발생하는지 확인
  - 여러 길이의 이름을 입력할 때 올바른 형태로 출력되는지 확인
  - 사다리 높이에 올바르지 않은 값을 입력할 경우 예외가 올바르게 발생하는지 확인 
  - 라인을 임의로 생성할 때 올바른 형태로 출력되는지 확인
---
## 4단계 추가 구현
### 피드백 반영
- Exception 처리가 미흡한 부분 개선
  - RuntimeException을 상속받는 DuplicatedInputException, EmptyInputException을 정의하여 사용
  - 최종적으로 위 두 사용자 정의 예외와 NumberFormatException을 활용하여 단위 테스트에 반영
- 생성자만을 호출하여 사용하는 부분 개선
  - 생성자는 생성자의 역할만 하도록 수정하여 메소드를 호출하는 방식으로 실행
- `ArrayList<Line> lines` 또한 `Points`와 동일하게 `Lines`라는 일급 컬렉션으로 만들어 역할 위임이 가능
  - 해당 내용을 반영하여 역할을 위임
- 일급 컬렉션에서 생성된 `ArrayList`를 받는 생성자 뿐만 아니라 디폴트 생성자도 두는 것이 좋음
  - 해당 내용 `Lines`와 `Points` 모두 반영
### 추가 구현사항
- `LadderGame` 클래스에 입력을 받는 메소드들이 존재했었는데 이 또한 UI 처리 로직이라 판단되어 `LadderView` 클래스로 이동
  - 접근 제한자를 `public static`으로 변경하여 활용
- domain 패키지 내에 너무 많은 클래스가 분류되지 않은 채 존재하여 model 패키지를 내부에 생성하여 데이터를 저장하는 클래스들 모두 이동
- `Names` 클래스에 이름이 중복돼서 들어갈 경우도 확인하는 로직 및 단위 테스트
- 기존에 구현했던 이름이 다섯 글자보다 적을 때 출력 형식을 지정해주는 로직을 삭제하고 `StringUtils`의 `center` 메소드 활용
---
## 5단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84-5%EB%8B%A8%EA%B3%84-%EA%B5%AC%ED%98%84))
### 기능 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, `all`을 입력하면 전체 참여자의 실행 결과를 출력한다.
- 이름에 "춘식이"를 입력하면 프로그램을 종료한다.
### 프로그래밍 요구사항
- setter 메소드를 사용하지 않고 구현한다. 단, DTO(Data Transfer Object)는 제외
### 상세 구현사항
- `Results` 클래스를 만들어 입력받은 결과들을 저장
- `LadderView` 클래스에서 결과 입력 및 결과 확인 메소드 정의
- `Ladder`의 생성자에 입력받은 결과도 함께 전달하도록 변경
- 클래스의 구조가 `Ladder` → `Lines` → `Line` → `Points` 순으로 타고 들어가며 setter, getter를 사용하지 않기 때문에 `Points`까지 내려가서 결과를 확인
  - `Points`에서 현재 위치에서 갈 수 있는 다음 위치를 확인하는 메소드 정의
  - `Ladder`에서 각 `Line`에 접근하면서 각 참가자 별 결과를 확인하는 메소드 정의
- 결과 관련 단위 테스트 추가
  - 결과에 빈 칸만 입력할 경우, `,`만 입력할 경우 예외가 올바르게 발생하는지 확인
  - 여러 길이의 결과를 입력할 때 올바른 형태로 출력되는지 확인
  - 이름과 결과의 개수가 서로 다를 때 예외가 올바르게 발생하는지 확인
---
## 5단계 추가 구현
### 피드백 반영
- `matches`를 `Matches` 클래스의 일급 컬렉션으로 처리
- `String`의 `trim()`과 `isEmpty()`를 한 번에 해주는 `StringUtils`의 `isBlank` 활용
- 일급 컬렉션의 생성자 중 이미 데이터가 있는 상태가 아니라면 멤버변수에 넣어줄 컬렉션을 넘겨줄 필요가 없으므로 디폴트 생성자 활용
