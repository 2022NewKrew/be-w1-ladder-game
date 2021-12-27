import java.util.ArrayList;

public class MakeSadari {

    public static ArrayList<String> makeNewSadari(int people, int height) {
        ArrayList<String> sadari = new ArrayList<String>();
        String s;
        double randNum;
        for(int i=0;i<height;i++) {
            s = "";
            for(int j=1;j<people;j++) {
                s += '|';
                // 0 ~ 1 사이의 난수를 가지고 0.5보다 크다면 공백, 0.5보다 작다면 -를 넣는다
                randNum = Math.random();
                if(randNum >= 0.5)
                    s += ' ';
                else
                    s += '-';
            }
            s += '|';
            sadari.add(s);
        }
        return sadari;
    }

    public static void printSadari(ArrayList<String> sadari) {
        for(String s : sadari) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> sadari = makeNewSadari(3, 5);
        printSadari(sadari);
    }
}
