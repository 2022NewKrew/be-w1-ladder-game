public class Input<T> {
    T value;

    public Input(){

    }

    public Input(T value){
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
