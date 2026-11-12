import java.util.*;
public class DirectNumberBaseConversion {
    public static String directNumberBaseConversion(String number , int sourceBase, int targetBase){
        if(sourceBase <2 || sourceBase >36 || targetBase <2 || targetBase >36){
            throw new IllegalArgumentException("Invalid Bases");
        }

        number = number.trim();

        if(number.isEmpty()){
            throw new IllegalArgumentException("Empty Number");
        }
        if("0".equals(number)){
            return "0";
        }

        boolean isNegative = false;
        if(number.charAt(0)=='-' || number.charAt(0)== '+'){
            if(number.charAt(0) == '-'){
                isNegative = true;
            }
            number = number.substring(1);
        }
        // after removing sign again validate
        if(number.isEmpty()){
        throw new IllegalArgumentException("Number cannot contain only a sign");}

        StringBuilder result = new StringBuilder();

        while(!number.equals("0")){
            StringBuilder quotient = new StringBuilder();
            long remainder = 0;
            for(char ch: number.toUpperCase().toCharArray()){

                // here any digit taking down as its numeric value
                int digit = Character.digit(ch,sourceBase);


                // here remainder was taken from last since we update the remainder in the end (30th line);
                long current = remainder*sourceBase + digit;


                long quotientDigit = current/targetBase;


                remainder = current%targetBase;


                // we only want the correct representation(in its form,  of Quotient)
                // and in the end correct representation of remainder

                if(quotientDigit <10){
                    quotient.append((char)('0' + quotientDigit));
                }else {
                    quotient.append((char)('A' + quotientDigit -10));
                }
                

            }
            // remvoing leading zeros;
            int i = 0;
            while (i < quotient.length() && quotient.charAt(i) == '0') {
                i++;
            }
            number = i == quotient.length()
                    ? "0"
                    : quotient.substring(i);




            if(remainder <10){
                    result.append((char)('0' + remainder));
            }else {
                    result.append((char)('A' + remainder -10));}    
        }

        if(isNegative){
            result.append('-');
        }

        return result.reverse().toString();
    }

    public char getCharValue(int n){
        return (char)('A' + n -10);
    }


    public static void main(String[] args) {

        // Binary to Hexadecimal
        System.out.println(
                directNumberBaseConversion("101101", 2, 16)
        );

        // Hexadecimal to Binary
        System.out.println(
                directNumberBaseConversion("2D", 16, 2)
        );

        // Decimal to Hexadecimal
        System.out.println(
                directNumberBaseConversion("255", 10, 16)
        );

        // Hexadecimal to Octal
        System.out.println(
                directNumberBaseConversion("FF", 16, 8)
        );

        // Large Binary to Hexadecimal
        System.out.println(
                directNumberBaseConversion(
                        "111111111111111111111111111111111111",
                        2, 16
                )
        );

        // Negative Binary to Hexadecimal
        System.out.println(
                directNumberBaseConversion("-101101", 2, 16)
        );

        // Base 36 to Binary
        System.out.println(
                directNumberBaseConversion("ZZ", 36, 2)
        );

        /*
        2D
        101101
        FF
        377
        FFFFFFFFF
        -2D
        10100001111
        */
    }
}