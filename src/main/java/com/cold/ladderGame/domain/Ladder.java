package com.cold.ladderGame.domain;

import com.cold.ladderGame.utils.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Ladder {
  private List<Line> resultLadder;
  private int resultIndex;
  private Map<Integer, Integer> resultMap;

  public Ladder(int width, int height){
    createLadder(width, height);
  }

  private void createLadder(int width, int height) {
    resultLadder = new ArrayList<>(height);
    for (int row = 0; row < height; row++) {
      resultLadder.add(new Line(width));
    }
  }

  public void getGameResult(int selected){
    int height = resultLadder.size();
    int width = resultLadder.get(0).getRow().size();
    if(selected == Pattern.IDX_WHEN_SELECTED_ALL) getAllResults(width, height);
    else getSpecificUserResult(selected, height);
  }

  private void getAllResults(int width, int height){
    resultMap = new HashMap<>();
    for(int col = 0;col<width+1;col++){
      getSpecificUserResult(col, height);
      resultMap.put(col, resultIndex);
    }
    resultIndex = Pattern.IDX_WHEN_SELECTED_ALL;
  }

  private void getSpecificUserResult(int current, int height){
    for(int row = 0;row<height;row++){
      current = resultLadder.get(row).getLineResult(current);
    }
    resultIndex = current;
  }
}
