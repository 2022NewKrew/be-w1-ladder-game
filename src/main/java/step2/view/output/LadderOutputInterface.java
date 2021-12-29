package step2.view.output;

import step2.domain.Ladder;

public class LadderOutputInterface implements OutputInterface{
    @Override
    public void print(Ladder ladder) {
        System.out.println(ladder);
    }
}
