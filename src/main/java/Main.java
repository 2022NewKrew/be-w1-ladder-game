import controller.LadderController;

public class Main {
    public static void main(String[] args) {
        try {
            LadderController lc = new LadderController();
            lc.read();
            lc.show();
        } catch (Exception e){
          e.printStackTrace();
        }
    }
}

