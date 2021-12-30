# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

### step#1
>n과 m을 입력 받아 랜덤으로 사다리를 생성합니다.
>2차원 char 배열을 이용해 사다리를 표현했습니다. ladder 클래스는 다음과 같은
>메서드로 구성됩니다.

- constructor
  - 입력받은 n과 m으로 배열을 초기화합니다.
- fillLadder()
  - Random(java.util)을 사용하여 랜덤으로 다리를 놓습니다.
- print()
  - 저장된 사다리를 화면에 출력합니다

### step#2
>다음 내용이 수정되었습니다.
- 출력 메서드명이 print에서 printLadder로 변경되었습니다.
- 멤버 변수에 접근제한자를 지정하였습니다.
- 사다리의 한 행을 나타내는 'LadderRow' 라는 InnerClass를 작성하였습니다.
- 사다리의 표현을 2차원 char배열에서 ArrayList<LadderRow>로 변경하였습니다.
- 사다리를 랜덤으로 채우는 부분이 변경되었습니다.
    - 기존 : Ladder의 fillLadder()에서 일괄 수행합니다.
    - 변경 : LadderRow의 생성자 안에서 수행합니다.
- LadderGame의 생성자에서 n과 m에 대한 유효성 검사가 추가되었습니다.
    - 위에 따라, main 메서드에서 예외처리가 추가되었습니다.
- 이중 for문의 구조를 ArrayList<LadderRow>로 변경하였습니다.

