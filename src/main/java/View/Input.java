package View;

public class Input<T> {
    T value;
    InputCondition inputCondition;

    public Input() {
    }

    public Input(T value) {
        this.value = value;
    }

    public Input(InputCondition inputCondition) {
        this.inputCondition = inputCondition;
    }

    public Input(T value, InputCondition inputCondition) {
        this.value = value;
        this.inputCondition = inputCondition;
    }

    public boolean isValid() {
        return inputCondition.isValid(value);
    }

    public T getValue() {
        return value;
    }

    public InputCondition getInputCondition() {
        return inputCondition;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
