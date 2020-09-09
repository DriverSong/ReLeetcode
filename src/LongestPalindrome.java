public class LongestPalindrome {
    public String longestPalindrome(String s){
        if(s.equals("")) return "";
        if (s.length() == 1) return s;
        String[] strings = s.split("");
        int[] indexs = new int[2];
        for(int i = 0; i < strings.length; i++){
            findLongestPalindrome(i, strings, indexs);
        }
        return s.substring(indexs[0], indexs[1] + 1);
    }
    void findLongestPalindrome(int i, String[] strings, int[] indexs){
        int j = i;
        int start = i;
        while(j < strings.length){
            if(strings[j].equals(strings[i])) j++;
            else{
                break;
            }
        }
        j--;
        while(start >= 0 && j < strings.length){
            if(strings[start].equals(strings[j])){
                start--;
                j++;
            }else{
                break;
            }
        }
        start++;
        j--;
        if((indexs[1] - indexs[0]) <= (j - start)){
            indexs[0] = start;
            indexs[1] = j;
        }
    }
    public static void main(String[] args){
        LongestPalindrome object = new LongestPalindrome();
        System.out.println(object.longestPalindrome(""));
    }
}
