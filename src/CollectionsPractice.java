import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Collections
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * ArrayList, generics, operasi CRUD, dan iterasi collections.
         */

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        // Latihan 1: Demonstrasi keterbatasan array vs keunggulan ArrayList
        // - Buat array integer dengan ukuran tetap 3
        int[] angkaArray = new int[3];
        angkaArray[0] = 10;
        angkaArray[1] = 20;
        angkaArray[2] = 30;
        // Jika coba tambah elemen lagi seperti di bawah ini, akan error karena ukuran array sudah tetap:
        // angkaArray[3] = 40; // Error: ArrayIndexOutOfBoundsException

        // - Buat ArrayList<Integer> kosong
        ArrayList<Integer> angkaList = new ArrayList<>();

        // - Coba tambahkan 5 elemen ke array (akan error/terbatas)
        // - Tambahkan 5 elemen ke ArrayList (dinamis)
        angkaList.add(10);
        angkaList.add(20);
        angkaList.add(30);
        angkaList.add(40);
        angkaList.add(50);

        // - Print ukuran keduanya dan jelaskan perbedaannya dalam komentar
        System.out.println("Ukuran Array (tetap): " + angkaArray.length);
        System.out.println("Ukuran ArrayList (dinamis): " + angkaList.size());

        // - Print semua isi array
        System.out.print("\nIsi Array: ");
        for (int i = 0; i < angkaArray.length; i++) {
            System.out.print(angkaArray[i] + " ");
        }

        // - Print semua isi ArrayList
        System.out.print("\nIsi ArrayList: ");
        for (int nilai : angkaList) {
            System.out.print(nilai + " ");
        }

        // Perbedaan
        // 1. Array punya ukuran tetap sejak awal dibuat, tidak bisa ditambah atau dikurangi.
        // 2. ArrayList bersifat dinamis — bisa menambah, menghapus, dan ubah data dengan mudah.
        // 3. Array cocok untuk data yang ukurannya pasti.
        // 4. ArrayList cocok untuk data yang sering berubah-ubah.

        // ===== GENERICS DASAR =====
        System.out.println("\n=== GENERICS DASAR ===");

        // Latihan 2: Memahami generics dan type safety
        // - Buat ArrayList tanpa generics (raw type) dan tambahkan berbagai tipe data
        ArrayList listTanpaGenerics = new ArrayList();
        listTanpaGenerics.add("Teks");
        listTanpaGenerics.add(123);
        listTanpaGenerics.add(45.6);
        listTanpaGenerics.add(true);

        System.out.println("\nArrayList tanpa generics (raw type):");
        for (Object obj : listTanpaGenerics) {
            System.out.println(obj);
        }

        // - Buat ArrayList<String> dengan generics dan tambahkan hanya String
        ArrayList<String> listString = new ArrayList<>();
        listString.add("Satu");
        listString.add("Dua");
        listString.add("Tiga");

        System.out.println("\nArrayList dengan generics <String>:");
        for (String str : listString) {
            System.out.println(str);
        }

        // - Buat ArrayList<Double> untuk menyimpan nilai desimal
        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(10.5);
        listDouble.add(3.14);
        listDouble.add(99.9);

        System.out.println("\nArrayList dengan generics <Double>:");
        for (Double num : listDouble) {
            System.out.println(num);
        }

        // - Demonstrasikan type safety dengan mencoba menambahkan tipe yang salah
        System.out.println("\nDemonstrasi type safety:");
        System.out.println("Tidak bisa menambahkan tipe selain String ke listString, Java akan memberikan error saat compile.");


        // ===== OPERASI CRUD PADA ARRAYLIST =====
        System.out.println("\n=== OPERASI CRUD PADA ARRAYLIST ===");

        // Latihan 3: Create - Menambah data
        ArrayList<String> namaMahasiswa = new ArrayList<>();

        // - Tambahkan 5 nama mahasiswa menggunakan add()
        namaMahasiswa.add("Andi");
        namaMahasiswa.add("zarif");
        namaMahasiswa.add("Juan");
        namaMahasiswa.add("Fajril");
        namaMahasiswa.add("Eko");

        // - Tambahkan mahasiswa di posisi tertentu menggunakan add(index, element)
        namaMahasiswa.add(2, "Jeassen");

        // - Print daftar mahasiswa
        System.out.println("\nDaftar Mahasiswa (Setelah Create):");
        for (String nama : namaMahasiswa) {
            System.out.println(nama);
        }

        // ===== READ - MEMBACA DATA =====
        System.out.println("\n=== READ - MEMBACA DATA ===");

        // Latihan 4: Read - Membaca data
        // - Baca mahasiswa pertama menggunakan get(0)
        String pertama = namaMahasiswa.get(0);
        System.out.println("\nMahasiswa pertama: " + pertama);

        // - Baca mahasiswa terakhir
        String terakhir = namaMahasiswa.get(namaMahasiswa.size() - 1);
        System.out.println("Mahasiswa terakhir: " + terakhir);

        // - Cek apakah ada mahasiswa dengan nama tertentu menggunakan contains()
        boolean adaFajril = namaMahasiswa.contains("Fajril");
        System.out.println("Apakah ada 'Fajril'? " + adaFajril);

        // - Temukan index mahasiswa tertentu menggunakan indexOf()
        int indexJeassen = namaMahasiswa.indexOf("Jeassen");
        System.out.println("Index Jeassen: " + indexJeassen);

        // - Print ukuran ArrayList menggunakan size()
        System.out.println("Jumlah mahasiswa: " + namaMahasiswa.size());

        // ===== UPDATE - MENGUBAH DATA =====
        System.out.println("\n=== UPDATE - MENGUBAH DATA ===");

        // Latihan 5: Update - Mengubah data
        // - Ubah nama mahasiswa di index tertentu menggunakan set()
        namaMahasiswa.set(1, "Eben"); // ubah zarif jadi Eben

        // - Print daftar setelah update
        System.out.println("\nDaftar Mahasiswa (Setelah Update):");
        for (String nama : namaMahasiswa) {
            System.out.println(nama);
        }

        // Latihan 6: Delete - Menghapus data
        // - Hapus mahasiswa berdasarkan index menggunakan remove(index)
        namaMahasiswa.remove(2); // hapus Juan

        // - Hapus mahasiswa berdasarkan nama menggunakan remove(object)
        namaMahasiswa.remove("Fajril");

        // - Hapus semua mahasiswa menggunakan clear()
        namaMahasiswa.clear();

        // - Cek apakah ArrayList kosong menggunakan isEmpty()
        System.out.println("\nApakah daftar mahasiswa kosong? " + namaMahasiswa.isEmpty());

        // ===== ITERASI ARRAYLIST =====
        System.out.println("\n=== ITERASI ARRAYLIST ===");

        // Latihan 7: Berbagai cara iterasi
        ArrayList<Integer> angka = new ArrayList<>();

        // Isi dengan angka 10, 20, 30, 40, 50
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        // - Iterasi menggunakan traditional for loop
        System.out.println("\nIterasi dengan traditional for loop:");
        for (int i = 0; i < angka.size(); i++) {
            System.out.println("Index " + i + " : " + angka.get(i));
        }

        // - Iterasi menggunakan enhanced for loop (for-each)
        System.out.println("\nIterasi dengan enhanced for loop:");
        for (int nilai : angka) {
            System.out.println(nilai);
        }

        // - Iterasi menggunakan while loop
        System.out.println("\nIterasi dengan while loop:");
        int i = 0;
        while (i < angka.size()) {
            System.out.println(angka.get(i));
            i++;
        }

        // - Iterasi menggunakan Iterator
        System.out.println("\nIterasi dengan Iterator:");
        Iterator<Integer> iterator = angka.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ===== ARRAYLIST DENGAN TIPE DATA KOMPLEKS =====
        System.out.println("\n=== ARRAYLIST DENGAN TIPE DATA KOMPLEKS ===");

        // Latihan 8: ArrayList of Arrays (simulasi objects)
        // - Buat ArrayList<String[]> untuk menyimpan data mahasiswa (nama, nim, jurusan)
        ArrayList<String[]> dataMahasiswa = new ArrayList<>();

        // - Tambahkan 3 data mahasiswa
        // TODO: Tambahkan data mahasiswa
        dataMahasiswa.add(new String[]{"Jeassen", "2481037", "Teknik Informatika"});
        dataMahasiswa.add(new String[]{"Haykel", "2481048", "Sistem Informasi"});
        dataMahasiswa.add(new String[]{"Christoper", "2481036", "Desain UI/UX"});

        // - Print semua data dengan format tabel
        // TODO: Print dalam format tabel
        System.out.println("\nNama\t\tNIM\t\tJurusan");
        System.out.println("-------------------------------------");
        for (String[] mhs : dataMahasiswa) {
            System.out.println(mhs[0] + "\t\t" + mhs[1] + "\t" + mhs[2]);
        }

        // ===== UTILITY METHODS COLLECTIONS =====
        System.out.println("\n=== UTILITY METHODS COLLECTIONS ===");

        // Latihan 9: Eksplorasi Collections utility
        ArrayList<Integer> numbers = new ArrayList<>();
        // TODO: Isi dengan angka: 64, 34, 25, 12, 22, 11, 90
        angka.add(64);
        angka.add(34);
        angka.add(25);
        angka.add(12);
        angka.add(22);
        angka.add(11);
        angka.add(90);

        System.out.println("Data awal: " + angka);

        // - Gunakan Collections.sort() untuk mengurutkan
        // TODO: Sort list
        Collections.sort(angka);
        System.out.println("Setelah sort: " + angka);

        // - Gunakan Collections.reverse() untuk membalik urutan
        // TODO: Reverse list
        Collections.reverse(angka);
        System.out.println("Setelah reverse: " + angka);

        // - Gunakan Collections.shuffle() untuk mengacak
        // TODO: Shuffle list
        Collections.shuffle(angka);
        System.out.println("Setelah shuffle: " + angka);

        // - Gunakan Collections.max() dan Collections.min()
        // TODO: Find max dan min
        int max = Collections.max(angka);
        int min = Collections.min(angka);
        System.out.println("Nilai maksimum: " + max);
        System.out.println("Nilai minimum: " + min);

        // - Gunakan Collections.frequency() untuk menghitung kemunculan elemen
        // TODO: Count frequency
        int frekuensi = Collections.frequency(angka, 22);
        System.out.println("Frekuensi angka 22: " + frekuensi);

        // ===== SEARCHING DAN SORTING =====
        System.out.println("\n=== SEARCHING DAN SORTING ===");

        // Latihan 10: Implementasi search dan sort
        ArrayList<String> buah = new ArrayList<>();
        // TODO: Isi dengan: "Apel", "Jeruk", "Mangga", "Pisang", "Anggur"
        buah.add("Apel");
        buah.add("Jeruk");
        buah.add("Mangga");
        buah.add("Pisang");
        buah.add("Anggur");

        // - Sort secara alfabetis
        // TODO: Sort alphabetically
        Collections.sort(buah);
        System.out.println("Buah setelah sort alfabetis: " + buah);

        // - Implementasikan binary search pada list yang sudah diurutkan
        // TODO: Binary search
        int posisiMangga = Collections.binarySearch(buah, "Mangga");
        System.out.println("Posisi 'Mangga' (binary search): " + posisiMangga);

        // - Implementasikan linear search untuk list yang tidak diurutkan
        // TODO: Linear search
        buah.add("Durian");
        System.out.println("\nList buah tidak diurutkan: " + buah);
        String cari = "Jeruk";
        boolean ditemukan = false;
        for (int l = 0; l < buah.size(); l++) {
            if (buah.get(l).equalsIgnoreCase(cari)) {
                System.out.println("Buah '" + cari + "' ditemukan di index ke-" + l);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Buah '" + cari + "' tidak ditemukan.");
        }

        // ===== ARRAYLIST 2D =====
        System.out.println("\n=== ARRAYLIST 2D ===");

        // Latihan 11: ArrayList of ArrayList (2D dynamic array)
        // - Buat ArrayList<ArrayList<Integer>> untuk merepresentasikan matriks dinamis
        ArrayList<ArrayList<Integer>> matrix2D = new ArrayList<>();

        // - Buat 3 baris dengan panjang yang berbeda-beda
        // TODO: Create jagged 2D ArrayList
        ArrayList<Integer> baris1 = new ArrayList<>();
        baris1.add(1);
        baris1.add(2);
        baris1.add(3);

        ArrayList<Integer> baris2 = new ArrayList<>();
        baris2.add(4);
        baris2.add(5);

        ArrayList<Integer> baris3 = new ArrayList<>();
        baris3.add(6);
        baris3.add(7);
        baris3.add(8);
        baris3.add(9);

        matrix2D.add(baris1);
        matrix2D.add(baris2);
        matrix2D.add(baris3);

        // - Isi dengan nilai dan print dalam format matriks
        // TODO: Fill dan print matrix
        System.out.println("Matriks 2D:");
        for (ArrayList<Integer> baris : matrix2D) {
            for (int nilai : baris) {
                System.out.print(nilai + " ");
            }
            System.out.println();
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");

        // Latihan 12: Sistem manajemen perpustakaan sederhana
        ArrayList<String[]> daftarBuku = new ArrayList<>();

        // Format: [judul, pengarang, tahun, status] // status: "tersedia" atau "dipinjam"
        // - Tambahkan 5 buku
        // TODO: Tambahkan data buku
        daftarBuku.add(new String[]{"Laskar Pelangi", "Andrea Hirata", "2005", "tersedia"});
        daftarBuku.add(new String[]{"Bumi Manusia", "Pramoedya Ananta Toer", "1980", "tersedia"});
        daftarBuku.add(new String[]{"Negeri 5 Menara", "Ahmad Fuadi", "2009", "dipinjam"});
        daftarBuku.add(new String[]{"Dilan 1990", "Pidi Baiq", "2014", "tersedia"});
        daftarBuku.add(new String[]{"Pulang", "Leila S. Chudori", "2012", "dipinjam"});

        // - Implementasikan fungsi pinjam buku (ubah status)
        // TODO: Implementasikan pinjam buku
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase("Bumi Manusia")) {
                buku[3] = "dipinjam";
            }
        }

        // - Implementasikan fungsi kembalikan buku
        // TODO: Implementasikan kembalikan buku
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase("Negeri 5 Menara")) {
                buku[3] = "tersedia";
            }
        }

        // - Implementasikan pencarian buku berdasarkan judul
        // TODO: Implementasikan search buku
        String judulCari = "Dilan 1990";
        boolean ketemu = false;
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judulCari)) {
                System.out.println("\nBuku ditemukan: " + buku[0] + " (" + buku[3] + ")");
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("\nBuku dengan judul '" + judulCari + "' tidak ditemukan.");
        }

        // - Print daftar buku yang tersedia
        // TODO: Print available books
        System.out.println("\nDaftar buku yang tersedia:");
        for (String[] buku : daftarBuku) {
            if (buku[3].equalsIgnoreCase("tersedia")) {
                System.out.println(buku[0] + " - " + buku[1] + " (" + buku[2] + ")");
            }
        }

        // Latihan 13: Sistem nilai mahasiswa dinamis
        // TODO: Implementasikan sistem nilai yang bisa menambah mahasiswa dinamis
        ArrayList<String[]> nilaiMahasiswa = new ArrayList<>();

        // Format: [nama, mataKuliah, nilai]
        nilaiMahasiswa.add(new String[]{"Fajril", "Pemrograman web", "97"});
        nilaiMahasiswa.add(new String[]{"Kenzo", "Basis Data", "88"});
        nilaiMahasiswa.add(new String[]{"Zarif", "Alpro", "79"});

        System.out.println("\nData Nilai Mahasiswa:");
        for (String[] data : nilaiMahasiswa) {
            System.out.println(data[0] + " - " + data[1] + " : " + data[2]);
        }


        // ===== PERFORMANCE COMPARISON =====
        System.out.println("\n=== PERFORMANCE COMPARISON ===");

        // Latihan 14: Bandingkan performa Array vs ArrayList
        // TODO: Implementasikan comparison waktu akses, insert, search
        ArrayList<Integer> dataUji = new ArrayList<>();
        for (int n = 0; n < 10000; n++) {
            dataUji.add(n);
        }

        long waktumulai = System.nanoTime();
        Collections.reverse(dataUji);
        long waktuselesai = System.nanoTime();
        System.out.println("Waktu eksekusi reverse 10.000 elemen: " + (waktuselesai - waktumulai) + " ns");
    }

    // ===== HELPER METHODS =====
    // TODO: Implementasikan method-method pembantu di sini

    public static void printArrayList(ArrayList<?> list, String title) {
        // TODO: Print ArrayList dengan title
        System.out.println("\n" + title + ":");
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static int linearSearch(ArrayList<String> list, String target) {
        // TODO: Implementasi linear search
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void printMatrix2D(ArrayList<ArrayList<Integer>> matrix) {
        // TODO: Print 2D ArrayList matrix
        System.out.println("\nIsi Matriks 2D:");
        for (ArrayList<Integer> baris : matrix) {
            for (int nilai : baris) {
                System.out.print(nilai + " ");
            }
            System.out.println();
        }
    }

    public static boolean pinjamBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi pinjam buku
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul)) {
                if (buku[3].equalsIgnoreCase("tersedia")) {
                    buku[3] = "dipinjam";
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean kembalikanBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi kembalikan buku
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul)) {
                if (buku[3].equalsIgnoreCase("dipinjam")) {
                    buku[3] = "tersedia";
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static String[] cariBuku(ArrayList<String[]> daftarBuku, String judul) {
        // TODO: Implementasi cari buku
        for (String[] buku : daftarBuku) {
            if (buku[0].equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }

    public static double hitungRataRata(ArrayList<Integer> values) {
        // TODO: Hitung rata-rata
        if (values.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int nilai : values) {
            total += nilai;
        }
        return (double) total / values.size();
    }
}
