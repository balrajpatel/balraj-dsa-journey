public class PermutationWithSpaces{
    static void permutation(String ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op + "_"+ ip.charAt(0);
        String ip1 = ip.substring(1);

        permutation(ip1,op1);
        permutation(ip1,op2);


    }
    public static void main(String[] args){
        String s1 = "abc";
        String op = new String(new char[]{s1.charAt(0)});
        String ip = s1.substring(1);
        permutation(ip,op);

    }

}