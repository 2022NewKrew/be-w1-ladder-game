package main.java;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.inputUser();
        engine.inputLadder();
        engine.createLadders();
        engine.printUsers();
        engine.showLadders();
    }
}
