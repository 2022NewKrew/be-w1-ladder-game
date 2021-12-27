public class Ladder {
    int participants;
    int height;

    public Ladder(int participants, int height){
        this.participants = participants;
        this.height  = height;
    }

    public void print(){
        for(int i=0; i<height; i++){
            for(int j = 0; j<participants-1; j++){
                System.out.print("|");
                if (Math.random() <= 0.5) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }
}

