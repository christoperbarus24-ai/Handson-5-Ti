import java.util.Arrays;
import java.util.Random;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * array multidimensi, operasi lanjutan, parameter/return value, dan utility methods.
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        // Latihan 1: Membuat dan mengisi array 2D (matriks)
        int[][] matrix = new int[3][4];

        // Mengisi array dengan nilai
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = counter++;
            }
        }

        // Print seluruh matriks
        System.out.println("Matriks 3x4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        // Latihan 2: Array 2D dengan inisialisasi langsung
        String[][] board = {
                {".", ".", "."},
                {".", ".", "."},
                {".", ".", "."}
        };

        // Tempatkan X dan O
        board[0][0] = "X";
        board[1][1] = "X";
        board[2][2] = "X";
        board[0][2] = "O";
        board[1][0] = "O";
        board[2][1] = "O";

        // Print papan
        System.out.println("\nPapan 3x3:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED (IRREGULAR) =====
        System.out.println("\n=== ARRAY JAGGED (IRREGULAR) ===");

        // Latihan 3: Array dengan panjang baris yang berbeda
        int[][] jaggedArray = new int[4][];
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[4];
        jaggedArray[2] = new int[3];
        jaggedArray[3] = new int[5];

        // Isi dengan angka berurutan
        int num = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = num++;
            }
        }

        // Print array jagged
        System.out.println("Array Jagged:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.print("Baris " + i + " (panjang " + jaggedArray[i].length + "): ");
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

        // ===== OPERASI LANJUTAN PADA ARRAY =====
        System.out.println("\n=== OPERASI LANJUTAN PADA ARRAY ===");

        // Latihan 4: Operasi matematika pada array 2D
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix2 = {
                {7, 8, 9},
                {10, 11, 12}
        };

        System.out.println("Matriks 1:");
        displayMatrix(matrix1);

        System.out.println("\nMatriks 2:");
        displayMatrix(matrix2);

        int[][] sumMatrix = addMatrices(matrix1, matrix2);
        System.out.println("\nHasil Penjumlahan Matriks:");
        displayMatrix(sumMatrix);

        int[][] scaledMatrix = multiplyByScalar(matrix1, 2);
        System.out.println("\nHasil Perkalian Matriks 1 dengan Scalar 2:");
        displayMatrix(scaledMatrix);

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 5: Method yang menerima dan mengembalikan array
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array asli: " + Arrays.toString(numbers));

        int[] sorted = sortArray(numbers.clone());
        System.out.println("Array sorted: " + Arrays.toString(sorted));

        int[] reversed = reverseArray(numbers.clone());
        System.out.println("Array reversed: " + Arrays.toString(reversed));

        int[] minMax = findMinMax(numbers);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");

        // Latihan 6: Eksplorasi utility methods Arrays
        int[] data = {5, 2, 8, 1, 9, 3};

        System.out.println("Array asli dengan toString(): " + Arrays.toString(data));

        Arrays.sort(data);
        System.out.println("Array setelah sort(): " + Arrays.toString(data));

        int searchKey = 8;
        int index = Arrays.binarySearch(data, searchKey);
        System.out.println("Posisi angka " + searchKey + " dengan binarySearch(): " + index);

        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 7);
        System.out.println("Array setelah fill(7): " + Arrays.toString(fillArray));

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};
        System.out.println("array1 equals array2: " + Arrays.equals(array1, array2));
        System.out.println("array1 equals array3: " + Arrays.equals(array1, array3));

        int[] originalArray = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(originalArray, 8);
        System.out.println("Array asli: " + Arrays.toString(originalArray));
        System.out.println("Copy dengan ukuran 8: " + Arrays.toString(copiedArray));

        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\n=== ARRAY 3D DAN KOMPLEKS ===");

        // Latihan 7: Array 3 dimensi
        int[][][] array3D = new int[2][3][4];

        int value = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    array3D[i][j][k] = value++;
                }
            }
        }

        System.out.println("Array 3D (2x3x4):");
        for (int i = 0; i < array3D.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < array3D[i].length; j++) {
                for (int k = 0; k < array3D[i][j].length; k++) {
                    System.out.printf("%4d", array3D[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("=== SKENARIO APLIKASI NYATA ===");

        // Latihan 8: Sistem nilai mahasiswa
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};

        int[][] grades = new int[5][4];
        fillRandomGrades(grades, 60, 100);

        // Print tabel nilai
        System.out.println("\nTabel Nilai Mahasiswa:");
        System.out.printf("%-12s", "Nama");
        for (String mk : mataKuliah) {
            System.out.printf("%-12s", mk);
        }
        System.out.println("Rata-rata");
        System.out.println("=".repeat(70));

        double maxAvg = 0;
        String topStudent = "";

        for (int i = 0; i < namaMahasiswa.length; i++) {
            System.out.printf("%-12s", namaMahasiswa[i]);
            for (int j = 0; j < mataKuliah.length; j++) {
                System.out.printf("%-12d", grades[i][j]);
            }
            double avg = calculateAverage(grades[i]);
            System.out.printf("%.2f\n", avg);

            if (avg > maxAvg) {
                maxAvg = avg;
                topStudent = namaMahasiswa[i];
            }
        }

        System.out.println("\nRata-rata per Mata Kuliah:");
        for (int j = 0; j < mataKuliah.length; j++) {
            int[] subjectGrades = new int[namaMahasiswa.length];
            for (int i = 0; i < namaMahasiswa.length; i++) {
                subjectGrades[i] = grades[i][j];
            }
            double avg = calculateAverage(subjectGrades);
            System.out.printf("%s: %.2f\n", mataKuliah[j], avg);
        }

        System.out.println("\nMahasiswa dengan nilai tertinggi: " + topStudent + " (%.2f)".formatted(maxAvg));

        // Latihan 9: Game Tic-Tac-Toe sederhana
        System.out.println("\n=== GAME TIC-TAC-TOE ===");
        char[][] ticTacToe = new char[3][3];

        // Inisialisasi papan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = '-';
            }
        }

        // Simulasi permainan
        ticTacToe[0][0] = 'X';
        ticTacToe[0][1] = 'O';
        ticTacToe[1][1] = 'X';
        ticTacToe[1][2] = 'O';
        ticTacToe[2][2] = 'X';

        displayTicTacToe(ticTacToe);

        String winner = checkWinner(ticTacToe);
        if (winner != null) {
            System.out.println("\nPemenang: " + winner);
        } else {
            System.out.println("\nBelum ada pemenang!");
        }
    }

    // ===== IMPLEMENTASI METHODS =====

    // Method untuk penjumlahan matriks
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method untuk perkalian scalar
    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    // Method untuk sorting array
    public static int[] sortArray(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    // Method untuk reverse array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Method untuk find min dan max
    public static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return new int[]{min, max};
    }

    // Method untuk display array 2D
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // Method untuk mengisi array 2D dengan nilai random
    public static void fillRandomGrades(int[][] grades, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
    }

    // Method untuk menghitung rata-rata array
    public static double calculateAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }

    // Method untuk menampilkan papan Tic-Tac-Toe
    public static void displayTicTacToe(char[][] board) {
        System.out.println("\nPapan Tic-Tac-Toe:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method untuk mengecek pemenang Tic-Tac-Toe
    public static String checkWinner(char[][] board) {
        // Cek horizontal
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return String.valueOf(board[i][0]);
            }
        }

        // Cek vertikal
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return String.valueOf(board[0][j]);
            }
        }

        // Cek diagonal
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return String.valueOf(board[0][0]);
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return String.valueOf(board[0][2]);
        }

        return null;
    }
}