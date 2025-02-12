public class Main {

    public static void main(String[] args) {
        // Создаём двумерный массив (матрицу)
        int[][] matrix = {
                {5, 1, 4},
                {2, 8, 0},
                {9, 3, 7}
        };

        System.out.println("Массив до сортировки:");
        printMatrix(matrix);

        // Сортируем матрицу шейкерной сортировкой
        shakerSort(matrix);

        System.out.println("\nМассив после сортировки (по строкам):");
        printMatrix(matrix);
    }

    // Функция для вывода матрицы на экран
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Шейкерная сортировка для двумерного массива (сортируем каждую строку)
    public static void shakerSort(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {  // Идём по каждой строке
            shakerSortRow(matrix[i]); // Сортируем текущую строку
        }
    }

    // Шейкерная сортировка для одной строки (одномерного массива)
    public static void shakerSortRow(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean swapped;
        do {
            swapped = false;

            // Двигаемся справа налево (как пузырьковая сортировка)
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    // Меняем элементы местами
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            right--; // Уменьшаем правую границу, т.к. самый большой элемент уже в конце

            // Двигаемся слева направо
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    // Меняем элементы местами
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            left++; // Увеличиваем левую границу, т.к. самый маленький элемент уже в начале

        } while (swapped); // Продолжаем, пока были перестановки
    }
}