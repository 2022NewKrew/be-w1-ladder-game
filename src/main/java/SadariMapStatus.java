public enum SadariMapStatus {
    SADARI_BORDER(() -> System.out.print("|")),
    SADARI_LINE(()-> System.out.print("-----")),
    EMPTY(()-> System.out.print("     ")),
    END(System.out::println);

    private final Runnable printStrategy;

    SadariMapStatus(Runnable printStrategy) {
        this.printStrategy = printStrategy;
    }

    public static boolean isBorder(int columnNumberOfRow) {
        return columnNumberOfRow % 2 == 0;
    }

    public void printStatus() {
        printStrategy.run();
    }
}
