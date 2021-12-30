
public class SadariPrinter {

    private final Users users;
    private final SadariMap sadariMap;

    public SadariPrinter(Users users, SadariMap sadariMap) {
        this.users = users;
        this.sadariMap = sadariMap;
    }

    public void printSadariGame() {
        users.printUsers();
        sadariMap.printSadari();
    }
}
