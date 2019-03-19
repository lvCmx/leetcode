package algorithm;

/**
 * manacher算法
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String result=manacher(s);
        return result;
    }

    private static String manacher(String str) {
        // 第一步：我们首先向字符串中插入#号
        StringBuilder temp=new StringBuilder("$#");
        for(int i=0;i< str.length();i++){
            temp.append(str.charAt(i)+"#");
        }
        temp.append("@");

        String tempStr=temp.toString();
        // 首先求出p数组
        int[] p=new int[tempStr.length()];
        int max=0;
        int id=0;
        int resLen=0;
        int resCenter=0;
        // 头尾为我们插入的字符，不算
        for(int i=1;i<tempStr.length()-1;++i){
            p[i]=max>i ? Math.min(p[2*id-i],max-i) :1;
            // ((i-p[i])>=0 && (i+p[i])< tempStr.length()-1) 这段判断是为了判断不越界
            // 这句话说一下，由于我们上面在字符串的开头和结尾处已经添加了两个不相等的字符，所以这句话我们可以不用写
            // (tempStr.charAt(i+p[i])== tempStr.charAt(i-p[i]) 这段表示是否还可以向外扩展，如果可以，则继续向外匹配
            // while(((i-p[i])>=0 && (i+p[i])< tempStr.length()-1) && (tempStr.charAt(i+p[i])== tempStr.charAt(i-p[i]))){
            while(tempStr.charAt(i+p[i])== tempStr.charAt(i-p[i])){
                ++p[i]; // 可以匹配，接着加1
            }
            // 记录当前max到了什么地方
            if(max < i+p[i]){
                max=i+p[i]; // 记录每次已经向外匹配了多远
                id=i;       // id则表示，1，2，3，4，5，6，7.....
            }
            // 记录当前最长的回文与最长回文的中心位置
            if(resLen<p[i]){
                resLen=p[i];
                resCenter=i;
            }
        }
        return str.substring((resCenter-resLen)/2,(resCenter-resLen)/2+resLen-1);
    }
}
