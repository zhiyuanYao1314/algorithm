package qushikeji;

/**
 * A city skyline can be represented as a 2-D list with 1s representing buildings. In the example below, the height of the tallest building is 4 (second-most right column).
 * [[0, 0, 0, 0, 0, 0],
 * [0, 0, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1, 0],
 * [0, 1, 1, 1, 1, 0],
 * [1, 1, 1, 1, 1, 1]]
 *
 * Create a function that takes a skyline (2-D list of 0's and 1's) and returns the height of the tallest skyscraper.
 *
 * Examples
 *
 * tallest_skyscraper([
 *   [0, 0, 0, 0],
 *   [0, 1, 0, 0],
 *   [0, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 3
 *
 * tallest_skyscraper([
 *   [0, 1, 0, 0],
 *   [0, 1, 0, 0],
 *   [0, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 4
 *
 * tallest_skyscraper([
 *   [0, 0, 0, 0],
 *   [0, 0, 0, 0],
 * [1, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 2
 * A city skyline can be represented as a 2-D list with 1s representing buildings. In the example below, the height of the tallest building is 4 (second-most right column).
 * [[0, 0, 0, 0, 0, 0],
 * [0, 0, 0, 0, 1, 0],
 * [0, 0, 1, 0, 1, 0],
 * [0, 1, 1, 1, 1, 0],
 * [1, 1, 1, 1, 1, 1]]
 *
 * Create a function that takes a skyline (2-D list of 0's and 1's) and returns the height of the tallest skyscraper.
 *
 * Examples
 *
 * tallest_skyscraper([
 *   [0, 0, 0, 0],
 *   [0, 1, 0, 0],
 *   [0, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 3
 *
 * tallest_skyscraper([
 *   [0, 1, 0, 0],
 *   [0, 1, 0, 0],
 *   [0, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 4
 *
 * tallest_skyscraper([
 *   [0, 0, 0, 0],
 *   [0, 0, 0, 0],
 *   [1, 1, 1, 0],
 *   [1, 1, 1, 1]
 * ]) ➞ 2
 */



public class Main{
    public static void main(String[] args) {
        int[][] ints = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 1}
        };
        int heightest = heightest(ints);
        System.out.println(heightest);
    }

    public static int heightest(int[][] sky){
        int size = sky.length;
        int cloms = sky[0].length;

        for (int i=0;i<size;i++){
            for (int j=0;j<cloms;j++){
                if (sky[i][j]==1){
                    return size-i;
                }
            }
        }
        return 0;
    }

}