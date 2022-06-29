package question1_10;

/**
 * 题目描述：两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 */
public class Question1 {

    public static void println(){
        Question1 question1 = new Question1();
        int[] nums = new int[]{3,3};
        int[] result = question1.twoSum1(nums,6);
        for(int a:result)
            System.out.print(a+" ");
    }

    public static void main(String[] args) {
        println();
    }

    /**
     * 方式一，双重循环，时间复杂度为0(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
