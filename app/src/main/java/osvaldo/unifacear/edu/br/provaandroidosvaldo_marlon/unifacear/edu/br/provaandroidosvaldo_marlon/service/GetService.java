package osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.unifacear.edu.br.provaandroidosvaldo_marlon.service;


import android.app.ProgressDialog;
import android.content.Context;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.ListActivity;
import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.entity.Mensagem;


public class GetService extends AsyncTask <String,String,String>{

    private String urlString = "http://10.30.40.135:8080/message";
    private static List<Mensagem> lista;
    private ProgressDialog dialog;
    private Context context;
    private ListActivity activity;

    public GetService(Context context) {
        this.context = context;
    }

    public void setActivity(ListActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setTitle("Por favor aguarde");
        dialog.setMessage("Carregando...");
        dialog.show();
    }
    @Override
    protected String doInBackground(String... strings ) {
        JSONObject json = new JSONObject();

        try{


            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json.toString());

            connection.connect();

            connection.getOutputStream();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();

            String result;

            while((result = br.readLine()) != null){
                sb.append(result + "\n");
            }

            br.close();
            return sb.toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        try{
            JSONArray jsonArray = new JSONArray(result);
            List<Mensagem> mensagens = new ArrayList<>();

            for(int i = 0 ; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                Mensagem mensagem = new Mensagem();
                mensagem.setUsuario(object.getString("usuario"));
                mensagem.setMensagem(object.getString("mensagem"));

                mensagens.add(mensagem);

                dialog.dismiss();
            }

            activity.listar(mensagens);
            lista = mensagens;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mensagem> getLista(){
        return this.lista;
    }


}
