package question1_10;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question4 {

    /**
     * 思路：
     * 定义一个新的数组，同时开始遍历两个数组，用变量i,j分别标识遍历到数组nums1，nums2的下标，比较nums1[i]和nums2[j]的值，把较小的值放进新的数组，然后把i或j加一，
     * 继续循环比较。需要注意的是，当一个数组遍历完后，需要检查另一数组是否遍历完了，如果还没遍历完，则把剩余的元素按顺序放到新数组
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        int[] longNums = nums1Len>=nums2Len ? nums1 : nums2;
        int[] shortNums = nums1Len < nums2Len ? nums1 : nums2;

        int[] nums3 = new int[nums1Len+nums2Len];
        int maxLen = Math.max(nums1Len,nums2Len);
        int minLen = Math.min(nums1Len,nums2Len);
        int i = 0;  //i是短的数组的下标
        int j = 0; //j是长的数组的下标
        int index = 0;
        while(i<minLen || j<maxLen){
            //如果短的数组已经遍历完，则直接处理长的数组
            if(i == minLen && j<maxLen){
                nums3[index++] = longNums[j++];
                continue;
            }

            //如果长的数组已经遍历完，则处理短的数组剩余的元素（剩余的元素比长数组的任一元素都大）
            if(j == maxLen && i<minLen){
                nums3[index++] = shortNums[i++];
                continue;
            }

            if(shortNums[i] < longNums[j]){
                nums3[index++] = shortNums[i];
                 i++;

            }else if(shortNums[i] > longNums[j]){
                nums3[index++] = longNums[j];
                j++;
            }else{
                nums3[index++] = shortNums[i];
                nums3[index++] = longNums[j];
                i++;
                j++;
            }
        }
        if((nums1Len+nums2Len)%2==0){
            int mid = (nums1Len+nums2Len)/2-1;
            return (nums3[mid] + nums3[mid+1])/2.0;
        }else{
            return nums3[(nums1Len+nums2Len)/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
