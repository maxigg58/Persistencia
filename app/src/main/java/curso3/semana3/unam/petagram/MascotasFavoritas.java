package curso3.semana3.unam.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MascotasFavoritas extends AppCompatActivity {

    @BindView(R.id.ib_volver)
    ImageButton ibVolver;

    private RecyclerView listaMascotasFavoritas;
    ArrayList<Mascota> mascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        ButterKnife.bind(this);

        // De esta forma se recibe en SegundaActivity.java :
        ArrayList<Mascota> lista = (ArrayList<Mascota>) getIntent().getSerializableExtra("miLista");


        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rv_Mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaMascotasFavoritas.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(lista);
        listaMascotasFavoritas.setAdapter(adaptador);



/*        listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rv_Mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaMascotasFavoritas.setLayoutManager(llm);

        MascotaAdaptador adaptador = new MascotaAdaptador(lista);
        listaMascotasFavoritas.setAdapter(adaptador);

 */

        //inicializarListaMascotas();
        // inicializarAdaptador();
    }

    /*  Metodos  */
    public void inicializarListaMascotas() {
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota(R.drawable.buho, "Nival", "0", false));
        mascotasFavoritas.add(new Mascota(R.drawable.ave, "Australiano", "0", true));
        mascotasFavoritas.add(new Mascota(R.drawable.conejo, "Roger Rabbit", "0", true));
        mascotasFavoritas.add(new Mascota(R.drawable.gato, "Apapacho", "0", false));
        mascotasFavoritas.add(new Mascota(R.drawable.perro, "Golden Retriever", "0", false));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavoritas);
        listaMascotasFavoritas.setAdapter(adaptador);
    }

    @OnClick(R.id.ib_volver)
    public void onClick() {
        finish();
    }
}