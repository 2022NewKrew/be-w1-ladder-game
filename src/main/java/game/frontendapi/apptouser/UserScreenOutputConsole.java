package game.frontendapi.apptouser;

public class UserScreenOutputConsole implements UserScreenOutput<String>{
    @Override
    public void output(String contents) {
        System.out.println(contents);
    }
}
