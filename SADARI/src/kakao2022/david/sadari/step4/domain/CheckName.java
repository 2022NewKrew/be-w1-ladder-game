package kakao2022.david.sadari.step4.domain;

import java.util.ArrayList;

public class CheckName {

    private static final int MAX_NAME_LENGTH = 5;
    protected static final String NAME_ERROR_MESSAGE = "이름은 최대 5글자 까지 부여할 수 있습니다.";

    protected static boolean checkPeopleList(ArrayList<String> peopleList) {
        try {
            checkPeopleName(peopleList);
            return true;
        } catch (NameLengthException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void checkPeopleName(ArrayList<String> peopleList) throws NameLengthException {
        for (String person : peopleList) {
            checkNameLength(person);
        }
    }

    protected static void checkNameLength(String person) throws NameLengthException {
        if (person.length() > MAX_NAME_LENGTH) {
            throw new NameLengthException(NAME_ERROR_MESSAGE);
        }
    }
}
