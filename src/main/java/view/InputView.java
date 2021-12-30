package view;

import domain.Ladder;
import domain.Participant;
import domain.ParticipantList;
import domain.Result;
import domain.ResultList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public InputView(){
    }

    public ArrayList<Participant> getParticipants(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String str = sc.nextLine();
        String[] participants = str.split(",");
        ArrayList<Participant> participantArrayList = new ArrayList<>();
        for(String participantName:participants){
            participantArrayList.add(new Participant(participantName));
        }
        return participantArrayList;
    }

    public ArrayList<Result> getResultList(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String str = sc.nextLine();
        String[] results = str.split(",");
        ArrayList<Result> resultLists = new ArrayList<>();
        for(String result:results){
            resultLists.add(new Result(result));
        }
        return resultLists;
    }

    public int getHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.nextLine();
        return height;
    }

    public String getName(){
        System.out.println("결과를 보고 싶은 사람은?");
        String name = sc.nextLine();
        return name;
    }

    public void closeSc(){
        sc.close();
    }
}
