package com.cold.ladderGame.domain;

import com.cold.ladderGame.utils.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Line {
  private Random random = new Random();
  private List<Boolean> row;
  int width;

  public Line(int width){
    this.width = width;
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

  public int getLineResult(int cur){
    if(cur == width){ //마지막 줄일때
      return getLastColResult();
    }
    if(cur == 0){ //첫째 줄일 때
      return getFirstColResult();
    }
    return getMidColResult(cur); // 중간 줄일 때
  }

  private int getLastColResult(){
    return row.get(width-1) ? width-1 : width;
  }

  private int getFirstColResult(){
    return row.get(0) ? 1 : 0;
  }

  private int getMidColResult(int cur){
    if(row.get(cur)) return cur+1;
    if(row.get(cur-1)) return cur-1;
    return cur;
  }
}
