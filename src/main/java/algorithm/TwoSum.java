package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null){
            return null;
        }
        Map<Integer,Integer> temp=new HashMap();
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if(temp.containsKey(num)){
                return new int[]{temp.get(num),i};
            }
            temp.put(nums[i],i);
        }
        return null;
    }
}
