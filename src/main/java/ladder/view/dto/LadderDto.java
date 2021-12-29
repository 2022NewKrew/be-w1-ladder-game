package ladder.view.dto;

public class LadderDto {
    private final String nameList;
    private final int heigth;

    public int getHeigth() {
        return heigth;
    }

    public String getNameList() {
        return nameList;
    }

    public LadderDto(String nameList, int heigth) {
        this.nameList = nameList;
        this.heigth = heigth;
    }
}
