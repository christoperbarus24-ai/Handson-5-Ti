import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable untuk demonstrasi
    private static int counter = 0;

    // Instance variable untuk demonstrasi
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Methods Advanced
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * method signature, overloading, pass by value/reference, static vs instance methods.
         */

        // ===== METHOD SIGNATURE DAN DECLARATION =====
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");

        // Latihan 1: Memahami komponen method signature
        // - Panggil method dengan signature berbeda untuk melihat perbedaannya
        int sumInt = calculate(5, 10);
        double sumDouble = calculate(2.5, 3.5);
        int sumThreeInt = calculate(1, 2, 3);
        String concatString = calculate("Hi ", "Java");

        // - Gunakan method overloading untuk mendemonstrasikan signature
        // Semua method calculate diimplementasikan di bawah

        // Contoh pemanggilan method calculate dengan signature berbeda
        System.out.println("calculate(int, int): " + sumInt);
        System.out.println("calculate(double, double): " + sumDouble);
        System.out.println("calculate(int, int, int): " + sumThreeInt);
        System.out.println("calculate(String, String): " + concatString);


        // ===== METHOD OVERLOADING =====
        System.out.println("\n=== METHOD OVERLOADING ===");

        // Latihan 2: Implementasi dan penggunaan method overloading
        // - Panggil semua variasi method calculate yang di-overload
        System.out.println("Overload calculate int + int: " + calculate(7,3));
        System.out.println("Overload calculate double + double: " + calculate(1.5,2.5));
        System.out.println("Overload calculate int + int + int: " + calculate(1,2,3));
        System.out.println("Overload calculate String + String: " + calculate("Java","Rocks"));

        // - Panggil semua variasi method print yang di-overload
        print(100);
        print(99.99);
        print("Halo Java!");
        print(new int[]{1,2,3,4,5});

        // - Demonstrasikan bagaimana compiler memilih method yang tepat
        // Compiler memilih method berdasarkan **signature paling sesuai**
        print(50);       // pilih print(int)
        print(3.14);     // pilih print(double)
        print("Test");   // pilih print(String)
        print(new int[]{9,8,7}); // pilih print(int[])

        // ===== STATIC VS INSTANCE METHODS =====
        System.out.println("\n=== STATIC VS INSTANCE METHODS ===");
        // Latihan 3: Perbedaan static dan instance methods
        // - Panggil static method tanpa membuat object
        incrementCounter();
        System.out.println("Counter setelah increment: " + getCounter());

        // - Buat instance object dan panggil instance method
        MethodsAdvancedPractice obj = new MethodsAdvancedPractice("Objek1");
        obj.displayInfo();

        // - Demonstrasikan akses ke static vs instance variables
        obj.setInstanceName("ObjekBaru");
        obj.displayInfo();

        // - Coba akses instance method dari static context (akan error)
        // displayInfo(); // <-- ini akan error karena displayInfo() adalah instance method


        // ===== PASS BY VALUE - PRIMITIVES =====
        System.out.println("\n=== PASS BY VALUE - PRIMITIVES ===");

        // Latihan 4: Demonstrasi pass by value untuk primitive types
        int originalNumber = 10;

        // - Panggil method modifyPrimitive dengan originalNumber
        modifyPrimitive(originalNumber);

        // - Print originalNumber sebelum dan sesudah method call
        System.out.println("Sebelum method call: " + originalNumber);
        System.out.println("Sesudah method call: " + originalNumber);

        // - Jelaskan mengapa nilai tidak berubah
        // Nilai tidak berubah karena Java menggunakan pass by value.
        // Saat method dipanggil, yang dikirim hanyalah salinan nilai primitive,
        // bukan variabel aslinya. Jadi, perubahan di dalam method tidak
        // mempengaruhi nilai originalNumber di luar method.

        // ===== PASS BY VALUE OF REFERENCE - OBJECTS =====
        System.out.println("\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");

        // Latihan 5: Demonstrasi pass by value of reference untuk objects
        int[] originalArray = {1, 2, 3, 4, 5};

        // - Print array sebelum modification
        System.out.print("Sebelum modification: ");


        // - Panggil method modifyArray dengan originalArray
        modifyArray(originalArray);
        printArray(originalArray);

        // - Print array setelah modification
        System.out.print("Sesudah modification: ");
        printArray(originalArray);


        // - Jelaskan mengapa isi array berubah tetapi reference tidak
        // Isi array berubah karena Java tetap menggunakan pass by value,
        // namun yang dikirim ke method adalah salinan dari referensi (alamat objek).
        // Artinya, parameter di method menunjuk ke objek array yang sama di memori.
        // Karena itu, perubahan pada isi array di dalam method akan terlihat
        // di luar method juga. Tapi reference aslinya sendiri tidak berubah.

        // Latihan 6: Reference reassignment dalam method
        int[] anotherArray = {10, 20, 30};

        // - Print array sebelum reassignment
        System.out.print("\nSebelum reassignment: ");
        printArray(anotherArray);

        // - Panggil method reassignArray dengan anotherArray
        reassignArray(anotherArray);


        // - Print array setelah method call
        System.out.print("Sesudah method call: ");
        printArray(anotherArray);

        // - Jelaskan mengapa reference asli tidak berubah
        // Reference asli tidak berubah karena Java mengirim salinan dari referensi.
        // Ketika di dalam method reference tersebut diarahkan ke objek baru (reassignment),
        // perubahan itu hanya terjadi pada salinan lokal di dalam method.
        // Reference asli di luar method tetap menunjuk ke objek array yang lama.


        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // Latihan 7: Method yang menerima dan mengembalikan array
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        // - Panggil method yang mengembalikan copy array yang diurutkan
        int[] sorted = sortArray(numbers);
        System.out.print("Array asli: ");
        printArray(numbers);
        System.out.print("Array hasil sort (copy): ");
        printArray(sorted);

        // - Panggil method yang mengembalikan statistik array (min, max, avg)
        double[] stats = getStatistics(numbers);
        System.out.println("Statistik array -> Min: " + stats[0] + ", Max: " + stats[1] + ", Avg: " + stats[2]);

        // - Panggil method yang merge dua array
        int[] moreNumbers = {100, 200, 300};
        int[] merged = mergeArrays(numbers, moreNumbers);
        System.out.print("Hasil merge dua array: ");
        printArray(merged);

        // ===== VARIABLE ARGUMENTS (VARARGS) =====
        System.out.println("\n=== VARIABLE ARGUMENTS (VARARGS) ===");

        // Latihan 8: Implementasi dan penggunaan varargs
        // - Panggil method sum dengan jumlah parameter berbeda-beda
        System.out.println("Sum(1,2,3): " + sum(1, 2, 3));
        System.out.println("Sum(10,20,30,40,50): " + sum(10, 20, 30, 40, 50));
        System.out.println("Sum(100): " + sum(100));

        // - Panggil method printInfo dengan berbagai kombinasi parameter
        printInfo("Christofer", 20, "Medan");
        printInfo("Alice");
        printInfo("Budi", 25);

        // ===== METHOD CHAINING =====
        System.out.println("\n=== METHOD CHAINING ===");

        // Latihan 9: Implementasi method chaining
        // - Gunakan Calculator dengan method chaining untuk operasi berurutan
        Calculator calc = new Calculator(); // no-arg constructor sekarang ada
        double result = calc.add(10).multiply(2).subtract(5).divide(3).getResult();
        System.out.println("Hasil akhir method chaining Calculator: " + result);

        // ===== RECURSIVE METHODS =====
        System.out.println("\n=== RECURSIVE METHODS ===");

        // Latihan 10: Implementasi dan penggunaan recursive methods
        // - Hitung faktorial menggunakan recursion
        int n = 5;
        System.out.println("Faktorial dari " + n + " = " + factorial(n));

        // - Hitung fibonacci menggunakan recursion
        System.out.println("Fibonacci ke-" + n + " = " + fibonacci(n));

        // - Implementasikan binary search recursive
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        int target = 9;
        int index = binarySearch(sortedArr, target, 0, sortedArr.length - 1);
        System.out.println("Binary search: Angka " + target + " ditemukan di index ke-" + index);

        // ===== UTILITY STATIC METHODS =====
        System.out.println("\n=== UTILITY STATIC METHODS ===");

        // Latihan 11: Membuat utility class dengan static methods
        // - Gunakan MathUtils untuk berbagai operasi matematika
        System.out.println("Max(10, 5): " + MathUtils.max(10, 5));
        System.out.println("Min(10, 5): " + MathUtils.min(10, 5));
        System.out.println("Average(10,20,30): " + MathUtils.average(10, 20, 30));

        // - Gunakan StringUtils untuk manipulasi string
        System.out.println("Reverse 'Hello': " + StringUtils.reverse("Hello"));
        System.out.println("To Upper 'java': " + StringUtils.toUpper("java"));

        // - Gunakan ArrayUtils untuk operasi array
        int[] reversedArr = ArrayUtils.reverseArray(numbers);
        System.out.print("Array dibalik: ");
        printArray(reversedArr);

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 12: Sistem kalkulator dengan method overloading
        // - Implementasikan calculator yang bisa handle berbagai tipe data dan operasi
        System.out.println("Tambah (int): " + OverloadedCalculator.add(5, 10));
        System.out.println("Tambah (double): " + OverloadedCalculator.add(5.5, 2.3));
        System.out.println("Tambah (3 int): " + OverloadedCalculator.add(1, 2, 3));

        // Latihan 13: Sistem processing data dengan static utilities
        // - Implementasikan data processor dengan berbagai method utility
        int[] data = {10, 20, 30, 40, 50};
        System.out.println("Rata-rata data: " + DataProcessor.getAverage(data));
        System.out.println("Total data: " + DataProcessor.getSum(data));
    }

    // ===== METHOD OVERLOADING EXAMPLES =====

    // TODO: Implementasikan method calculate yang di-overload

    public static int calculate(int a, int b) {
        // Penjumlahan dua integer
        return a + b;
    }

    public static double calculate(double a, double b) {
        // Penjumlahan dua double
        return a + b;
    }

    public static int calculate(int a, int b, int c) {
        // Penjumlahan tiga integer
        return a + b + c;
    }

    public static String calculate(String a, String b) {
        // Concatenation dua string
        return a + b;
    }

    // ===== PRINT METHOD OVERLOADING =====

    public static void print(int value) {
        // Print integer dengan format khusus
        System.out.println("Integer value: " + value);
    }

    public static void print(double value) {
        // Print double dengan format khusus
        System.out.println("Double value: " + value);
    }

    public static void print(String value) {
        // Print string dengan format khusus
        System.out.println("String value: " + value);
    }

    public static void print(int[] array) {
        // Print array dengan format khusus
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ===== STATIC VS INSTANCE METHODS =====

    public static int getCounter() {
        // Return nilai counter static
        return counter;
    }

    public static void incrementCounter() {
        // Increment counter static
        counter++;
    }

    public String getInstanceName() {
        // Return instance name
        return instanceName;
    }

    public void setInstanceName(String name) {
        // Set instance name
        this.instanceName = name;
    }

    public void displayInfo() {
        // Display instance dan static information
        System.out.println("Instance Name: " + instanceName + ", Counter: " + counter);
    }

    // ===== PASS BY VALUE DEMONSTRATIONS =====

    public static void modifyPrimitive(int number) {
        // Modify parameter dan print perubahan
        System.out.println("Dalam method modifyPrimitive, sebelum ubah: " + number);
        number = 99;
        System.out.println("Dalam method modifyPrimitive, sesudah ubah: " + number);
    }

    public static void modifyArray(int[] array) {
        // Modify isi array
        array[0] = 999;
        System.out.println("Isi array di dalam method modifyArray telah diubah.");
    }

    public static void reassignArray(int[] array) {
        // Reassign reference array
        array = new int[]{7, 8, 9};
        System.out.println("Reference array di dalam method reassignArray telah diganti.");
    }

    // ===== ARRAY METHODS =====

    // Existing implementation kept; tambahkan wrapper sesuai pemanggilan main
    public static int[] sortArrayCopy(int[] original) {
        // Return sorted copy tanpa mengubah original
        int[] copy = original.clone();
        Arrays.sort(copy);
        return copy;
    }

    public static double[] getArrayStats(int[] array) {
        // Return array [min, max, average]
        int min = array[0], max = array[0];
        double sum = 0;
        for (int n : array) {
            if (n < min) min = n;
            if (n > max) max = n;
            sum += n;
        }
        double avg = sum / array.length;
        return new double[]{min, max, avg};
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        // Merge dua array dan return hasil
        int[] merged = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        return merged;
    }

    // ----- WRAPPER METHODS (perbaikan nama sesuai pemanggilan di main) -----
    public static int[] sortArray(int[] arr) {
        return sortArrayCopy(arr);
    }

    public static double[] getStatistics(int[] arr) {
        return getArrayStats(arr);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        return binarySearchRecursive(array, target, left, right);
    }

    public static void printArray(int[] array) {
        print(array);
    }
    // -----------------------------------------------------------------------

    // ===== VARIABLE ARGUMENTS (VARARGS) =====

    public static int sum(int... numbers) {
        // Hitung sum dari varargs
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // Diganti supaya bisa menerima campuran tipe (int, String, dll.) sesuai pemanggilan
    public static void printInfo(String title, Object... values) {
        // Print title dan semua values
        System.out.print(title + ": ");
        for (Object v : values) System.out.print(v + " ");
        System.out.println();
    }

    // ===== RECURSIVE METHODS =====

    public static long factorial(int n) {
        // Implementasi factorial recursive
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        // Implementasi fibonacci recursive
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        // Implementasi binary search recursive
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        if (array[mid] > target)
            return binarySearchRecursive(array, target, left, mid - 1);
        else
            return binarySearchRecursive(array, target, mid + 1, right);
    }

    // ===== UTILITY CLASSES (INNER STATIC CLASSES) =====

    public static class MathUtils {
        public static double power(double base, int exponent) {
            // Implementasi power function
            double result = 1;
            for (int i = 0; i < exponent; i++) result *= base;
            return result;
        }

        public static boolean isPrime(int number) {
            // Check apakah number adalah prime
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }

        public static int gcd(int a, int b) {
            // Greatest Common Divisor
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        // Tambahan: max, min, average sesuai pemanggilan di main
        public static int max(int a, int b) { return (a > b) ? a : b; }
        public static int min(int a, int b) { return (a < b) ? a : b; }
        public static double average(int... nums) {
            int total = 0;
            for (int n : nums) total += n;
            return (double) total / nums.length;
        }
    }

    public static class StringUtils {
        public static String reverse(String str) {
            // Reverse string
            return new StringBuilder(str).reverse().toString();
        }

        public static boolean isPalindrome(String str) {
            // Check palindrome
            return str.equalsIgnoreCase(reverse(str));
        }

        public static int countWords(String str) {
            // Count words in string
            if (str == null || str.isEmpty()) return 0;
            return str.trim().split("\\s+").length;
        }

        // Tambahan yang dipakai di main
        public static String toUpper(String s) {
            return s == null ? null : s.toUpperCase();
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            // Print 2D array dengan format rapi
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }
        }

        public static int[] findDuplicates(int[] array) {
            java.util.Set<Integer> seen = new java.util.HashSet<>();
            java.util.Set<Integer> duplicates = new java.util.HashSet<>();
            for (int num : array) {
                if (!seen.add(num)) duplicates.add(num);
            }
            return duplicates.stream().mapToInt(Integer::intValue).toArray();
        }

        public static boolean areEqual(int[] array1, int[] array2) {
            // Compare dua array
            return java.util.Arrays.equals(array1, array2);
        }

        // Tambahan: reverseArray sesuai pemanggilan di main
        public static int[] reverseArray(int[] arr) {
            int[] copy = arr.clone();
            for (int i = 0; i < copy.length / 2; i++) {
                int temp = copy[i];
                copy[i] = copy[copy.length - 1 - i];
                copy[copy.length - 1 - i] = temp;
            }
            return copy;
        }
    }

    // ===== METHOD CHAINING EXAMPLE =====

    public static class Calculator {
        private double value;

        // Tambahkan constructor no-arg supaya pemanggilan new Calculator() di main valid
        public Calculator() {
            this.value = 0;
        }

        public Calculator(double initial) {
            this.value = initial;
        }

        public Calculator add(double n) {
            // Add dan return this untuk chaining
            this.value += n;
            return this;
        }

        public Calculator multiply(double n) {
            // Multiply dan return this untuk chaining
            this.value *= n;
            return this;
        }

        public Calculator subtract(double n) {
            // Subtract dan return this untuk chaining
            this.value -= n;
            return this;
        }

        public Calculator divide(double n) {
            if (n != 0) this.value /= n;
            return this;
        }

        public double getResult() {
            return value;
        }
    }

    // ===== TAMBAHAN: OverloadedCalculator & DataProcessor (dipanggil di main) =====

    public static class OverloadedCalculator {
        public static int add(int a, int b) { return a + b; }
        public static double add(double a, double b) { return a + b; }
        public static int add(int a, int b, int c) { return a + b + c; }
    }

    public static class DataProcessor {
        public static double getAverage(int[] arr) {
            int total = getSum(arr);
            return (double) total / arr.length;
        }

        public static int getSum(int[] arr) {
            int total = 0;
            for (int n : arr) total += n;
            return total;
        }
    }
}