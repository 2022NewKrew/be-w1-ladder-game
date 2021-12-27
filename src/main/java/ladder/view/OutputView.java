package ladder.view;

public class OutputView {

    public static void outputResult(char[][] ladder){
        for (char[] line : ladder) {
            for(char element : line) {
                System.out.print(element);
            }
            System.out.println();
        }

    }


}
