public class TowerOfHanoi{
    static void solve(int plates, int source , int destination,  int helper){
        if(plates==1){
            System.out.println("Move plate " + plates + " from " + source + " to "+destination);
            return;
        }
        solve(plates-1, source, helper, destination);
        System.out.println("Move plate "+ plates + " from " + source + " to " + destination);
        solve(plates-1, helper, destination, source);
    }
    public static void main(String[] args){
        int source =1 , destination =3, helper =2;
        int plates = 3;
        solve(plates, source, destination, helper);
    }
}