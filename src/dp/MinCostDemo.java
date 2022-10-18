package dp;

public class MinCostDemo {


    public static void main(String[] args) {
        MinCostDemo demo = new MinCostDemo();
        int[][] array = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(demo.minCost(array));
    }

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int tempA = a;
            int tempB = b;
            int tempC = c;
            a = Math.min(tempB, tempC) + costs[i][0];
            b = Math.min(tempA, tempC) + costs[i][1];
            c = Math.min(tempA, tempB) + costs[i][2];
        }

        return Math.min(a, Math.min(b, c));
    }
}
