import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxNumEdgesToRemove {
    ArrayList<Integer> [][] mapEgdes;
    boolean[] isVisited;
    int count;

    //链表数组需要将每一个元素初始化
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        mapEgdes = new ArrayList[3][n+1];
        isVisited = new boolean[n + 1];
        Arrays.fill(isVisited, false);

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < n + 1; j++){
                mapEgdes[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < edges.length; i++){
            mapEgdes[edges[i][0] - 1][edges[i][1]].add(edges[i][2]);
            mapEgdes[edges[i][0] - 1][edges[i][2]].add(edges[i][1]);
        }

        count = 0;
        dfs(1, 0);
        if(count < n) return -1;

        Arrays.fill(isVisited, false);
        count = 0;
        dfs(1, 1);
        if(count < n) return -1;

        Arrays.fill(isVisited, false);
        int edgeCnt = 0;
        for(int i = 1; i < n + 1; i++){
            count = 0;
            while(isVisited[i] == false){
                dfs(i, 2);
                edgeCnt += count - 1;
            }
        }
        return edges.length + edgeCnt + 2 - 2 * n;
    }

    private void dfs (int node, int mode){
        if(isVisited[node] != false) return;
        count++;
        isVisited[node] = true;

        for (int index : mapEgdes[2][node]){
            if(count == isVisited.length - 1){
                return;
            }
            if(isVisited[index] == false){
                dfs(index, mode);
            }
        }

        if(mode != 2){
            if (count == isVisited.length - 1){
                return;
            }
            for (int index : mapEgdes[mode][node]){
                if(isVisited[index] == false){
                    dfs(index, mode);
                }
            }
        }
        return;
    }

    public static void main(String[] args){
        MaxNumEdgesToRemove object = new MaxNumEdgesToRemove();
        System.out.println(object.maxNumEdgesToRemove(4, new int[][]{{3,1,2}, {3,2,3}, {1,1,3},{1,2,4}, {1,1,2},{2,3,4}}));
    }
}
