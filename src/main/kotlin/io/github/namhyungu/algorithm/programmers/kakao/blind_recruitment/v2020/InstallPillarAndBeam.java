package io.github.namhyungu.algorithm.programmers.kakao.blind_recruitment.v2020;

import java.util.ArrayList;
import java.util.List;

public class InstallPillarAndBeam {
  private static final int PILLAR = 0;

  private int N;
  private boolean[][] pillars;
  private boolean[][] beams;

  public int[][] solution(int n, int[][] build_frame) {
    List<int[]> answer = new ArrayList<>();
    N = n;
    pillars = new boolean[n + 3][n + 3];
    beams = new boolean[n + 3][n + 3];

    for (int[] frame : build_frame) {
      int x = frame[0] + 1;
      int y = frame[1] + 1;
      int type = frame[2];
      boolean isInstall = frame[3] == 1;

      if (type == PILLAR) {
        if (isInstall && validPillar(x, y)) {
          pillars[y][x] = true;
        } else if (!isInstall && validRemove(type, x, y)) {
          pillars[y][x] = false;
        }
      } else {
        if (isInstall && validBeam(x, y)) {
          beams[y][x] = true;
        } else if (!isInstall && validRemove(type, x, y)) {
          beams[y][x] = false;
        }
      }
    }

    for (int x = 1; x <= n + 1; x++) {
      for (int y = 1; y <= n + 1; y++) {
        if (pillars[y][x]) answer.add(new int[] {x - 1, y - 1, 0});
        if (beams[y][x]) answer.add(new int[] {x - 1, y - 1, 1});
      }
    }
    return answer.toArray(new int[0][]);
  }

  private boolean validPillar(int x, int y) {
    return y == 1 || beams[y][x - 1] || beams[y][x] || pillars[y - 1][x];
  }

  private boolean validBeam(int x, int y) {
    return (pillars[y - 1][x] || pillars[y - 1][x + 1]) || (beams[y][x - 1] && beams[y][x + 1]);
  }

  private boolean validRemove(int type, int x, int y) {
    boolean isValid = true;

    if (type == PILLAR) {
      pillars[y][x] = false;
    } else {
      beams[y][x] = false;
    }

    for (int i = 1; i <= N + 1; i++) {
      for (int j = 1; j <= N + 1; j++) {
        if (pillars[j][i] && !validPillar(i, j)) {
          isValid = false;
          break;
        }
        if (beams[j][i] && !validBeam(i, j)) {
          isValid = false;
          break;
        }
      }
    }

    if (type == PILLAR) {
      pillars[y][x] = true;
    } else {
      beams[y][x] = true;
    }
    return isValid;
  }
}
