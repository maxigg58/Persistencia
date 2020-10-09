package curso3.semana3.unam.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ib_start)
    ImageButton ibStart;

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    //MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_Mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    /* Metodos */

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.buho, "Nival", "0", false));
        mascotas.add(new Mascota(R.drawable.ave, "Australiano", "1", true));
        mascotas.add(new Mascota(R.drawable.conejo, "Roger Rabbit", "0", false));
        mascotas.add(new Mascota(R.drawable.gato, "Apapacho", "0", false));
        mascotas.add(new Mascota(R.drawable.perro, "Golden Retriever", "0", false));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    @OnClick(R.id.ib_start)
    public void onClick() {
        ArrayList<Mascota> milista = new ArrayList<Mascota>();
        Intent intent = new Intent(this, MascotasFavoritas.class);
        intent.putExtra("miLista", milista);
        startActivity(intent);
    }
}