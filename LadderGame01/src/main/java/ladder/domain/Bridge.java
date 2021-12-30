package ladder.domain;

class Bridge {
    private BridgeType type;

    protected Bridge(boolean isConneted){
        this.type = isConneted ? BridgeType.CONNECTED : BridgeType.DISCONNECTED;
    }

    public boolean isConnected(){
        return BridgeType.CONNECTED == type;
    }

    @Override
    public String toString() {
        return type.getBridge();
    }
}
