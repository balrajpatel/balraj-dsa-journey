import java.util.*;
public class Base7Leetcode504 {

    public static String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        boolean isNegative = false;
        if(num<0){
            isNegative = true;
            num = Math.abs(num);
        }
        StringBuilder sb = new StringBuilder();

        while(num>0){
            int digit = num%7;
            sb.append((char)('0' + digit));
            num /= 7;

        }
        if(isNegative){
            sb.append('-');
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(convertToBase7(-10));
        System.out.println(convertToBase7(100));

    }
}