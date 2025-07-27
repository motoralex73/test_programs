import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                if (countZero > 0) {
                    nums[i-countZero] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
