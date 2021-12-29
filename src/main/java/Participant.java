public class Participant {
    private final String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return String.format("%-6s", name);
    }
}
