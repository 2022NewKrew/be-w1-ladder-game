package Domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private int manCount;
    private ArrayList<LadderRow> ladderMap;
    private ArrayList<LadderDst> dstLst;

    private Ladder(int height, int manCount) {
        this.height = height;
        this.manCount = manCount;
        this.ladderMap = new ArrayList<>();
        this.dstLst = new ArrayList<>();
        makeMap();
    }

    public static Ladder getInstance(int height, int manCount) {
        Ladder ladder = new Ladder(height, manCount);
        return ladder;
    }

    private void makeMap() {
        for (int i = 0; i < height; i++)
            makeRow(manCount);
    }

    private void makeRow(int manCount) {
        ladderMap.add(LadderRow.getInstance(manCount));
    }

    public List<Integer> getPlayerDstIdx(List<Integer> playerIdxLst){
        List<Integer> dstIdxLst = new ArrayList<>();
        for(int playerIdx : playerIdxLst)
            dstIdxLst.add(dstLst.get(playerIdx).getDst());
        return dstIdxLst;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : ladderMap) {
            sb.append(row.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    //테스트용 임시 함수
    public String printDst(){
        for(LadderDst dst : dstLst){
            System.out.println(dst.getStart() + " - " + dst.getDst());
        }
        return "";
    }

    void makeDstLst(){
        for(int i=0; i<manCount; i++)
            dstLst.add(new LadderDst(i, calDst(i)));
    }

    int calDst(int start){
        int dst = start;
        for(int i=0; i<ladderMap.size(); i++) {
            dst = calCol(ladderMap.get(i), dst);
        }
        return dst;
    }

    private int calCol(LadderRow row, int curIdx){
        if(goLeft(row, curIdx)) return curIdx-1;
        else if(goRight(row,curIdx)) return curIdx+1;
        return curIdx;
    }

    private boolean goLeft(LadderRow row, int curIdx){
        int leftCol = curIdx-1;
        if(leftCol >= 0 && row.get(leftCol).getIsHorizontal()) return true;
        return false;
    }

    private boolean goRight(LadderRow row, int curIdx){
        int rightCol = curIdx;
        if(rightCol < row.size() && row.get(rightCol).getIsHorizontal()) return true;
        return false;
    }


}
