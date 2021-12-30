package step2LadderGame.domain.ladder;

import step2LadderGame.domain.ladderConfig.LadderConfig;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderGenerator implements LadderGenerator {

    private final Random random = new Random();

    @Override
    public Ladder generate(LadderConfig ladderConfig) {
        final int height = ladderConfig.getHeight();
        final int numOfPeople = ladderConfig.getNumOfParticipants();

        List<Branch> branches = makeBranches(height, numOfPeople);

        return new Ladder(branches);
    }

    protected List<Branch> makeBranches(int height, int numOfPeople) {
        // 최대 넓이는 인원수 2배의-1로 잡아준다.
        // 사다리가 연결된 모양을 2차원 배열로 표현하기 위해서
        final int width = 2 * numOfPeople - 1;

        return IntStream.range(0, height)
                .mapToObj(i -> makeBranch(width))
                .collect(Collectors.toList());
    }

    private Branch makeBranch(int width) {
        Branch branch = Branch.of(width);
        generateRandomBranch(branch);
        return branch;
    }

    private void generateRandomBranch(Branch branch) {
        IntStream.range(0, branch.getWidth())
                .forEach(index -> connectBranch(branch, index));
    }

    private void connectBranch(Branch branch, int index) {
        if (branch.isUserLine(index))
            return;

        final BranchType randomValue = random.nextBoolean() ? BranchType.CONNECTED : BranchType.DISCONNECTED;

        branch.setConnect(index, randomValue);
        branch.disConnectIfConnectedToLeft(index);
    }
}
