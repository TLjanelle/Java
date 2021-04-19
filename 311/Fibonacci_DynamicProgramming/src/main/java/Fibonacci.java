import java.util.HashMap;

public class Fibonacci {
    public static long fib_recursive(int n){
        if (n<=1) {
            return n;
        }

        long newFib = fib_recursive(n -1) + fib_recursive(n - 2);
        return newFib;
    }

    public static long fib_memo(int n, HashMap<>)
}
