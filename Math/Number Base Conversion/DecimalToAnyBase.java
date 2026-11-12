import java.util.*;
class DecimalToAnyBase {
    public static void main(String[] args) {

        System.out.println(decimalToAnyBase(12,16));
        System.out.println(decimalToAnyBase(26,16));

    }

    public static String decimalToAnyBase(int no, int base){
        if(no==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char c;
        while(no!=0){
            int digit = no%base;
            no /= base;
            if (digit > 9) {
            c = (char) ('A' + digit - 10);
            } else {
            c = (char) ('0' + digit);
            }
            
            sb.append(c);
        }

        return sb.reverse().toString();


    }
}