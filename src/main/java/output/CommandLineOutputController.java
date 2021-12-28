package output;

import dto.Ladder;

public class CommandLineOutputController implements OutputController {
    @Override
    public void outputLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
