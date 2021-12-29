import java.util.List;

public class Name {

    private final List<String> names;

    public Name(List<String> names) {
        this.names = names;
        for (String name : names) {
            nameValid(name);
        }
    }

    public int getLength() {
        return names.size();
    }

    public void printNames() {
        for (String name : names) {
            System.out.print(nameIndent(name));
        }
        System.out.println();
    }

    //이름을 사다리의 가운데에 놓기 위해 이름 앞뒤에 공백을 추가해주는 메서드
    private String nameIndent(String name) {
        return switch (name.length()) {
            case 1 -> "   " + name + "  ";
            case 2 -> "   " + name + " ";
            case 3 -> "  " + name + " ";
            case 4 -> " " + name + " ";
            default -> " " + name;
        };
    }

    //이름의 유효성 검사
    private void nameValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다");
        }
    }

}
