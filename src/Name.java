import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Name {
    // 클래스 변수 및 상수
    private static final int MAX_NAME_SIZE = 5;
    private static final int SPACE = 1;
    public static int firstNameLength;

    // 인스턴스 변수
    private final List<String> names;

    Name(String inputName) {
        this.names = splitNames(inputName);
        firstNameLength = this.names.get(0).length();
    }

    private List<String> splitNames(String inputName) {
        List<String> names = new ArrayList<>(Arrays.asList(inputName.split(",")));
        names.forEach(this::catchMaxLengthName);
        return names;
    }

    private void catchMaxLengthName(String name) {
        if (name.length() > 5) {
            System.out.println("이름은 5글자를 넘을 수 없습니다.");
            System.exit(0);
        }
    }

    public int getNamesSize() {
        return names.size();
    }

    @Override
    public String toString() {
        StringBuilder namesOutput = new StringBuilder();
        for (String name : this.names) {
            int padding = ((MAX_NAME_SIZE - name.length()) / 2) + SPACE;
            namesOutput.append(" ".repeat(padding)).append(name).append(" ".repeat(padding));
        }
        namesOutput.append("\n");
        return namesOutput.toString();
    }

}
