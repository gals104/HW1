public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]); // assume the input is valid
        System.out.println("The first " + x + " Fibonacci numbers are:");

        ////////////////////////////////////////////////////////////////
        int numOdd = 0;
        int prev = 1; // last num
        int curr = 0; //curr num
        int temp; // help for change values inside the loop
        for (int i = 0; i < x; i++) {
            // change the vcuur and prev nums and print the new num
            temp = curr;
            curr += prev;
            prev = temp;
            System.out.print(curr);
            if (curr % 2 == 1){
                // if the num is odd count it as another odd number
                numOdd += 1;
            };
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
