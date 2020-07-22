import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static void main (String[] args) {
        int[][] arr = {{1, 3}, {-2,2}, {9, 10}, {-1, 1}};
        int[][] result = kClosest(arr, 3);

        for (int i = 0; i < result.length; i++)
            System.out.println("[ " + result[i][0] + ", " + result[i][1] + "]");
    }

    public static int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] distances = new int[n];

        for (int i = 0; i < n; i++) {
            distances[i] = getDistance(points[i]);
        }

        Arrays.sort(distances);
        int distK = distances[K-1]; // 0,1,2... until K-1 distances (shortest ones)

        int[][] result = new int[K][2];
        int t = 0;

        for (int i = 0; i < n; i++) {
            if (getDistance(points[i]) <= distK)
                result[t++] = points[i];
        }

        return result;
    }

    public static int getDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
