package domain;

import java.util.ArrayList;

public class ParticipantList {
    private ArrayList<Participant> participantList;

    public ParticipantList(ArrayList<Participant> participantList){
        this.participantList = participantList;
    }

    public int getListSize(){
        return participantList.size();
    }

    public String getParticipantName(int index){
        return participantList.get(index).getName();
    }

    public int getParticipantOrder(String participantName){
        int resultidx = participantList.indexOf(new Participant(participantName));
        System.out.println(resultidx);
        return resultidx;
    }
}
