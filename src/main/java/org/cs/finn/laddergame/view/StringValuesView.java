package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.AbstractStringValue;
import org.cs.finn.laddergame.domain.AbstractStringValues;

public class StringValuesView {

    public void print(final AbstractStringValues<? extends AbstractStringValue> values, final int width) {
        if (width <= 0) {
            throw new RuntimeException("width is not positive integer! - " + width);
        }
        if (values == null) {
            throw new RuntimeException("Values is null!");
        }

        for (AbstractStringValue value : values.getList()) {
            printMember(value, width);
        }
        System.out.println();
    }

    private void printMember(final AbstractStringValue value, final int width) {
        final int space = width - value.toString().length();
        final int rightSpace = space / 2;
        final int leftSpace = rightSpace + (space & 0x1);

        System.out.print(' ');
        for (int i = 0; i < leftSpace; i++) {
            System.out.print(' ');
        }
        System.out.print(value);
        for (int i = 0; i < rightSpace; i++) {
            System.out.print(' ');
        }
    }

    public void printTwoValue(final AbstractStringValue value1, final AbstractStringValue value2) {
        System.out.println(value1 + " : " + value2);
    }
}
