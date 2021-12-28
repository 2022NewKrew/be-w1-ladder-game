public class StandardOutDisplayLadder implements DisplayLadder{
    private Ladder ladder;

    @Override
    public void display() {
        if (ladder == null) {
            throw new RuntimeException(
                    "You must set the property ladder of class: "
                    + StandardOutDisplayLadder.class.getName()
            );
        }

        System.out.println(ladder);
    }

    @Override
    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
