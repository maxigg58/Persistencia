package curso3.semana3.unam.petagram;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    int cantidadClickBuhos = 0;
    int cantidadClickAves = 0;
    int cantidadClickConejos = 0;
    int cantidadClickGatos = 0;
    int cantidadClickPerros = 0;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public MascotaAdaptador() {
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
        final Mascota mascota = mascotas.get(position); // El objeto obtiene la posicion de cada recicler


        holder.imgFotoCV.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvRatingCV.setText(mascota.getRating());

        holder.ibFavoritosCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setFavorito(true);
                Log.d("mjfa",holder.tvNombreCV.getText()+" Favorito: "+mascota.isFavorito());
            }
        });

        final int[] cantidadClicks = new int[5];

        holder.ibRatingCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.tvNombreCV.getText().equals("Nival")){
                    cantidadClickBuhos+=1;
                    cantidadClicks[position] +=1;
                    holder.tvRatingCV.setText(""+cantidadClickBuhos);               // Forma 1 - Variables individuales
                }
                if (holder.tvNombreCV.getText().equals("Australiano")){
                    cantidadClickAves+=1;
                    cantidadClicks[position] +=1;
                    holder.tvRatingCV.setText(""+cantidadClicks[position]);         // Forma 2 - Array
                }
                if(holder.tvNombreCV.getText().equals("Roger Rabbit")){
                    cantidadClickConejos+=1;
                    cantidadClicks[position] +=1;
                    holder.tvRatingCV.setText(""+cantidadClicks[position]);         // Forma 2 - Array
                }
                if (holder.tvNombreCV.getText().equals("Apapacho")){
                    cantidadClickGatos+=1;
                    cantidadClicks[position] +=1;
                    holder.tvRatingCV.setText(""+cantidadClicks[position]);         // Forma 2 - Array
                }
                if (holder.tvNombreCV.getText().equals("Golden Retriever")){
                    cantidadClickPerros+=1;
                    cantidadClicks[position] +=1;
                    holder.tvRatingCV.setText(""+cantidadClicks[position]);         // Forma 2 - Array
                }
            }
        });
    }


    // Cantidad de elementos que contiene mi lista mascotas
    @Override
    public int getItemCount() {
        return mascotas.size();
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
