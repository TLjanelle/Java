package main.java;

import java.util.HashMap;

public class GridTraveler {
    public static int gridTravel_recursive(int m, int n) {
        if (m == 1 || n ==  1) {
            return 1;
        }

        int downWays = gridTravel_recursive(m-1,n);
        int rightWays = gridTravel_recursive(m, n-1);
        return downWays + rightWays;
    }

    public static int gridTravel_memo(int m, int n, HashMap<String, Integer> memo) {
        if (m == 1 || n ==  1) {
            return 1;
        }

        if (memo.containsKey(m + "," + n)) return memo.get(m + "," + n);

        int downWays = gridTravel_recursive(m-1,n);
        int rightWays = gridTravel_recursive(m, n-1);

        memo.put(m + "," + n, downWays + rightWays);
        return downWays + rightWays;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        int rec_ways= gridTravel_recursive(m, n);
        System.out.println(m + "x" + n + ":" + rec_ways);

        int recWaysMemo = gridTravel_memo(m, n, memo.get());
        System.out.println(m + "x" + n + ":" + recWaysMemo);
    }
}
