package osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.entity.Mensagem;
import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.unifacear.edu.br.provaandroidosvaldo_marlon.service.PostService;

public class MainActivity extends AppCompatActivity {
    Mensagem mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagem = new Mensagem();

        EditText edtUsuario = findViewById(R.id.edtUsuario);
        EditText edtMensagem = findViewById(R.id.edtMensagem);
        Button btnEnviar = findViewById(R.id.btnEnviar);


    }

    public void click(View v){
        Button btnEnviar = findViewById(R.id.btnEnviar);
        EditText edtUsuario = findViewById(R.id.edtUsuario);
        EditText edtMensagem = findViewById(R.id.edtMensagem);

        mensagem.setUsuario(edtUsuario.getText().toString());
        mensagem.setMensagem(edtMensagem.getText().toString());

        new PostService().execute(mensagem);
        edtUsuario.setText("");
        edtMensagem.setText("");

    }

    public void mudaTela(View v2){
        Button btnListar = findViewById(R.id.btnListar);
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

}
