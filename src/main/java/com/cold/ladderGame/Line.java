package com.cold.ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line {
  private Random random = new Random();
  private List<Boolean> row;

  public Line(int width){
    row = new ArrayList<>(width);
    for(int col = 0;col<width;col++){
      row.add(insertBridge(col));
    }
  }

  private boolean insertBridge(int col) {
    if (col > 0 && row.get(col - 1)) {
      return false;
    }
    return random.nextBoolean();
  }

  public StringBuffer printLine(StringBuffer outputString){
    for(Boolean bridge : row){
      outputString.append(Pattern.VERTICAL_LINE);
      outputString.append(getBridge(bridge));
    }
    outputString.append(Pattern.VERTICAL_LINE);
    return outputString;
  }

  private String getBridge(Boolean status) {
    return status ? Pattern.EXISTS_BRIDGE : Pattern.NON_EXISTS_BRIDGE;
  }
}
