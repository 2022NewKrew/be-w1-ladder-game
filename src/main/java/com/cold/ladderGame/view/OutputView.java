package com.cold.ladderGame.view;

import com.cold.ladderGame.domain.Ladder;
import com.cold.ladderGame.domain.Line;
import com.cold.ladderGame.utils.Pattern;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
  private StringBuffer outputString = new StringBuffer();

  public void printResult(InputView inputView, Ladder ladder){
    if(ladder.getResultIndex() == Pattern.IDX_WHEN_SELECTED_ALL)
      printAllResults(inputView.getUsers(), inputView.getResults(), ladder);
    else System.out.println(inputView.getResults().get(ladder.getResultIndex()));
  }

  private void printAllResults(List users, List results, Ladder ladder){
    outputString.append(Pattern.PRINT_LADDER_RESULT+"\n");
    Map<Integer, Integer> map = ladder.getResultMap();
    for (Integer key : map.keySet()) {
      outputString.append(users.get(key));
      outputString.append(" : ");
      outputString.append(results.get(map.get(key)) + "\n");
    }
    System.out.println(outputString);
  }

  public void printLadder(List users, List results, Ladder ladder) {
    outputString.append(Pattern.PRINT_LADDER_RESULT+"\n");
    printUsersResults(users, outputString);
    for(Line line : ladder.getResultLadder()) {
      printLine(line);
      outputString.append("\n");
    }
    printUsersResults(results, outputString);
    System.out.println(outputString);
  }

  private void printLine(Line line){
    for(Boolean element : line.getRow()){
      outputString.append(Pattern.VERTICAL_LINE);
      outputString.append(getBridge(element));
    }
    outputString.append(Pattern.VERTICAL_LINE);
  }

  private String getBridge(Boolean element){
    return element ? Pattern.EXISTS_BRIDGE : Pattern.NON_EXISTS_BRIDGE;
  }

  private void printUsersResults(List<String> list, StringBuffer outputString){
    for(String element : list){
      outputString.append(element);
      outputString.append(" ".repeat(Pattern.SPACE_BETWEEN_VERTICAL_LINES -element.length()));
    }
    outputString.append("\n");
  }

}
