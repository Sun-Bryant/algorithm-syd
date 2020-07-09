package niuke;

public class Test {

    public static int solve (int n, int m) {
        if (n >= m) {
            return n - m;
        } else {
            int count = 0;
            if (n != 1){
                int temp = n * n;
                while (temp < m) {
                    count++;
                    temp = temp * temp;
                }
                for (int i = 0; i < count; i++) {
                    n = n * n;
                }
                return m - n + count;
            } else {
                n = n + 1;

                int temp = n * n;
                while (temp < m) {
                    count++;
                    temp = temp * temp;
                }
                for (int i = 0; i < count; i++) {
                    n = n * n;
                }
                return m - n + count + 1;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(solve(1,10));
    }
}
