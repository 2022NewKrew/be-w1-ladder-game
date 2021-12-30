package ladder.view.dto;

public class LadderDto {
    private final String nameList;
    private final int height;
    private final String resultList;

    public int getHeight() {
        return height;
    }

    public String getNameList() {
        return nameList;
    }

    public String getResultList() {
        return resultList;
    }

    public LadderDto(String nameList, int height, String resultList) {
        this.nameList = nameList;
        this.height = height;
        this.resultList = resultList;
    }

}
