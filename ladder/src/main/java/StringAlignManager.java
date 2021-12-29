public class StringAlignManager {
    public static void alignCenter(int maxLength, int spaceBetween, String message){
        int messageLength = message.length();

        int rightBlankCount = (int)((maxLength - messageLength) / 2);

        int leftBlankCount = maxLength - messageLength - rightBlankCount;
        StringBuilder leftBlank = new StringBuilder();
        leftBlank.append(" ".repeat(Math.max(0, leftBlankCount+spaceBetween)));

        System.out.print(leftBlank
                .append(message)
                .append(" ".repeat(Math.max(0, rightBlankCount))));
    }
}
