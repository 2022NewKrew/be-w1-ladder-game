package common.value;

public class Player {

    private final String name;

    public Player(String name) {
        if(!validateName(name)) {
            this.name = name.substring(0, 5);
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean validateName(String name) {
        if(name.length() > 5) {
            return false;
        }
        return true;
    }
}