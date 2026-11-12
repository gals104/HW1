import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if ((direction != 'R') && (direction != 'L')){
            //the direction is onlr right or left
            //other directions return same array
            return array;
        }

        //change the 'move' to become positive and less then len(array)
        if (move < 0){
            move *= -1;
            if (direction == 'R'){
                direction = 'L';
            }
            else if (direction == 'L'){
                direction = 'R';
            }
        }
        int length = array.length;
        if (length == 0){
            return array;//in case the array is empty, there is nothing the move (and prevent divide by 0)
        }
        move %= length;

        //do the Cyclic Shift
        int[] help_array; // it will be the new array
        if (direction == 'L'){
            //in each move, first object become last
            help_array = Arrays.copyOfRange(array, 0, move); //copy the 'move' first objects
            for (int i = move; i < length; ++i){
                array[i - move] = array[i];
            }
            for (int i = 0; i < move; ++i){
                array[length -move +i] = help_array[i];
            }
        }
        else if (direction == 'R'){
            //in each move, last object become first
            help_array = Arrays.copyOfRange(array, length - move, length); //copy the 'move' last objects
            for (int i = length - move - 1; i >= 0; --i){
                array[i + move] = array[i];
            }
            for (int i = 0; i < move; ++i){
                array[i] = help_array[i];
            }
        }


        return array;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}