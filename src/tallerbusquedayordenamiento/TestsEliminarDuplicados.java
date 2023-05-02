package tallerbusquedayordenamiento;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Angie Jaimes 1152037
 */

public class TestsEliminarDuplicados {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 50;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {

        File file = new File("output.txt");

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bf);

            for (int numTests = 0; numTests < 100; numTests++) {
                int[] nums = generateRandomArray();
                nums = generateDuplicateNumberArray(nums);
                out.println(Arrays.toString(nums));
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[] generateRandomArray() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }
        Arrays.sort(nums);
        return nums;
    }

    private static int[] generateDuplicateNumberArray(int[] nums) {
        int numRepetidos = random.nextInt(nums.length);
        for(int i = 0; i < numRepetidos; i++){
            int index = random.nextInt(nums.length);
            int valor = nums[index];

            int numRepeticiones = random.nextInt(4) + 2;
            for(int j = 0; j < numRepeticiones; j++){
                nums[random.nextInt(nums.length)] = valor;
            }
        }
        Arrays.sort(nums);
        return nums;
    }
}