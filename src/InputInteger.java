public class InputInteger implements Input<Integer> {
    public InputInteger() {
    }

    public Integer getInputValue() {
        return scanner.nextInt();
    }
}