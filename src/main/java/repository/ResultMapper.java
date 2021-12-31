package repository;

public class ResultMapper {
    private NameToPointMapping nameToPointMapping;
    private PointToResultMapping pointToResultMapping;

    public ResultMapper(NameToPointMapping nameToPointMapping, PointToResultMapping pointToResultMapping){
        this.nameToPointMapping = nameToPointMapping;
        this.pointToResultMapping = pointToResultMapping;
    }

    public String getResult(String name){
        return pointToResultMapping.getResult(nameToPointMapping.getPoint(name));
    }

    public String printAll(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String name : nameToPointMapping.getAllName()){
            stringBuilder.append(name);
            stringBuilder.append(": ");
            stringBuilder.append(getResult(name));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean isKey(String name) { return nameToPointMapping.isKey(name); }
    public void swapResult(int idx) { pointToResultMapping.swapResult(idx); }

}
