public class BinaryPrefixes{
    static void binaryPrefixes(int ones, int zeros, int n, String op){
        if(n==0){
            System.out.println(op);
            return;
        }

        // start we'll always have to pick 1 , since we can't start with 0 as one of the prefix will be 0 (of one length) for any given n;

        // always have choice of selecting 1 // we don't need to check for n>0 since n==0 base condn covers that;
        String op1= op+"1";
        binaryPrefixes(ones+1, zeros, n-1, op1);

        // we can choose zeros when no of 1 is greater then 0 since we want prefixes having no of 1's >= 0's
        if(ones>zeros){
            String op2 = op + "0";
            binaryPrefixes(ones, zeros+1, n-1, op2);

        }

    }

    public static void main(String[] args){
        String op ="";
        int n =5;
        binaryPrefixes(0,0,n,op);
    }
}