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
        // - Buat array 2D integer dengan ukuran 3x4 (3 baris, 4 kolom)
        int[][] matrix = new int[3][4];

        // - Isi array dengan nilai: baris 0: [1,2,3,4], baris 1: [5,6,7,8], baris 2: [9,10,11,12]
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        // - Print seluruh matriks menggunakan nested loop dengan format yang rapi
        System.out.println("Matriks 3x4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Latihan 2: Array 2D dengan inisialisasi langsung
        // - Buat array 2D string yang merepresentasikan papan catur 3x3 dengan nilai awal "."
        String[][] papan_catur = {
                {".", ".", "."},
                {".", ".", "."},
                {".", ".", "."}
        };

        // - Tempatkan "X" di posisi [0][0], [1][1], dan [2][2] (diagonal)
        papan_catur[0][0] = "X";
        papan_catur[1][1] = "X";
        papan_catur[2][2] = "X";

        // - Tempatkan "O" di posisi [0][2], [1][0], dan [2][1]
        papan_catur[0][2] = "O";
        papan_catur[1][0] = "O";
        papan_catur[2][1] = "O";

        // - Print papan dengan format grid yang rapi
        System.out.println("\nPapan Catur 3x3:");
        for (int i = 0; i < papan_catur.length; i++) {
            for (int j = 0; j < papan_catur[i].length; j++) {
                System.out.print(papan_catur[i][j] + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED (IRREGULAR) =====
        System.out.println("\n=== ARRAY JAGGED (IRREGULAR) ===");

        // Latihan 3: Array dengan panjang baris yang berbeda
        // - Buat array 2D integer dengan 4 baris: baris 0 panjang 2, baris 1 panjang 4, baris 2 panjang 3, baris 3 panjang 5
        int[][] jagged = new int[4][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        jagged[3] = new int[5];

        // - Isi setiap baris dengan angka berurutan dimulai dari 1
        int angka = 1;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = angka++;
            }
        }

        // - Print array jagged dengan menampilkan panjang setiap baris
        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Baris " + i + " (panjang " + jagged[i].length + "): " + Arrays.toString(jagged[i]));
        }

        // ===== OPERASI LANJUTAN PADA ARRAY =====
        System.out.println("\n=== OPERASI LANJUTAN PADA ARRAY ===");

        // Latihan 4: Operasi matematika pada array 2D
        // - Buat dua matriks 2x3 dengan nilai bebas
        int[][] m1 = {{2, 3, 4}, {6, 7, 8}};
        int[][] m2 = {{8, 7, 6}, {4, 3, 2}};

        // - Implementasikan penjumlahan matriks (buat method addMatrices)
        int[][] hasilTambah = addMatrices(m1, m2);

        // - Implementasikan perkalian setiap elemen dengan scalar 2 (buat method multiplyByScalar)
        int[][] hasilKali = multiplyByScalar(m1, 2);

        // - Print hasil operasi
        System.out.println("Hasil Penjumlahan Matriks:");
        displayMatrix(hasilTambah);

        System.out.println("\nHasil Perkalian Scalar (x2):");
        displayMatrix(hasilKali);

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 5: Method yang menerima dan mengembalikan array
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        // - Panggil method sortArray untuk mengurutkan array
        // (implementasikan method sortArray yang menerima array dan mengembalikan array yang sudah diurutkan)
        int[] sorted = sortArray(numbers);
        System.out.println("Array Terurut: " + Arrays.toString(sorted));

        // - Panggil method reverseArray untuk membalik array
        // (implementasikan method reverseArray)
        int[] reversed = reverseArray(sorted);
        System.out.println("Array Terbalik: " + Arrays.toString(reversed));

        // - Panggil method findMinMax untuk mencari nilai minimum dan maksimum
        // (implementasikan method yang mengembalikan array int dengan 2 elemen: [min, max])
        int[] minMax = findMinMax(numbers);
        System.out.println("Nilai Min dan Max: " + Arrays.toString(minMax));

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");

        // Latihan 6: Eksplorasi utility methods Arrays
        int[] data = {5, 2, 8, 1, 9, 3};

        // - Gunakan Arrays.toString() untuk print array
        System.out.println("Array asli: " + Arrays.toString(data));

        // - Gunakan Arrays.sort() untuk mengurutkan array
        Arrays.sort(data);
        System.out.println("Array setelah sort: " + Arrays.toString(data));

        // - Gunakan Arrays.binarySearch() untuk mencari elemen (array harus sudah diurutkan)
        int posisi = Arrays.binarySearch(data, 8);
        System.out.println("Posisi angka 8 setelah sort: " + posisi);

        // - Gunakan Arrays.fill() untuk mengisi array dengan nilai tertentu
        Arrays.fill(data, 7);
        System.out.println("Array setelah fill nilai 7: " + Arrays.toString(data));

        // - Gunakan Arrays.equals() untuk membandingkan dua array
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("Array a dan b sama? " + Arrays.equals(a, b));

        // - Gunakan Arrays.copyOf() untuk membuat copy array dengan ukuran berbeda
        int[] copy = Arrays.copyOf(data, 10);
        System.out.println("Copy array ukuran 10: " + Arrays.toString(copy));

        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\n=== ARRAY 3D DAN KOMPLEKS ===");

        // Latihan 7: Array 3 dimensi
        // - Buat array 3D integer ukuran 2x3x4 (seperti 2 buah matriks 3x4)
        int[][][] array3D = new int[2][3][4];

        // - Isi dengan nilai berurutan dari 1
        int isi = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    array3D[i][j][k] = isi++;
                }
            }
        }

        // - Print menggunakan triple nested loop dengan format yang jelas
        for (int i = 0; i < array3D.length; i++) {
            System.out.println("Lapisan ke-" + i + ":");
            for (int j = 0; j < array3D[i].length; j++) {
                for (int k = 0; k < array3D[i][j].length; k++) {
                    System.out.print(array3D[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 8: Sistem nilai mahasiswa
        // - Buat array 2D untuk menyimpan nilai 5 mahasiswa, 4 mata kuliah
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};
        int[][] nilai = new int[5][4];

        // - Isi dengan nilai random antara 60-100
        fillRandomGrades(nilai, 60, 100);

        // - Hitung rata-rata per mahasiswa
        double[] rataMahasiswa = new double[5];
        double[] rataMatkul = new double[4];

        for (int i = 0; i < nilai.length; i++) {
            System.out.print(namaMahasiswa[i] + "\t");
            double total = 0;
            for (int j = 0; j < nilai[i].length; j++) {
                System.out.print(nilai[i][j] + "\t\t");
                total += nilai[i][j];
                rataMatkul[j] += nilai[i][j];
            }
            rataMahasiswa[i] = total / nilai[i].length;
            System.out.printf("%.2f\n", rataMahasiswa[i]);
        }

        // - Hitung rata-rata per mata kuliah
        for (int j = 0; j < rataMatkul.length; j++) {
            rataMatkul[j] /= nilai.length;
        }
        System.out.println("\nRata-rata per mata kuliah: " + Arrays.toString(rataMatkul));

        // - Tentukan mahasiswa dengan nilai tertinggi
        int indexTop = 0;
        for (int i = 1; i < rataMahasiswa.length; i++) {
            if (rataMahasiswa[i] > rataMahasiswa[indexTop]) {
                indexTop = i;
            }
        }
        System.out.println("Mahasiswa dengan nilai tertinggi: " + namaMahasiswa[indexTop]);

        // - Print dalam format tabel yang rapi
        System.out.println("Nama\t\tMath\tPhysics\tChemistry\tBiology\tRata-rata");

        // ===== GAME TIC-TAC-TOE SEDERHANA =====
        System.out.println("\n=== GAME TIC-TAC-TOE SEDERHANA ===");

        // Latihan 9: Game Tic-Tac-Toe sederhana
        // - Buat array 2D char 3x3 untuk papan permainan
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // - Implementasikan method untuk menampilkan papan
        displayTicTacToe(board);

        // - Implementasikan method untuk mengecek apakah ada pemenang
        char winner = checkWinner(board);
        if (winner == 'X' || winner == 'O') {
            System.out.println("Pemenangnya adalah: " + winner);
        } else {
            System.out.println("Belum ada pemenang!");
        }

        // - Simulasikan beberapa langkah permainan
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[1][1] = 'X';
        board[2][0] = 'O';
        board[2][2] = 'X';

        System.out.println("\nSetelah beberapa langkah permainan:");
        displayTicTacToe(board);
    }

    // ===== IMPLEMENTASI METHODS =====
    // TODO: Implementasikan method-method yang diperlukan di sini

    // Method untuk penjumlahan matriks
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        // Implementasi penjumlahan matriks
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result; // Ganti dengan implementasi yang benar
    }

    // Method untuk perkalian scalar
    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        // Implementasi perkalian scalar
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result; // Ganti dengan implementasi yang benar
    }

    // Method untuk sorting array
    public static int[] sortArray(int[] arr) {
        // Implementasi sorting (bisa menggunakan Arrays.sort atau implementasi sendiri)
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted; // Ganti dengan implementasi yang benar
    }

    // Method untuk reverse array
    public static int[] reverseArray(int[] arr) {
        // Implementasi reverse array
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed; // Ganti dengan implementasi yang benar
    }

    // Method untuk find min dan max
    public static int[] findMinMax(int[] arr) {
        // Return array dengan format [min, max]
        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        return new int[]{min, max}; // Ganti dengan implementasi yang benar
    }

    // Method untuk display array 2D
    public static void displayMatrix(int[][] matrix) {
        // Implementasi untuk menampilkan matriks dengan format rapi
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method untuk mengisi array 2D dengan nilai random
    public static void fillRandomGrades(int[][] grades, int min, int max) {
        // Implementasi untuk mengisi array dengan nilai random
        Random rand = new Random();
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    // Method untuk menghitung rata-rata array
    public static double calculateAverage(int[] values) {
        // Implementasi untuk menghitung rata-rata
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return (double) total / values.length; // Ganti dengan implementasi yang benar
    }

    // Method untuk menampilkan papan Tic-Tac-Toe
    public static void displayTicTacToe(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Method untuk mengecek pemenang Tic-Tac-Toe
    public static char checkWinner(char[][] board) {
        // Cek baris
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Cek kolom
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                    board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // Cek diagonal
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2];
        }

        // Tidak ada pemenang
        return ' ';
    }
}