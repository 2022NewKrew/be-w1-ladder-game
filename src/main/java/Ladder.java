public class Ladder {
    private Row[] rows;

    public Ladder(int people, int heightLadder) {
        rows = new Row[heightLadder];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(people);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Row row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}