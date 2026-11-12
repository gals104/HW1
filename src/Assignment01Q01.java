public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String str : args){
            if (str != null && str.length() > 0) {
                int first_char = str.charAt(0);
                if ( first_char % 5 == 0){
                    System.out.println((char) first_char);
                }
            }
        }
    }
}
