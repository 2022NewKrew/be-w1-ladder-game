package main;
import java.util.*;

public class Ladder {
    private int height;
    private int numOfPeople;
    private double[][] structure;

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

    public void setStructure(){
        this.structure = new double[height][numOfPeople-1];
        for(int i=0;i<height;i++)
            for(int j=0;j<numOfPeople-1;j++){
                this.structure[i][j] = Math.random();
            }
    }

    public double[][] getStructure(){
        return this.structure;
    }

    public boolean isLadderLine(double[][] structure,int heightNum,int widthNum){
        if(structure[heightNum][widthNum]>=0.5)
            return true;
        else
            return false;
    }

    public void printLadder(double[][] structure){
        for(int i=0;i<structure.length;i++){
            System.out.print("|");
            for(int j=0;j<structure[0].length;j++){
                if(isLadderLine(structure,i,j))
                    System.out.print("-");
                else
                    System.out.print(" ");
                System.out.print("|");

            }
            System.out.println();
        }
    }

    public void drawLadder(){
        this.setStructure();
        structure = this.getStructure();
        this.printLadder(structure);
    }
}
