package domain.sadari;

import java.util.ArrayList;
import java.util.List;

public class SadariRow {

    private final List<SadariMapStatus> sadariRow = new ArrayList<>();

    public SadariRow() {
    }


    public void addSadariMapStatus(SadariMapStatus sadariMapStatus) {
        sadariRow.add(sadariMapStatus);
    }

    public SadariMapStatus getSadariMapStatus(int columnNumberOfRow) {
        return sadariRow.get(columnNumberOfRow);
    }

    public void printSadariRow() {
        sadariRow.forEach(SadariMapStatus::printStatus);
    }
}
