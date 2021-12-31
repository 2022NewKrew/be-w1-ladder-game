package view;

import domain.Name;
import domain.NameRepository;

public class ResultView {

    private NameRepository nameRepository;
    private NameRepository results;

    public ResultView(NameRepository nameRepository, NameRepository results) {
        this.nameRepository = nameRepository;
        this.results = results;
    }

    public void viewOne(String s){
        int idx = nameRepository.matchName(s);
        if(idx == -1){
            System.out.println("없는 이름입니다");
            return;
        }
        System.out.println("실행 결과");
        System.out.println(results.getNameList().get(idx).getName());
    }

    public void viewAll(){
        System.out.println("실행 결과");
        for(int i=0; i<results.getLength(); i++){
            System.out.println(nameRepository.getNameList().get(i).getName() + " : " +
                    results.getNameList().get(i).getName());
        }
    }

    public void terminate(){
        System.out.println("게임을 종료합니다.");
    }

}
