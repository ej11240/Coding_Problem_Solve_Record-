import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count= Integer.parseInt(bufferedReader.readLine());
        dp = new long[100];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=2;

        while (count-->0){
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 5; i <= n; i++) {

                dp[i] = dp[i - 1] + dp[i - 5];
            }
            System.out.println(dp[n-1]);
//            count--;
        }
    }
}
