package com.kakaocorp.ladder.common;

public class Strings {

    @SuppressWarnings("StringRepeatCanBeUsed")
    public static String pad(String s, int length) {
        StringBuilder sb = new StringBuilder();
        int padCount = length - s.length();
        int padStart = padCount / 2;
        int padEnd = padCount - padStart;
        for (int i = 0; i < padStart; i++) {
            sb.append(' ');
        }
        sb.append(s);
        for (int i = 0; i < padEnd; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
