# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

# 사다리 게임 1단계 구현

## 기능 요구사항
* 간단한 사다리 게임을 구현한다.
* n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
* 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다. 
* 사다리가 있으면 ```-```를 표시하고 없으면 ```" "``` (공백문자)를 표시한다. 양옆에는 ```|```로 세로를 표시한다. 
* 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 

## 프로그래밍 요구사항
* [X] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* [X] 메서드가 한 가지 일만 하도록 최대한 작게 만들자.

### 실행 결과
* 위 요구사항에 따라 3명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```
참여할 사람은 몇 명인가요?
3
최대 사다리 높이는 몇 개인가요?
5

|-| |
| |-|
|-| |
| |-|
|-| |
```

## 힌트
* 2차원 배열을 학습한 후 2차원 배열을 추가해 문제를 해결하거나 ArrayList를 학습하고 이를 이용해 구현한다.

# 사다리 게임 2단계 구현

## 기능 요구사항
* 1단계와 같다.

## 프로그래밍 요구사항
* [X] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
* [X] 들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
* [X] else를 사용하지 마라.
* [X] 구현 순서를 고려하면서 프로그래밍한다.
* [X] naming convention을 지키면서 프로그래밍한다.

## 클래스 구현 순서
* 클래스를 구현할 때 다음 순서를 지켜 구현한다.
```
package 패키지명

import ...

class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
}
```
## Naming Convention
* 자바는 낙타 표기법(Camel Case)를 따른다.
* 클래스명은 대문자로 시작, 변수 메소드는 소문자로 시작 
* 클래스 이름 예 : Rectangle, LaundryList, StudentDirectory 
* 변수 이름 예 : firstName, description, mediaController 
* 메소드 이름 예 : getFirstName(), cancelOrder(), isDeleted()

## 힌트
* 들여쓰기(indent)를 줄이는 가장 좋은 방법은 메소드를 분리하는 것이다. 
  * 들여쓰기가 2이상인 메소드의 경우 메소드를 분리하는 방법을 찾는다. 
  * 메소드 라인이 10라인을 넘어가는 경우 메소드를 분리한다. 
* else를 사용하지 않는 방법은 if절에서 값을 바로 return하면 메소드 실행이 종료되기 때문에 가능하다.
```
    public int add(String text) {
        int result;
        if (text == null || text.isEmpty()) {
            result = 0;
        } else {
            result = Integer.parseInt(text);
        }
        
        return result;
    }
```
* 위 코드는 다음과 같이 else를 사용하지 않고 구현 가능하다.
```
    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        return Integer.parseInt(text);
    }
```

# 사다리 게임 3단계 구현

## 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다. 
* 사람 이름은 쉼표(,)를 기준으로 구분한다. 
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. 
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다. 
  * ```|-----|-----|``` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 프로그래밍 요구사항
* [X] 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  * 메서드가 한 가지 일만 하도록 최대한 작게 만들자.
* [X] 들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.
  * depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
* [X] else를 사용하지 마라.
* [X] 배열 대신 ArrayList와 Generic을 활용해 구현한다.

## 실행 결과
* 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

  pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```

## 힌트
* 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ```ArrayList<ArrayList<Boolean>>```와 같이 이해하기 어려운 코드가 추가된다. 
* 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
```
public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
```
* 위와 같이 Line 객체를 추가하면 ```ArrayList<ArrayList<Boolean>>``` 코드를 ```ArrayList<Line>```과 같이 구현하는 것이 가능해 진다.