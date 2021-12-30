package ladder.view;

import ladder.domain.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LadderGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Ladder ladder;
    private Participants participants;
    private Results results;

    public void start() {

        this.participants = new Participants(inputParticipants());
        this.results = new Results(inputResults());

        if (participants.size() != results.size())
            throw new IllegalArgumentException("참여자 수 만큼 결과를 입력하세요");

        this.ladder = new Ladder(participants.size(), inputHeights());

        printLadder();

        do{
            System.out.println("\n결과를 보고 싶은 사람은?");
        }while(askResult());

    }

    public boolean askResult() {
        String question = inputString();

        if (question.equals("all")){
            printResultAll();
            return true;
        }
        if (question.equals("춘식이")){
            System.out.println("게임을 종료합니다.");
            return false;
        }
        printResult(question);
        return true;
    }

    public void printResult(String participant){
        System.out.println("실행 결과");
        int startIdx = participants.indexOf(participant);
        if (startIdx == -1){
            System.out.println("이름을 다시 입력하세요");
            return;
        }
        int resultIdx = ladder.travel(startIdx);
        System.out.println(results.get(resultIdx));
    }

    public void printResultAll(){
        System.out.println("실행 결과");
        for(String participant : participants.getParticipants()){
            int startIdx = participants.indexOf(participant);
            System.out.println(participant + " : " +results.get(ladder.travel(startIdx)));
        }
    }

    public void printLadder() {
        System.out.println(participants);
        System.out.print(ladder);
        System.out.println(results);
    }

    private List<String> inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return inputStringsByComma();
    }

    private List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return inputStringsByComma();
    }

    private String inputString() {
        return SCANNER.nextLine();
    }

    private int inputHeights() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    private List<String> inputStringsByComma() {
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(SCANNER.nextLine(), ",");
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }

    private class Participants {
        private final List<String> participants;

        public Participants(List<String> participants) {
            this.participants = participants;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (String participant : participants) {
                builder.append(StringUtil.centerAligned(participant, 5));
                builder.append(" ");
            }
            return builder.toString();
        }

        public List<String> getParticipants(){
            return this.participants;
        }

        public int size() {
            return this.participants.size();
        }

        public int indexOf(String participant){
            return participants.indexOf(participant);
        }



    }

    private class Results{
        private final List<String> results;
        public Results(List<String> results){
            this.results = results;
        }

        public int size(){
            return this.results.size();
        }

        public String get(int i){
            return results.get(i);
        }

        public String toString(){
            StringBuilder builder = new StringBuilder();
            for (String result : results) {
                builder.append(StringUtil.centerAligned(result, 5));
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
