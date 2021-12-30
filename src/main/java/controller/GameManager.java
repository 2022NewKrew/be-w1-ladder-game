package controller;

import domain.ParticipantList;
import domain.ResultList;
import view.InputView;
import view.OutputView;

public class GameManager {
    private InputView inputView;
    private OutputView outputView;
    private ParticipantList participantList;

    public GameManager(InputView inputView, OutputView outputView, ParticipantList participantList){
        this.inputView = inputView;
        this.outputView = outputView;
        this.participantList = participantList;
    }

    public void play(){
        while(getResult()){};
        System.out.println("게임을 종료합니다.");
        inputView.closeSc();
    }

    public Boolean getResult(){
        String participantName = inputView.getName();
        if(participantName.equals("춘식이")){
            return false;
        }

        if(participantName.equals("all")){
            printResultAll();
            return true;
        }

        printResult(participantName);
        return true;
    }

    public void printResultAll(){
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0 ; i < participantList.getListSize(); i++){
            outputView.showResult(i);
        }
    }

    public void printResult(String participantName){
        System.out.println();
        System.out.println("실행 결과");
        int participantOrder = participantList.getParticipantOrder(participantName);
        outputView.showResult(participantOrder);
    }

}
