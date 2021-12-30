package config;

public enum LadderGameConfig {
    END_CONDITION("춘식이"),
    ALL_CONDITION("all");


    private final String value;

    LadderGameConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
