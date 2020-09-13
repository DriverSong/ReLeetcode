public class MyAtoi {
    public int myAtoi(String str){
        char[] chars = str.toCharArray();
        int sign = 1;
        int index;
        int ans = 0;
        for(index = 0; index < chars.length; index++){
            if(chars[index] != ' ') break;
        }
        if(index == chars.length) return 0;
        if(chars[index] == '-'){
            sign = -1;
            index++;
        }else if(chars[index] == '+') index++;
        else if (chars[index] >= '0' && chars[index] <= '9');
        else return 0;
        for (int i = index; i < chars.length; i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                if((ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && (chars[i] - '0') > Integer.MAX_VALUE % 10))) return Integer.MAX_VALUE;
                if((ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && -(chars[i] - '0') < Integer.MIN_VALUE % 10))) return Integer.MIN_VALUE;
                ans = ans * 10 + sign * (chars[i] - '0');
            }else return ans;
        }
        return ans;
    }

    public static void main(String[] args){
        MyAtoi object = new MyAtoi();
        System.out.println(object.myAtoi("     -0012q42"));;
        System.out.println(Integer.MIN_VALUE % 10);
    }
}
