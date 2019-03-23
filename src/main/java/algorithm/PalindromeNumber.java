package algorithm;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String numStr=String.valueOf(x);
        int left=0;
        int right=numStr.length()-1;
        char[] arr=numStr.toCharArray();
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return numStr.equals(new String(arr));
    }
}
