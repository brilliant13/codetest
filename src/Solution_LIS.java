import java.util.Arrays;

public class Solution_LIS {

    private static int lis(int[] nums) {
        int n = nums.length;
        //dp[i]는 nums[i]를 마지막으로 하는 LIS의 길이를 저장하는 배열
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //num[i]와 num[j]를 비교하여, nums[i]가 더 큰 경우메만 처리
                if (nums[i] > nums[j]) {
                    //nums[i]를 이용하여 만든 부분 수열의 길이와 nums[j]를 이용하여 만든 부분 수열의 길이 +1 중 최댓값을 저장
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        //dp 배열에서 최댓값을 찾아 최장 증가 부분수열의 길이를 반환
        return Arrays.stream(dp).max().orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(lis(new int[]{1, 4, 2, 3, 1, 5, 7, 3}));
        System.out.println(lis(new int[]{3, 2, 1}));
    }

}