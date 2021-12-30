package domain;

import java.util.regex.Pattern;

public class Reward {
    static final String MONEY_PATTERN_EXCEPTION_MESSAGE = "돈은 꽝 또는 숫자로 적어주셔야합니다.";
    private static final String ZERO_MONEY_STRING = "꽝";

    private static final Pattern moneyPattern = Pattern.compile("^[1-9][0-9]*$");

    private final int amount;

    public Reward(String moneyString) {
        this.amount = convertToInt(moneyString);
    }

    public Reward(Reward reward){
        this.amount = reward.amount;
    }

    private static int convertToInt(String moneyString){
        validate(moneyString);
        if(moneyString.equals(ZERO_MONEY_STRING)){
            return 0;
        }

        return Integer.parseInt(moneyString);
    }

    private static void validate(String moneyString){
        if(!moneyString.equals(ZERO_MONEY_STRING) && !moneyPattern.matcher(moneyString).find()){
            throw new IllegalArgumentException(MONEY_PATTERN_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        if(amount == 0){
            return ZERO_MONEY_STRING;
        }

        return String.valueOf(amount);
    }
}
