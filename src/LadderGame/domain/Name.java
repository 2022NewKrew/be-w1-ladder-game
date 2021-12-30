package LadderGame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Name {
    // 클래스 변수 및 상수
    private static final int MAX_NAME_SIZE = 5;
    public static int firstNameLength;

    // 인스턴스 변수
    private final List<String> nameList;

    Name(String inputName) throws Exception {
        checkEmptyInput(inputName);
        this.nameList = splitInputNames(inputName);
        firstNameLength = this.nameList.get(0).length();
    }

    private void checkEmptyInput(String inputName) throws Exception {
        if(inputName.length() <= 0){
            throw new Exception("이름을 입력해주세요.");
        }
    }

    private void checkMaxLengthName(String name) throws Exception {
        if (name.length() > MAX_NAME_SIZE) {
            throw new Exception("이름 크기는 "+MAX_NAME_SIZE+"을(를) 넘을 수 없습니다.");
        }
        if (name.length() <= 0){
            throw new Exception("이름 크기는 0보다 커야합니다.");
        }
    }

    private List<String> splitInputNames(String inputName) throws Exception {
        List<String> nameList = new ArrayList<>(Arrays.asList(inputName.split(",")));
        for (String s : nameList) {
            checkMaxLengthName(s);
        }
        return nameList;
    }

    public int getNamesSize() {
        return nameList.size();
    }

    public List<String> getNameList() {
        return nameList;
    }
}
