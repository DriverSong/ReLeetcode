import java.lang.reflect.Array;

public class MinCost {
    public int minCost(String s, int[] cost){
        int costMax = cost[0];
        int costAll = 0;
        if(s.length() <= 1) return 0;
        char[] chars = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            if(chars[i] != chars[i - 1]){
                costMax = cost[i];
                continue;
            }
            if (cost[i] >= costMax){
                costAll += costMax;
                costMax = cost[i];
            }else {
                costAll += cost[i];
            }
        }
        return costAll;
    }
}
