import java.util.Arrays;

public class task4 {
    private static int[] array1 = {5, 4, 3};
    private static int[] array2 = {3, 2, 1};
    //private static int[] array2 = null;
    //private static int[] array2 = {3, 2, 0};
    //private static int[] array2 = {3, 2, 1, 0};
    
    public static int[] div(int[] array1, int[] array2){
        if (array1 == null || array2 == null) throw new RuntimeException("NULL ARRAY");
        if (array1.length != array2.length) throw new RuntimeException("UNEQUAL ARRAYS LENGTH");
        int[] result = new int[array1.length];
        for (int i = 0; i < result.length; i++){
            if (array2[i] == 0) throw new RuntimeException("DIVIDE BY ZERO");
            result[i] = array1[i] / array2[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(div(array1, array2)));
    }
}
