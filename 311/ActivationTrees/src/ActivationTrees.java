public class ActivationTrees {
    public static int trib(int n){
        if(n == 0 || n == 1)
            return n;

        if(n == 2){
            int trib1 = trib(1);
            return 2*trib1;
        }

        int trib2 = trib(n-1);
        int trib3 = trib(n-2);
        int trib4 = trib(n-3);

        System.out.println("n: " + n);
        System.out.println("trib2: " + (trib2));
        System.out.println("trib3: " + (trib3));
        System.out.println("trib4: " + (trib4));

        int temp = trib2 + trib3 + trib4;
        System.out.println("trib2 + trib3 + trib4: " + temp);

        return trib2 + trib3 + trib4;
    }

    public static void main(String[] args) {
        int n = 4;
        trib(n);
    }
}
