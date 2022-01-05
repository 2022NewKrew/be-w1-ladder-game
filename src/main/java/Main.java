public class Main {
    public static void main(String[] args){
        int numberPeople;
        int maxLadderHeight;

        numberPeople = InterfaceClass.getNumberPeople();
        maxLadderHeight = InterfaceClass.getLadderHeight();

        LadderClass ladder = new LadderClass(numberPeople, maxLadderHeight);
        ladder.assignLadderArray();
        ladder.printLadder();
    }

}
