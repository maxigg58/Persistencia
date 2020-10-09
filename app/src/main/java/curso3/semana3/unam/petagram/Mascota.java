package curso3.semana3.unam.petagram;

public class Mascota {

    private int Foto;
    private String Nombre;
    private String Rating;
    private boolean Favorito;

    public Mascota(int foto, String nombre, String rating, boolean favorito) {
        Foto = foto;
        Nombre = nombre;
        Rating = rating;
        Favorito = favorito;
    }

    public Mascota() {
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public boolean isFavorito() {
        return Favorito;
    }

    public void setFavorito(boolean favorito) {
        Favorito = favorito;
    }
}
