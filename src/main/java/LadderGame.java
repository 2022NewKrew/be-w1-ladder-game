import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class LadderGame{

    private final char VERTICAL_LADDER='|';
    private final char HORIZON_LADDER='-';

    private char[][] ladder;

    LadderGame(int peopleCnt,int ladderHeight){
        ladder=new char[ladderHeight][peopleCnt];
        makeHorizonLadder(peopleCnt,ladderHeight);
    }

    private void makeHorizonLadder(int peopleCnt,int ladderHeight){
        for(int row=0;row<ladderHeight;row++){
            makeVerticalLadder(peopleCnt,row);
        }
    }

    private void makeVerticalLadder(int peopleCnt,int row){
        boolean isLink;
        for(int col=0;col<peopleCnt-1;col++){
            isLink=RandomUtil.INSTANCE.generateBoolean();
            ladder[row][col]=(isLink)?HORIZON_LADDER:' ';
        }
    }

    public void printWholeLadder() throws IOException {
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int row=0;row<ladder.length;row++){
            printColLadder(row,wr);
            wr.newLine();
        }
        wr.flush();
        wr.close();
    }

    public void printColLadder(int row,BufferedWriter wr) throws IOException {
        for(int col=0;col<ladder[0].length-1;col++){
            wr.append(VERTICAL_LADDER);
            wr.append(ladder[row][col]);
        }
        wr.append(VERTICAL_LADDER);
    }

}