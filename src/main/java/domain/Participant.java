package domain;

public class Participant {
    private String name;

    public Participant(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Participant)) return false;
        Participant other = (Participant) o;
        return this.getName() == other.getName();
    }
}
