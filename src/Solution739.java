/*
739.每日温度
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {  // 如果下一天就比当前温度高
                answer[i] = 1;
            } else {
                if (answer[i + 1] == 0) {  // 如果下一天的温度小于等于当天的温度，并且没有比下一天高的温度了
                    answer[i] = 0;
                } else {
                    int j = i + 1;
                    while (answer[j] != 0) {  // 有比下一天高的温度
                        j += answer[j];
                        if (temperatures[j] > temperatures[i]) {
                            answer[i] = j - i;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
