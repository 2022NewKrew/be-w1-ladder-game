# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

# 2일차
- ## 요구사항  
  - ### Step 1 PR 피드백 요구사항 
    - Main 에 있는 IO 관련 프로세스를 함수화
    - numOfPeople , height 변수를 final 변수로 변경하고, setter 삭제.
    - 사용되지 않는 메소드 제거.
    - getter,setter 사용 최소화
    - isLadderLine 함수의 인자수 3개->2개로 최소화
  - ### 개선 필요해보이는 부분
    - height -> ladderHeight 로 변수명 변경
    - 각 위치별로 print 하기보다는 String으로 만들어 한 번에 print
  - ### 2일차 요구사항
  - ![img.png](img.png)
    https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/%EC%82%AC%EB%8B%A4%EB%A6%AC-%EA%B2%8C%EC%9E%84/ladder-game-step-2_

- ## 구현 내용 
  - LadderIO class를 생성하여 Main 에서 처리하던 File IO 관련 부분을 처리.
    - Ladder에서 getter, setter 삭제 후, Ladder 생성자로 ladder 객체 생성하도록 변경.
  - indent depth를 줄이고자 2기존의 Ladder를 2차원 Array로 표현하던 구조를 ArrayList 내 class로 변경.
    - ArrayList<Line> 를 이용하여 drawLadder 표현.
    - Line Clss를 만들어, 각 사다리의 높이 별로 각 줄을 생성