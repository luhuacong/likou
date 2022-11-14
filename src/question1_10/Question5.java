package question1_10;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Question5 {

    /**
     * 中心扩散法
     * 除了中心扩散法，还有动态规划等解法
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int maxLen = 0;
        int maxLeft = 0;    //因为我们最后要返回的是具体子串，而不是长度，因此，还需要记录一下 maxLen 时的起始位置（maxLen）
        int sLen = s.length();
        if(s == null || "".equals(s)){
            return s;
        }
        for(int i=0;i<sLen;i++){
            int len = 1;
            int left = i-1;
             int right = i+1;
            while(left>=0 && s.charAt(i) == s.charAt(left)){
                left--;
                len++;
            }

            while(right<sLen && s.charAt(i) == s.charAt(right)){
                right++;
                len++;
            }

            while(left>=0 && right<sLen && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len += 2;
            }
            if(len>maxLen){
                maxLen = len;
                maxLeft = left;
            }
        }

        return s.substring(maxLeft+1,maxLeft+maxLen+1);
    }

    //一开始自己尝试写的没通过的方法，没有考虑到旁边两个元素相等的情况
//    public String longestPalindrome(String s) {
//
//        char[] chars = s.toCharArray();
//        if(chars.length==1) return s;
//        if(chars.length == 2 && chars[0] == chars[1]){
//            return s;
//        }else if(chars.length == 2 && chars[0] != chars[1]){
//            return s.substring(0,1);
//        }
//        String sameStr = "";
//        String maxStr = "";
//        for(int i=1;i<chars.length;i++){
//            int right=i+1;
//            int left = i-1;
//            sameStr = calcuSameStr(chars,left,right);
//
//            //元素的前后元素相等时
//            while(left>=0 && right<=(chars.length-1) && chars[left]==chars[right]){
//                left--;
//                right++;
//            }
//            //最后要把left和right指向回文的最左端和最右端
//            left++;
//            right--;
//            //本轮循环的最长字符串
//            String thisMaxLenStr = sameStr.length()>=(right-left+1) ? sameStr : s.substring(left,right+1);
//            maxStr = maxStr.length() > thisMaxLenStr.length() ? maxStr : thisMaxLenStr;
//        }
//        return maxStr;
//    }
//
//    //返回最近连续相同的元素个数
//    public String calcuSameStr(char[] chars,int left,int right){
//        StringBuffer buffer = new StringBuffer();
//        int count = 1;      //默认长度为1
//        int location = left+1;  //当前位置
//        buffer.append(chars[location]);
//
//
//        while(left>=0 && chars[left]==chars[location]){
//                count++;
//                left--;
//                buffer.append(chars[location]);
//            }
//
//            //如果right小于数组的最大值
//            while(right<(chars.length-1) && chars[right] == chars[location]){
//                count++;
//                right++;
//                buffer.append(chars[location]);
//            }
//        return buffer.toString();
//    }

    public static void main(String[] args) {
        //System.out.println("babad".substring(0,5));
        Question5 question5 = new Question5();
        String huiwen = question5.longestPalindrome("babad");
        System.out.println(huiwen);
    }
}
