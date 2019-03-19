package algorithm;

import java.util.LinkedHashSet;

/**
 * 思路：通过hash存放元素，当发现hash已经存在时，则把已经存在的字符及之前的字符删除
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        LinkedHashSet<Character> hash = new LinkedHashSet<Character>();
        int lastTime=0;
        for(int i=0;i<s.length();i++){
            if(hash.contains(s.charAt(i))){
                //查出它所在的位置，并把它之前的插入删除
                lastTime=Math.max(hash.size(),lastTime);
                //将冲突之前的删除
                Character[] objects =new Character[hash.size()];
                hash.toArray(objects);
                for(int j=0;j<objects.length;j++){
                    if(objects[j]==s.charAt(i)){
                        break;
                    }
                    hash.remove(objects[j]);
                }
                hash.remove(s.charAt(i));
            }
            hash.add(s.charAt(i));
        }
        lastTime=Math.max(hash.size(),lastTime);
        return lastTime;
    }
}
