public class ReverseInteger {
    public int reverse(int x){
        int length = 10;
        int[] ints = new int[length];
        int plus = x >= 0 ? 1 : -1;
        int yushu = Math.abs(x);
        double reverse = 0;
        for(int i = 10; i > 0; i--){
            ints[length - i] = (int) (yushu / Math.pow(10, i-1));
            yushu = (int) (yushu - ints[length - i] * Math.pow(10, i - 1));
        }
        int begin = 0;
        for (begin = 0; begin < length; begin++){
            if(ints[begin] != 0) break;
        }
        for (int i = begin; i < length; i++){
            reverse = (reverse + plus * (ints[i] * Math.pow(10, i - begin)));
        }
        if(reverse > (Math.pow(2, 31) - 1) || reverse < -Math.pow(2, 31)) return 0;
        else return (int) reverse;
    }
    public int reverse(int x) {

    }
    public static void main(String[] args){
        ReverseInteger object = new ReverseInteger();
        int reverse = object.reverse(1534236469);
        System.out.println(reverse);
    }
}
