package com.kakao.leo.domain.ladder;

import com.kakao.leo.view.in.Drawable;
import com.kakao.leo.view.out.WriteManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ladder, 사다리 좌표를 보관 및 생성한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class Ladder implements Drawable {

  private final List<Floor> floors;

  private Ladder(int width, int height) throws Exception {
    this.floors = new ArrayList<>();
    setupFloors(width, height);
  }


  public static Ladder of(int width, int height) throws Exception {
    return new Ladder(width, height);
  }


  public void drawWith(WriteManager writeManager) throws IOException {
    writeManager.draw(toString());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    floors.forEach(floor -> sb.append(floor).append('\n'));
    return sb.toString();
  }


  private void setupFloors(int width, int height) throws Exception {
    for (int i = 0; i < height; i++) {
      floors.add(Floor.create(width));
    }
  }

}

