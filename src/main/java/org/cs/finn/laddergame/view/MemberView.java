package org.cs.finn.laddergame.view;

import org.cs.finn.laddergame.domain.Member;
import org.cs.finn.laddergame.domain.Members;

public class MemberView {

    public void print(final Members members) {
        if (members == null) {
            throw new RuntimeException("Members is null!");
        }

        for (Member member : members.getMemberList()) {
            printMember(member);
        }
        System.out.println();
    }

    private void printMember(final Member member) {
        final int space = Member.WIDTH - member.toString().length();
        final int rightSpace = space / 2;
        final int leftSpace = rightSpace + (space & 0x1);

        System.out.print(' ');
        for (int i = 0; i < leftSpace; i++) {
            System.out.print(' ');
        }
        System.out.print(member);
        for (int i = 0; i < rightSpace; i++) {
            System.out.print(' ');
        }
    }
}
