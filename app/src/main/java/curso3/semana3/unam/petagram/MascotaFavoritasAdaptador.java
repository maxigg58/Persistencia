package curso3.semana3.unam.petagram;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaFavoritasAdaptador extends RecyclerView.Adapter<MascotaFavoritasAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotasFavoritas;


    public MascotaFavoritasAdaptador(ArrayList<Mascota> mascotasFavoritas) {
        this.mascotasFavoritas = mascotasFavoritas;
    }

    public MascotaFavoritasAdaptador() {
    }


    // Inflar el layout y lo pasará al viewholder para que obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }


    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotasFavoritas.get(position); // El objeto obtiene la posicion de cada recicler

        holder.imgFotoCV.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvRatingCV.setText(mascota.getRating());
    }


    // Cantidad de elementos que contiene mi lista mascotasFavoritas
    @Override
    public int getItemCount() {
        return mascotasFavoritas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvRatingCV;
        private ImageButton ibRatingCV;
        private ImageButton ibFavoritosCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV       = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tv_Nombre);
            tvRatingCV      = (TextView) itemView.findViewById(R.id.tv_rating);
            ibRatingCV      = (ImageButton) itemView.findViewById(R.id.ib_rating);
            ibFavoritosCV   = (ImageButton) itemView.findViewById(R.id.ib_favoritos);
        }
    }
}
