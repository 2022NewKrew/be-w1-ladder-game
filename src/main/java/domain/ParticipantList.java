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
        //TODO 2depth : 아래 TODO 방법으로 고쳐야함
        for(int i = 0 ; i < participantList.size(); i++){
            if(participantList.get(i).getName().equals(new Participant(participantName).getName()))
                return i;
        }
        return -1;
        //TODO 이부분 고쳐야함 indexOf왜 안되지..?
//        return participantList.indexOf(new Participant(participantName));
    }
}
