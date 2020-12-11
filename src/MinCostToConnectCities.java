import java.util.*;

public class MinCostToConnectCities {

    public static void main(String[] args) {
        int[][] connections = {{1,2,5}, {1,3,6}, {2,3,1}};
        System.out.println(minimumCost(3, connections));
    }

    public static int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int[] parents = new int[N + 1];
        Arrays.fill(parents, -1);
        int count = N;
        int sum = 0;

        for (int[] connection: connections) {
            int pA = find(parents, connection[0]);
            int pB = find(parents, connection[1]);

            if (pA == pB) {
                continue;
            }
            parents[pA] = pB;
            sum += connection[2];
            count--;
        }

        return count == 1 ? sum : -1;
    }

    static int find(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        parents[i] = find(parents, parents[i]);
        return parents[i];
    }
}