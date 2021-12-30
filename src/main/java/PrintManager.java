import java.util.List;

public class PrintManager {
    private static final String DELIMITER = " ";

    public PrintManager() {
    }
    public static void printPeople(String[] namePeople){
        StringBuilder stringNamePeople = new StringBuilder();

        for(String name : namePeople){
            stringNamePeople.append(String.format("%-5s",name)).append(DELIMITER);
        }
        System.out.println(stringNamePeople);
    }

    public static void printLadder(String stringLadder) {
        System.out.println(stringLadder);
    }
}
