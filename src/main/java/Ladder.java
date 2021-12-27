public class Ladder {
    private int numberOfParticipants;
    private int ladderHeight;
    private boolean[][] bridge;


    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public boolean[][] getBridge() {
        return bridge;
    }

    public void setBridge(boolean[][] bridge) {
        this.bridge = bridge;
    }

    public String getLadderString() {
        StringBuffer stringBuffer = new StringBuffer();

        try {
            for (int i = 0; i < this.ladderHeight; i++) {
                for (int j = 0; j < this.numberOfParticipants * 2 - 1; j++) {
                    if( j%2 == 0) {
                        stringBuffer.append("|");
                    }else if(this.bridge[i][j/2]) {
                        stringBuffer.append("-");
                    }else {
                        stringBuffer.append(" ");
                    }
                }
                stringBuffer.append("\n");
            }
        } catch (Exception e) {
            System.out.println("error message : " + e.getMessage());
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
