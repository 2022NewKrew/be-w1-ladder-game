package com.cold.ladderGame.domain;

import com.cold.ladderGame.utils.Pattern;
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
}
