import java.util.Arrays;

class Solution {

  private static class Data {
    int value, idx;

    public Data(int value, int idx) {
      this.value = value;
      this.idx = idx;
    }
  }

  public int[] solution(int[] array) {
    Data[] data = new Data[array.length];

    for (int i = 0; i < array.length; i++) {
      data[i] = new Data(array[i], i);
    }

    Arrays.sort(data, (o1, o2) -> Integer.compare(o2.value, o1.value));

    return new int[]{data[0].value, data[0].idx};
  }
}
