public enum LineStatus {
    SADARI_LINE(()-> System.out.print("-")),
    EMPTY(()-> System.out.print(" ")),
    BORDER(() -> System.out.print("|")),
    END(System.out::println);

    private final Runnable printStrategy;

    LineStatus(Runnable printStrategy) {
        this.printStrategy = printStrategy;
    }

    public static boolean isBorder(int columnNumberOfRow) {
        return columnNumberOfRow % 2 == 0;
    }

    public void printStatus() {
        printStrategy.run();
    }
}
