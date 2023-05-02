package tallerbusquedayordenamiento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Angie Jaimes 1152037
 */
public class LeerTestsEliminarDuplicado {
        public static void main(String[] args) {
        try {
            File archivo = new File ("output.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);

            for(int i = 0; i < 100; i++){
                String data = br.readLine();
                int[] array = stringToArray(data);
                int resultado = removeDuplicates(array);
                System.out.println("Matriz Ingresada: " + data);
                System.out.print("Matriz resultante: ");
                System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, resultado)));
                System.out.println("");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int k = 0;
        for(int i = 1; i < nums.length; i++){
            if( nums[i] != nums[k] ) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }

    public static int[] stringToArray(String arrayString){
        arrayString = arrayString.substring(1, arrayString.length() - 1); // Eliminamos los corchetes
        String[] elementos = arrayString.split(", "); // Separamos los elementos
        int[] array = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            array[i] = Integer.parseInt(elementos[i]);
        }
        return array;
    }
}

