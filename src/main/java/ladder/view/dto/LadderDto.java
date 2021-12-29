package ladder.view.dto;

public class LadderDto {
    private final String nameList;
    private final int height;

    public int getHeight() {
        return height;
    }

    public String getNameList() {
        return nameList;
    }

    public LadderDto(String nameList, int height) {
        this.nameList = nameList;
        this.height = height;
    }
}
