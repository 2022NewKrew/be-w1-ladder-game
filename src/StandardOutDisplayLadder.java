public class StandardOutDisplayLadder implements DisplayLadder{
    @Override
    public void display(Ladder ladder) {
        if (ladder == null) {
            throw new RuntimeException(
                    "You must set the property ladder of class: "
                    + StandardOutDisplayLadder.class.getName()
            );
        }

        System.out.println(ladder);
    }
}
