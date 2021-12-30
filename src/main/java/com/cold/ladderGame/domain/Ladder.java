package com.cold.ladderGame.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ladder {
  private List<Line> resultLadder;

  public Ladder(int width, int height){
    createLadder(width, height);
  }

  private void createLadder(int width, int height) {
    resultLadder = new ArrayList<>(height);
    for (int row = 0; row < height; row++) {
      resultLadder.add(new Line(width));
    }
  }
}
