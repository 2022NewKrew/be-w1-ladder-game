package game.frontendapi.usertoapp;

public interface UserInput<T, V> {
    V askToUser(T message);
}
