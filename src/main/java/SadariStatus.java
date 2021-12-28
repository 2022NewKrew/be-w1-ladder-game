public enum SadariStatus {
    LINE(()-> System.out.print("-")),
    EMPTY(()-> System.out.print(" ")),
    BORDER(() -> System.out.print("|"));

    private final Runnable printStrategy;

    SadariStatus(Runnable printStrategy) {
        this.printStrategy = printStrategy;
    }

    public static boolean isBorder(int columnNumberOfRow) {
        return columnNumberOfRow % 2 == 0;
    }

    public void printStatus() {
        printStrategy.run();
    }
}
