package view;

public class StringAlignManager {
    public static void alignCenter(int maxLength, int spaceBetween, String message){
        int messageLength = message.length();

        int rightBlankCount = (int)((maxLength - messageLength) / 2);
        int leftBlankCount = maxLength - messageLength - rightBlankCount;

        System.out.print(" ".repeat(leftBlankCount+spaceBetween) + message + " ".repeat(rightBlankCount));
    }
}
