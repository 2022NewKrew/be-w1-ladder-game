package view;

import domain.Name;
import domain.NameRepository;


public class NameView {

    private NameRepository nameRepository;

    public NameView(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public void printNames() {
        for (Name name : nameRepository.getNameList()) {
            System.out.print(nameIndent(name));
        }
        System.out.println();
    }

    //이름을 사다리의 가운데에 놓기 위해 이름 앞뒤에 공백을 추가해주는 메서드
    private String nameIndent(Name name) {
        switch (name.getLength()) {
            case 1:
                return "   " + name.getName() + "  ";
            case 2:
                return "   " + name.getName() + " ";
            case 3:
                return "  " + name.getName() + " ";
            case 4:
                return " " + name.getName() + " ";
            default:
                return " " + name.getName();
        }
    }
}
