package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderConfig;
import ladder.domain.LadderGame;
import ladder.view.IO;


public class Main {
    public static void main(String[] args) {

        IO ioDriver = new IO();
        LadderConfig ladderConfig= ioDriver.getInput();
        Ladder ladder = new Ladder(ladderConfig);

        String ladderStr = ladder.getLadderStr();
        ioDriver.printLadder(ladderStr);

        while (true){
            //try catch 로 나오기
            run(ioDriver, ladder);
        }

    }

    private static void run(IO ioDriver, Ladder ladder) {

        String resultUser = ioDriver.getResultsUser();
        if (resultUser.equals("all")){
            String[] outputs = ladder.runGameForAll();
            String[] names = ladder.getPeopleNames();
            ioDriver.printResultsAll(outputs, names);
            return;
        }
        String output = ladder.runGame(resultUser);
        if (output.equals("NOT Existing User")){
            //error 해당 유저 없으면 while 문 나오기
        }
        // 결과 알고자하는 유저 한명일 경우
        ioDriver.printResultEach(output);

    }
}

