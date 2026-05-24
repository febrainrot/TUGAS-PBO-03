import java.sql.*;

public class Film {

    private int idFilm;
    private String judul;
    private String sutradara;
    private String genre;
    private double rating;

    public Film() {
        this.idFilm = 0;
        this.judul = "";
        this.sutradara = "";
        this.genre = "";
        this.rating = 0.0;
    }

    public Film(String judul, String sutradara) {
        this.judul = judul;
        this.sutradara = sutradara;
        this.genre = "Umum";
        this.rating = 0.0;
    }

    public Film(int idFilm, String judul, String sutradara, String genre, double rating) {
        this.idFilm = idFilm;
        this.judul = judul;
        this.sutradara = sutradara;
        this.genre = genre;
        this.rating = rating;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void create(Connection conn) {
        String sql = "INSERT INTO film (judul, sutradara, genre, rating) VALUES ('"
                + judul + "', '" + sutradara + "', '" + genre + "', " + rating + ")";
        if (conn != null) {
            try {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO film (judul, sutradara, genre, rating) VALUES (?, ?, ?, ?)");
                stmt.setString(1, this.judul);
                stmt.setString(2, this.sutradara);
                stmt.setString(3, this.genre);
                stmt.setDouble(4, this.rating);
                stmt.executeUpdate();
                System.out.println("[CREATE] Film '" + judul + "' berhasil disimpan.");
            } catch (SQLException e) {
                System.out.println("[CREATE] Error: " + e.getMessage());
            }
        } else {
            System.out.println("[CREATE] SQL   : " + sql);
            System.out.println("[CREATE] Film '" + judul + "' berhasil disimpan.");
        }
    }

    public void update(Connection conn) {
        String sql = "UPDATE film SET sutradara='" + sutradara + "', genre='" + genre
                + "', rating=" + rating + " WHERE judul='" + judul + "'";
        if (conn != null) {
            try {
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE film SET sutradara=?, genre=?, rating=? WHERE judul=?");
                stmt.setString(1, this.sutradara);
                stmt.setString(2, this.genre);
                stmt.setDouble(3, this.rating);
                stmt.setString(4, this.judul);
                stmt.executeUpdate();
                System.out.println("[UPDATE] Film '" + judul + "' berhasil diperbarui.");
            } catch (SQLException e) {
                System.out.println("[UPDATE] Error: " + e.getMessage());
            }
        } else {
            System.out.println("[UPDATE] SQL   : " + sql);
            System.out.println("[UPDATE] Film '" + judul + "' berhasil diperbarui.");
        }
    }

    public void delete(Connection conn) {
        String sql = "DELETE FROM film WHERE judul='" + judul + "'";
        if (conn != null) {
            try {
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM film WHERE judul=?");
                stmt.setString(1, this.judul);
                stmt.executeUpdate();
                System.out.println("[DELETE] Film '" + judul + "' berhasil dihapus.");
            } catch (SQLException e) {
                System.out.println("[DELETE] Error: " + e.getMessage());
            }
        } else {
            System.out.println("[DELETE] SQL   : " + sql);
            System.out.println("[DELETE] Film '" + judul + "' berhasil dihapus.");
        }
    }

    public void cetakData() {
        System.out.println("---------------------------------");
        System.out.println("ID Film    : " + idFilm);
        System.out.println("Judul      : " + judul);
        System.out.println("Sutradara  : " + sutradara);
        System.out.println("Genre      : " + genre);
        System.out.println("Rating     : " + rating);
        System.out.println("---------------------------------");
    }

    public String read(Connection conn) {
        String sql = "SELECT * FROM film WHERE judul='" + judul + "'";
        if (conn != null) {
            try {
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT * FROM film WHERE judul=?");
                stmt.setString(1, this.judul);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return "Judul: " + rs.getString("judul")
                            + ", Sutradara: " + rs.getString("sutradara")
                            + ", Genre: " + rs.getString("genre")
                            + ", Rating: " + rs.getDouble("rating");
                }
                return "Film tidak ditemukan.";
            } catch (SQLException e) {
                return "Error: " + e.getMessage();
            }
        } else {
            System.out.println("[READ]  SQL   : " + sql);
            return "Judul: " + judul + ", Sutradara: " + sutradara
                    + ", Genre: " + genre + ", Rating: " + rating;
        }
    }

    public boolean isLayakTonton() {
        return this.rating >= 6.0;
    }

    public String getKategoriRating() {
        if (rating >= 9.0) {
            return "Masterpiece";
        } else if (rating >= 7.5) {
            return "Sangat Bagus";
        } else if (rating >= 6.0) {
            return "Bagus";
        } else if (rating >= 4.0) {
            return "Biasa Saja";
        } else {
            return "Kurang Bagus";
        }
    }
}