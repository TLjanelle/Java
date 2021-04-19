package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class DP_Exercise {
    /**
     * This method should be recursive.
     * The method should implement the algorithm we talked in the class.
     *
     * @param faceValues face values of coins.
     * @param money the target money.
     * @return the minimum number of coins that equal to money
     */
    public static int recursiveChange(int[] faceValues, int money) {
        // if money == 0: return 0
        if (money == 0) return 0;

        // if money < 0 ; return -1
        if (money < 0) return -1;

        // int minCount = -1;
        int minCount = -1;

        // for each faceValue in faceValues:
        for (int faceValue : faceValues){
            // int count = recursiveChange(faceValues, money-faceValue)
            int count = recursiveChange(faceValues, money - faceValue);
            // if count is valid and smaller than minCount: update the minCount
            if (minCount == -1) {
                minCount = count;
            }
            else if (count != -1 && count < minCount) {
                minCount = count;
            }
        }
        // if minCount is still -1: return -1
        if (minCount == -1) return -1;

        // return minCount+1
        return minCount + 1;
    }

    /**
     * This method should not have any recursive call and use memoization.
     * *
     * @param faceValues face values of coins.
     * @param money the target money.
     * @return the minimum number of coins that equal to money
     */
    public static int memoChange(int[] faceValues, int money, HashMap<Integer,Integer> memo) {
        if (money <= 0) return money;

        if (memo.containsKey(money)) return memo.get(money);

        int minCount = recursiveChange(faceValues, money);

        memo.put(money, minCount);

        return minCount;
    }

    /**
     * This method should not have any recursive call and use tabulation.
     * *
     * @param faceValues face values of coins.
     * @param money the target money.
     * @return the minimum number of coins that equal to money
     */
    public static int tabChange(int[] faceValues, int money) {
        // for int i from 0 to tab.length-1;
        // if tab[i] is -1: continue
        // for each faceValue in faceValues
        // if i + faceValue in inbound
        // if tab[i + faceValue] is -1 or tab[i]+1<tab[i+faceValue]
        // tab [i + faceValue] = tab[i]+1

        int[] tab = new int[money + 1];
        Arrays.fill(tab, -1);
        tab[0] = 0;

        for (int i = 0; i < tab.length - 1; i++){
            if (tab[i] == -1) continue;
            for (int faceValue : faceValues) {
                if (i + faceValue <= tab.length-1 ) {
                    if (tab[i + faceValue] == -1 || tab[i] + 1 < tab[i + faceValue]) {
                        tab[i + faceValue] = tab[i] + 1;
                    }
                }
            }
        }
        return tab[money];
    }
}
