public class SeriFilm extends Film {
    
    private int jumlahEpisode;
    private String platform;

    public SeriFilm(int idFilm, String judul, String sutradara, String genre, double rating,
            int jumlahEpisode, String platform) {
        super(idFilm, judul, sutradara, genre, rating);
        this.jumlahEpisode = jumlahEpisode;
        this.platform = platform;
    }

    public int getJumlahEpisode() {
        return jumlahEpisode;
    }

    public void setJumlahEpisode(int jumlahEpisode) {
        this.jumlahEpisode = jumlahEpisode;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void cetakDataSeri() {
        cetakData();
        System.out.println("Jumlah Episode : " + jumlahEpisode);
        System.out.println("Platform       : " + platform);
        System.out.println("---------------------------------");
    }

    public String infoStreaming() {
        return "Film seri '" + getJudul() + "' bisa ditonton di " + platform
                + " dengan total " + jumlahEpisode + " episode.";
    }
}