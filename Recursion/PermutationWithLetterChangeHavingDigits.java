public class PermutationWithLetterChangeHavingDigits{
    static void Permutation(String  ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        if(Character.isDigit(ip.charAt(0))){
            String op1 = op + ip.charAt(0);
            String ip1  = ip.substring(1);
            Permutation(ip1,op1);
        }else{
            String op1 = op + Character.toLowerCase(ip.charAt(0));
            String op2 = op + Character.toUpperCase(ip.charAt(0));
            String ip1 = ip.substring(1);
            Permutation(ip1,op1);
            Permutation(ip1,op2);

        }
    }
    public static void main(String[] args){
        String ip = "a1b2C3";
        String op = new String();
        Permutation(ip,op);

    }
}