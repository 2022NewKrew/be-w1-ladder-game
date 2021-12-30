package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Member;

public class MemberView {

    public void print(final Member member) {
        if (member == null) {
            throw new RuntimeException("Ladder is null!");
        }

        for (String m : member.getMemberList()) {
            printMember(m);
        }
        System.out.println();
    }

    private void printMember(final String m) {
        final int space = Member.WIDTH - m.length();
        final int rightSpace = space / 2;
        final int leftSpace = rightSpace + (space & 0x1);

        System.out.print(' ');
        for (int i = 0; i < leftSpace; i++) {
            System.out.print(' ');
        }
        System.out.print(m);
        for (int i = 0; i < rightSpace; i++) {
            System.out.print(' ');
        }
    }
}
