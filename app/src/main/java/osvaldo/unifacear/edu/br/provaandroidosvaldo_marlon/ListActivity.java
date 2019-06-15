package osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;
import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.entity.Mensagem;
import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.unifacear.edu.br.provaandroidosvaldo_marlon.service.GetService;


public class ListActivity extends AppCompatActivity {
    private List<Mensagem> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ListView lv =findViewById(R.id.listaMensagem);

        GetService s = new GetService(lv.getContext());
        s.setActivity(this);
        s.execute();

    }

    public void listar(List<Mensagem> mensagens) {

        ArrayAdapter<Mensagem> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, mensagens);

        ListView lv = findViewById(R.id.listaMensagem);

        lv.setAdapter(arrayAdapter);
    }
}
