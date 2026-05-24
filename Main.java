public class Main {
    public static void main(String[] args) {

        System.out.println("=== Data Film ===\n");

        System.out.println("Object 1  Constructor Tanpa Parameter");
        Film f1 = new Film();
        f1.setIdFilm(1);
        f1.setJudul("Swapped");
        f1.setSutradara("Nathan Greno");
        f1.setGenre("Animal Adventure");
        f1.setRating(7.9);
        f1.cetakData();

        System.out.println("Object 2  Constructor Judul dan Sutradara");
        Film f2 = new Film("Dilan 1990", "Fajar Bustomi");
        f2.setIdFilm(2);
        f2.setGenre("Romance");
        f2.setRating(8.0);
        f2.cetakData();

        System.out.println("Object 3  Constructor Semua Parameter");
        Film f3 = new Film(3, "KKN di Desa Penari", "Awi Suryadi", "Horror", 5.8);
        f3.cetakData();

        System.out.println("\n=== CRUD Method ===\n");

        System.out.println("* create");
        f1.create(null);

        System.out.println("* read");
        String hasil = f1.read(null);
        System.out.println("[READ] " + hasil);

        System.out.println("* update");
        f2.setRating(7.5);
        f2.update(null);

        System.out.println("* delete");
        f3.delete(null);System.out.println("* update");

        System.out.println("* cek kelayakan");
        System.out.println(f1.getJudul() + " layak tonton? " + f1.isLayakTonton());
        System.out.println(f3.getJudul() + " layak tonton? " + f3.isLayakTonton());

        System.out.println("* kategori rating");
        System.out.println(f1.getJudul() + " -> " + f1.getKategoriRating());
        System.out.println(f2.getJudul() + " -> " + f2.getKategoriRating());
        System.out.println(f3.getJudul() + " -> " + f3.getKategoriRating());

        System.out.println("\n=== Seri Film ===\n");

        SeriFilm fs = new SeriFilm(4, "Attack on Titan", "Tetsuro Araki",
        "Action", 9.0, 87, "Netflix");

        System.out.println("* method parent");
        fs.create(null);
        String hasilSeri = fs.read(null);
        System.out.println("[READ] " + hasilSeri);
        fs.update(null);

        System.out.println("* method turunan");
        fs.cetakDataSeri();
        System.out.println(fs.infoStreaming());

        System.out.println("\nselesai.");
    }
}