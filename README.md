# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

# step 3
- [x] 사다리 게임 3단계까지 기능 요구사항 완료
- [x] else 예약어 사용하지 않음
- [x] indent depth 2를 넘지 않도록 구현완료
- [x] 함수의 길이가 10라인을 넘어가지 않도로 구현완료
- [x] domain, view 패키지 분리완료
- [x] InputView, outputView생성

# step 4
- [x] src폴더 최상단위치로 이동
- [x] .idea 파일 gitignore에 반영
- [x] Ladder 클래스의 인스턴스 변수명 변경 (map -> lines)
- [x] Ladder 클래스의 showMap() 함수를 OutputView 의 showLadder함수가 담당
- [x] toString()에 @OverRide 어노테이션 추가
- [ ] Line 클래스의 isLine, toString 같은 출력함수는 Line클래스와 분리하는 것을 고려
- [x] Line 클래스의 함수명을 좀 더 명확하게 변경
   - pointsIsNotEmpty() -> isLastCells()
   - pointsLastTrue() -> isLastPoint()
   - getRandomAndNotDuplicate() -> generateCellNotDuplicate()
- [x] Line 클래스의 인스턴스 변수명 변경 (points -> cells)
- [x] 입출력 테스트 제거(참가자 이름 출력 테스트는 필수 요구사항에 포함되어 유지하였습니다)
- [ ] Line 클래스의 cell 생성전략 변경 고려(인터페이스 사용)


# Q&A
1. /test/java/domain/LineTest 의 '가로선_연속2개방지_테스트'를 위해 Line 클래스에 getter(getCells())을 만들었는데 테스트를 위해 getter를 만드는게 적절한 조치인지가 궁금합니다.
