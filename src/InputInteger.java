public class InputInteger implements Input<Integer> {
    private String inputMessage;

    public InputInteger(String inputMessage) {
        this.inputMessage = inputMessage;
        printInputMessage();
    }

    private void printInputMessage() {
        System.out.println(inputMessage);
    }

    public Integer getInputValue() {
        return scanner.nextInt();
    }
}