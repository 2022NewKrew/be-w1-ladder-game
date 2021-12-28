public enum LadderFrame {
    STEP('-'), EMPTY(' '), PILLAR('|');

    private final char value;
    LadderFrame(char value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
