public class arr {
    
    public static void main(String[] args) {
        int[][] array = new int[3][2];

        array [0][0] = 1;
        array [0][1] = 2;
        array [1][0] = 3;
        array [1][1] = 7;
        array [2][0] = 4;
        array [2][1] = 8;

        int[] array1 = array[2];
        System.out.println(array1[0]);
        System.out.println(array1.length);
        System.out.println(array.length);

        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                System.out.println(array1[i]);
                System.out.println(array1[j]);
            }
        }
    }
}
