package br.ufmt.ic.qualis.qualis.Requests;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.ufmt.ic.qualis.qualis.Manipulador.Conferencia;
import br.ufmt.ic.qualis.qualis.Manipulador.Periodico;

public class HttpPeriodicos extends AsyncTask<Void, Void, Periodico> {

    private final String opcao;

    public HttpPeriodicos(String opcao) {
        this.opcao = opcao;
    }

    protected Periodico doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        URL url;
        try {

            url = new URL("http://qualis.ic.ufmt.br/periodico.json");


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(resposta.toString(), Periodico.class);
    }
}
