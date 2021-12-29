package rubam.step3;

import java.util.*;

public class InputLadderInform {

    private static final int MAX_LENGTH = 5;
    private static Scanner scanner = new Scanner(System.in);

    private InputLadderInform() {

    }

    ////////////////////////////////////

    public static List<String> inputNames() {
        while(true) {
            try {
                System.out.println("참여할 사람 이름을 입력하세요");
                String names = scanner.nextLine();
                checkNames(names);
                return new ArrayList<>(Arrays.asList(names.split(",")));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer inputHeight() {
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                int height = sc.nextInt();
                checkHeight(height);
                return height;
            } catch (LadderInputException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException ime) {
                System.out.println("정수입력");
            }
        }
    }

    ////////////////////////////////////

    private static void checkHeight(int height) throws LadderInputException{
        if(height < 1) {
            throw new LadderInputException("최소 1 이상의 높이로 지정해주세요.");
        }
    }

    private static void checkNames(String names) {
        for (String i : names.split(",")) {
            checkNameSize(i);
        }
    }

    private static void checkNameSize(String i) throws LadderInputException {
        if(i.length() > MAX_LENGTH) {
            throw new LadderInputException("이름 최대 크기 초과. " + MAX_LENGTH + "이내의 크기로 입력해주세요.");
        }
    }
}
