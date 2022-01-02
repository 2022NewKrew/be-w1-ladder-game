package main.java.util;

public class Util {

    public static String centerString(int totalLength, String originStr) {
        StringBuilder sb = new StringBuilder();
        int diffLength = totalLength - originStr.length();
        int prefixCount = (int) (diffLength / 2);
        int suffixCount = diffLength - prefixCount;

        sb.append(" ".repeat(prefixCount));
        sb.append(originStr);
        sb.append(" ".repeat(suffixCount));
        return sb.toString();
    }
}
