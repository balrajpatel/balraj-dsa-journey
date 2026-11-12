import java.util.*;
import java.math.BigInteger;
public class NumberBaseConversion {

    public static BigInteger baseToDecimal(int base, String no){

        if(base < 2 || base > 36){
            throw new IllegalArgumentException("Invalid base");
        }

        no = no.trim();
        if("0".equals(no)){
            return BigInteger.ZERO;
        }
        if(no == null || no.isEmpty()){
            throw new IllegalArgumentException("Empty number");
        }
        boolean isNegative = false;

        if(no.startsWith("-")){
                isNegative = true;
                no = no.substring(1,no.length());
        }
        BigInteger value = BigInteger.ZERO;
        BigInteger BASE = BigInteger.valueOf(base);
        for(char ch : no.toUpperCase().toCharArray()){
            if(Character.isDigit(ch)){
                value = value.multiply(BASE).add(BigInteger.valueOf(ch-'0'));
            }else {
                if(Character.isLetter(ch)){
                value = value.multiply(BASE).add(BigInteger.valueOf(ch -'A' + 10));
                }else {
                    throw new IllegalArgumentException("Invalid character");
                }

            }
        }
        if(isNegative){
            value = BigInteger.ZERO.subtract(value);
        }
        return value;
    }
    public static String decimalToBase(int no, int base){
        if(base < 2 || base > 36){
            throw new IllegalArgumentException("Invalid base");
        }
        if(no==0){
            return "0";
        }
        boolean isNegative = false;
        if(no<0){
            isNegative = true;
        }
        no = Math.abs(no);
        StringBuilder sb = new StringBuilder();

        BigInteger number = BigInteger.valueOf(no);
        BigInteger BASE = BigInteger.valueOf(base);
        while(number.signum()>0){
            int digit = number.remainder(BASE).intValue();

            if(digit>9){
                sb.append((char)('A' + digit - 10));
            }else {
                sb.append((char)('0' + digit));
            }
            number = number.divide(BASE);
        }
        if(isNegative){
            sb.append('-');

        }
        return sb.reverse().toString();


    }

    public static void main(String[] args){
        System.out.println(baseToDecimal(2, "101010"));
        System.out.println(baseToDecimal(16, "2A"));
        System.out.println(baseToDecimal(8, "65"));
        System.out.println();
        System.out.println(decimalToBase(42,2));
        System.out.println(decimalToBase(-42,2));
        System.out.println(decimalToBase(47,16));

    }
}