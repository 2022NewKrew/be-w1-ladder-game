package ladder.domain;

import ladder.util.RandomUtil;

public class Ladder {

    private final boolean[][] branches;

    public Ladder(boolean[][] branches) {
        this.branches = copyArray(branches);
    }

    private boolean[][] copyArray(boolean[][] array) {
        boolean[][] copiedArray = new boolean[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, copiedArray[i], 0, array[i].length);
        }
        return copiedArray;
    }

    public boolean[][] getIsBranch() {
        return branches;
    }

    public static Ladder makeRandomBranch(int countOfPerson, int ladderHeight) {
        validate(countOfPerson,ladderHeight);
        boolean[][] branches = new boolean[ladderHeight][countOfPerson - 1];
        for (int i = 0; i < ladderHeight; i++) {
            branches[i] = makeRandomBranchLine(countOfPerson);
        }
        return new Ladder(branches);
    }

    private static void validate(int countOfPerson, int ladderHeight) {
        if(countOfPerson<=0){
            throw new IllegalArgumentException("사람 수는 0명 이하일 수 없습니다.");
        }
        if(ladderHeight<=0){
            throw new IllegalArgumentException("사다리 높이는 0 이하일 수 없습니다.");
        }
    }

    private static boolean[] makeRandomBranchLine(int countOfPerson) {
        boolean[] branchLine = new boolean[countOfPerson - 1];
        for (int i = 0; i < countOfPerson - 1; i++) {
            branchLine[i] = RandomUtil.generateBoolean();
        }
        return branchLine;
    }
}
