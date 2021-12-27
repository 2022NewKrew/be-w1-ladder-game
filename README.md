# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

---
# 1단계 ([링크](https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/ladder-game-step-1))
## 기능 요구사항
- 간단한 사다리 게임을 구현한다.
- n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- 사다리가 있으면 `-`를 표시하고 없으면 `" "` (공백문자)를 표시한다. 양옆에는 `|`로 세로를 표시한다.
- 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
## 프로그래밍 요구사항
- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
## 상세 구현사항
- `|`, `-`, `" "` (공백문자)를 상수로 선언하여 활용
- 인원 수 `n` 및 사다리 개수 `m`, 2차원 배열 `ladder` 멤버 변수 선언
- `Math.random`을 활용하여 라인을 그릴지에 대한 여부 결정
- 입력 및 초기화 → 사다리 완성 → 사다리 출력 순으로 구현