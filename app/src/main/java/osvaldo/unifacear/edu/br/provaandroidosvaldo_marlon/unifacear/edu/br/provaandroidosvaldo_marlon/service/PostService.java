package osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.unifacear.edu.br.provaandroidosvaldo_marlon.service;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.MainActivity;
import osvaldo.unifacear.edu.br.provaandroidosvaldo_marlon.entity.Mensagem;

/**
 * Created by osval on 14/06/2019.
 */

public class PostService extends AsyncTask<Mensagem, String, String> {

    private String urlString = "http://10.30.40.135:8080/message";
    private MainActivity activity;

    @Override
    protected String doInBackground(Mensagem... mensagems) {

        try {

            JSONObject json = new JSONObject();
            json.put("usuario", mensagems[0].getUsuario());
            json.put("mensagem", mensagems[0].getMensagem());

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true);
            PrintStream printStream = new PrintStream(connection.getOutputStream());
            printStream.println(json.toString());

            connection.connect();
            connection.getInputStream();


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
