public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        /////////////////////////////////////////////
        int steps = Integer.parseInt(args[0]); // assume the input is valid
        int sign = 1; // + or -
        for (int i = 0; i < steps; i++){
            approxPi += (sign)*(1.0/(i*2 + 1)); //1 - 1/3 + 1/5 - 1/7 +...
            sign *= -1; //change the sign (plus to minus and opposite)
        }
        approxPi *= 4; //4*sum
        /////////////////////////////////////////////
        
        System.out.println(approxPi + " " + actualPi);
    }
}
