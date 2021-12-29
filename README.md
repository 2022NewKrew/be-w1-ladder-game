# be-w1-ladder-game

자바 웹 백엔드 1주차 사다리 게임

---
# 사다리 게임 1단계 구현

- 최종수정: 2021년 12월 8일
- version: 1.0.0.k



## 기능 요구사항

- 간단한 사다리 게임을 구현한다.
- n명의 사람과 m개의 사다리 개수를 입력할 수 있어야 한다.
- 사다리의 라인은 랜덤 값에 따라 있거나 없을 수도 있다.
- 사다리가 있으면 `-`를 표시하고 없으면 `" "` (공백문자)를 표시한다. 양옆에는 `|`로 세로를 표시한다.
- 사다리 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.



## 프로그래밍 요구사항

- **메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.**
- 메서드가 한 가지 일만 하도록 최대한 작게 만들자.



### 실행 결과

- 위 요구사항에 따라 3명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.

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
코드복사
```



## 힌트

- 2차원 배열을 학습한 후 2차원 배열을 추가해 문제를 해결하거나 ArrayList를 학습하고 이를 이용해 구현한다.

---

# 사다리 게임 2단계 구현



## 기능 요구사항

- 1단계와 같다.



## 프로그래밍 요구사항

- 메서드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - 메서드가 한 가지 일만 하도록 최대한 작게 만들어라.
- **들여쓰기(indent) depth를 2단계에서 1단계로 줄여라.**
  - depth의 경우 if 문을 사용하는 경우 1단계의 depth가 증가한다. if 문 안에 while 문을 사용한다면 depth가 2단계가 된다.
- **else를 사용하지 마라.**
- **구현 순서를 고려하면서 프로그래밍한다.**
- **naming convention을 지키면서 프로그래밍한다.**



## 클래스 구현 순서

- 클래스를 구현할 때 다음 순서를 지켜 구현한다.

```java
package 패키지명

import ...

class Ladder {
    //상수 및 클래스 변수

    //인스턴스 변수

    //생성자

    //메서드
}
코드복사
```



## Naming Convention

- 자바는 낙타 표기법(Camel Case)를 따른다.
- 클래스명은 대문자로 시작, 변수 메소드는 소문자로 시작
- 클래스 이름 예 : Rectangle, LaundryList, StudentDirectory
- 변수 이름 예 : firstName, description, mediaController
- 메소드 이름 예 : getFirstName(), cancelOrder(), isDeleted()



## 힌트

- 들여쓰기(indent)를 줄이는 가장 좋은 방법은 메소드를 분리하는 것이다.
  - 들여쓰기가 2이상인 메소드의 경우 메소드를 분리하는 방법을 찾는다.
  - 메소드 라인이 10라인을 넘어가는 경우 메소드를 분리한다.
- else를 사용하지 않는 방법은 if절에서 값을 바로 return하면 메소드 실행이 종료되기 때문에 가능하다.

```java
    public int add(String text) {
        int result;
        if (text == null || text.isEmpty()) {
            result = 0;
        } else {
            result = Integer.parseInt(text);
        }
        
        return result;
    }
코드복사
```

- 위 코드는 다음과 같이 else를 사용하지 않고 구현 가능하다.

```java
    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        return Integer.parseInt(text);
    }
```
