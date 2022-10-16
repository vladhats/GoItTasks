public class MarsCalculator{
    public static void main(String[]args){
    }



    public int sum(int a, int b, int c){
        return a + b + c;
    }
    public int sub(int a, int b, int c){
        return a - b - c;
    }
    public int multiply(int a, int b, int c){
        return sum(a,b,c) * sub(a,b,c);
    }
    public float divide(int a, int b, int c){
        return sum(a,b,c)/10f;
    }


}