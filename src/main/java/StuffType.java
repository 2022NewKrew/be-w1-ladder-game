public enum StuffType {
    // 0: 기둥, 1: 다리, 2: 공백
    COLUMN("|"),
    BRIDGE("-"),
    SPACE(" ");

    final private String stuff;
    public String getStuff(){
        return stuff;
    }
    StuffType(String stuff) {
        this.stuff = stuff;
    }
}
