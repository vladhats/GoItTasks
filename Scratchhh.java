class AvgDamageCalculator {
    public int calculateAvg(int[] samples) {
        int sum = 0;
        try{  for(int sampleValue: samples) {
            sum += sampleValue;
        }} catch(ArithmeticException e){
            return 0;
        } catch(NullPointerException n){
            return 0;
        }

        return sum / samples.length;
    }

}

class AvgDamageCalculatorTest {
    public static void main(String[] args) {
        try {
            System.out.println(new AvgDamageCalculator().calculateAvg(new int[]{2, 4, 6, 8}));

            //0
            System.out.println(new AvgDamageCalculator().calculateAvg(new int[0]));
        }
        catch (ArithmeticException a ){
            System.out.println(0);
        }
    }
}