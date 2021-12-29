import java.util.List;

public class SadariPrinter {

    private final Users users;
    private final SadariMap sadariMap;

    public SadariPrinter(Users users, SadariMap sadariMap) {
        this.users = users;
        this.sadariMap = sadariMap;
    }

    public void printSadariGame() {
        printUsers();
        printSadari();
    }

    private void printUsers() {
        for (User user : users.getUserList()) {
            printUser(user);
        }
        SadariMapStatus.END.printStatus();
    }

    private void printUser(User user) {
        System.out.print(user.getName());
        printGapBetweenName(user);
    }

    private void printGapBetweenName(User user) {
        for (int i = 0; i < getGapSizeBetweenName(user); i++) {
            System.out.print(" ");
        }
    }

    private int getGapSizeBetweenName(User user) {
        return User.getMaxLengthOfName() + 1 - user.getLengthOfName();
    }

    private void printSadari() {
        for (List<SadariMapStatus> sadariMapStatus : sadariMap.getSadariMap()) {
            sadariMapStatus.forEach(SadariMapStatus::printStatus);
        }
    }
}
