package LadderGame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private static int row;

    // 인스턴스 변수
    private final UserList userList;
    private final List<Line> lines = new ArrayList<>();
    private final List<String> resultList;

    // 생성자
    public Ladder(String userList, String results, int column) throws Exception {
        this.userList = new UserList(userList);
        createLines(column);
        resultList = createResultList(results);
    }

    // 메소드
    private void createLines(int column) throws Exception {
        checkColumnValid(column);
        row = 2 * this.userList.getNamesSize() - 1;

        for (int i = 0; i < column; i++) {
            Line line = new Line(row);
            lines.add(line);
        }
    }

    private List<String> createResultList(String results) {
        List<String> resultList = new ArrayList<>(Arrays.asList(results.split(",")));
        try {
            checkResultsValid(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return resultList;
    }

    private void checkResultsValid(List<String> resultList) throws Exception {
        if (resultList.size() != userList.getNamesSize()) {
            throw new Exception("실행 결과의 개수는 참여 사람의 수와 같아야합니다.");
        }
        if (resultList.stream().anyMatch(s -> s.length() <= 0)) {
            throw new Exception("실행 결과는 비워둘 수 없습니다.");
        }
    }

    protected void checkColumnValid(int row) throws Exception {
        if (row <= 0) {
            throw new Exception("사다리의 높이는 0보다 커야합니다.");
        }
    }

    public void createLadderGameResult() {
        int len = this.userList.getNamesSize();
        for (int i = 0; i < len; i++) {
            int curPoint = i*2;
            for (int j = 0; j < lines.size(); j++) {
                curPoint = moveCurPoint(j, curPoint);
            }
            userList.setUserResult(i, resultList.get(curPoint / 2));
        }
    }

    private int moveCurPoint(int curHeight, int curPoint) {
        if (curPoint != 0 && lines.get(curHeight).isBRIDGE(curPoint - 1)) {
            return curPoint - 2;
        }
        if (curPoint != row - 1 && lines.get(curHeight).isBRIDGE(curPoint + 1)) {
            return curPoint + 2;
        }
        return curPoint;
    }

    public UserList getNames() {
        return userList;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String getResult(String nameInput) {
        if(nameInput.compareTo("all")==0){
            return userList.getUserResultAll();
        }
        return userList.getUserResult(nameInput);
    }

    public List<String> getResultList(){
        return this.resultList;
    }
}
