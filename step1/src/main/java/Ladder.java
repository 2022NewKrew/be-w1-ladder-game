package main;

public class Ladder {
    private int height;
    private int numOfPeople;
    private double[][] structure;
    private double base=0.5;

    public Ladder() {

    }

    public Ladder(int height, int numOfPeople) {
        this.height = height;
        this.numOfPeople = numOfPeople;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getHeight() {
        return height;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    //입력에 따라 data Structure를 구성합니다.
    public void setStructureType(String dataStructure) {
        if(dataStructure.equals("Array"))
            this.structure = new double[height][numOfPeople - 1];

    }

    //  Array로 구성된 Structure를 생성합니다. Math.random() 함수를 사용하여 사다리 각 위치에 0~1사이의 랜덤값을 생성합니다.
    public void setArrayStructure(){
        setStructureType("Array");
        for(int i=0;i<height;i++)
            for(int j=0;j<numOfPeople-1;j++){
                this.structure[i][j] = Math.random();
            }
    }

    public double[][] getStructure(){
        return this.structure;
    }

    // 사다리의 라인 (-)의 유무를 random 값으로 구성된 structure에서 base 값과의 크기 비교를 통해 생성합니다.
    public boolean isLadderLine(double[][] structure,int heightNum,int widthNum,double base){
        return structure[heightNum][widthNum] >= base;
    }

    //
    public void printLadder(double[][] structure){
        for(int i=0;i<structure.length;i++){
            System.out.print("|");
            for(int j=0;j<structure[0].length;j++){
                if(isLadderLine(structure,i,j,base))
                    System.out.print("-");
                else
                    System.out.print(" ");
                System.out.print("|");

            }
            System.out.println();
        }
    }

    // Array 구조를 생성하고, 2중 배열에 랜덤 데이터를 추가한 후, 랜덤값에 따라 - 모양을 넣어 사다리를 출력합니다.
    public void drawArrayLadder(){
        this.setArrayStructure();
        structure = this.getStructure();
        this.printLadder(structure);
    }
}
