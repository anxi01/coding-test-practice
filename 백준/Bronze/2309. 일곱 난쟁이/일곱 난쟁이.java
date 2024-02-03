import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dwarfs = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
      dwarfs[i] = Integer.parseInt(br.readLine());
      sum += dwarfs[i];
    }

    Arrays.sort(dwarfs);

    int fake1 = 0, fake2 = 0;

    // 아홉 난쟁이의 총 합에서 가짜 난쟁이 두명을 찾아서 100일 경우를 찾는 방식
    // 브루트포스 알고리즘 : 가능한 모든 경우의 수를 모두 탐색
    for (int i = 0; i < dwarfs.length - 1; i++) {
      for (int j = i + 1; j < dwarfs.length; j++) {
        if (sum - (dwarfs[i] + dwarfs[j]) == 100) {
          fake1 = dwarfs[i];
          fake2 = dwarfs[j];
          break;
        }
      }
    }

    for (int dwarf : dwarfs) {
      if (dwarf == fake1 || dwarf == fake2)
        continue;
      System.out.println(dwarf);
    }

  }
}
