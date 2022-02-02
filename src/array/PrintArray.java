// 모범답안과 일치함

package array;

public class PrintArray {
    private Integer[][][] data_list = {
            {
                    {1, 2, 3},
                    {4, 5, 6,}
            },
            {
                    {7, 8, 9},
                    {10, 11, 12}
            }
    };

    public static void main(String[] args) {
        PrintArray printArray = new PrintArray();

        System.out.println( printArray.data_list[1][0][1]);
        System.out.println( printArray.data_list[1][1][0]);
        System.out.println( printArray.data_list[0][0][1]);
    }
}
