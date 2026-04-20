import java.util.*;
public class StringSubset {
    static void Subsets(StringBuffer ip, StringBuffer op){
        if(ip.length()==0){
            System.out.print(op.toString()+" ");
            return;
        }
        StringBuffer op1  = new StringBuffer(op);
        StringBuffer op2 = new StringBuffer(op);
        op2.append(ip.charAt(0));

        
        //ip.deleteCharAt(0); // will not working 
        // since let ip = "bc" then for any Left RT ip = "" at end 
        // then for Right RT at start ip ="" but we want "bc"
        // so  it will no work, so we send the copy
        /*
            Your recursion is not a tree…
            it’s a single path that eats the input 
        */

        StringBuffer newIp = new StringBuffer(ip);

        newIp.deleteCharAt(0);
        Subsets(newIp, op1);
        Subsets(newIp, op2);
    }

    static void subsets(String ip, String op){
    if(ip.length() == 0){
        System.out.print(op+" ");
        return;
    }

            //here ip = always removes 0th index,(not deletes), op = 1st same as before, 2nd include 0th index of Ip;
    subsets(ip.substring(1), op); // exclude
    subsets(ip.substring(1), op + ip.charAt(0)); // include
}
    public static void main(String[] args){
        StringBuffer ip =new StringBuffer("abc");
        StringBuffer op = new StringBuffer();
        Subsets(ip,op);
        System.out.println();
        subsets(ip.toString(), op.toString());
    }

}       // REMEMBER WITHOU BACKTRACKING , YOU DON'T HAVE TO CHANGE(DELETE OR REASSIGN) THE BASE CODN'S VARIABLE ;
        // PASS THE NEW VARIABLE WITH DECREASED VALUE OR DIRECTLY PASS THE DECREASED VALUE
        // SINCE WE DON'T WANT THE VALUE TO BE CHANGED IN THE CURRENT FUN WE ONLY WANT TO PASS THE DECREASED VALUE
        