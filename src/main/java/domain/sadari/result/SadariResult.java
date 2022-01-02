package domain.sadari.result;

import static constant.Constants.MAX_LENGTH_OF_NAME;

public class SadariResult {

    private final String name;

    public SadariResult(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.printf("%-" + MAX_LENGTH_OF_NAME + "s ", name);
    }

    public boolean isNotEmptyName() {
        return !name.isEmpty();
    }
}
