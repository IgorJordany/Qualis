package br.ufmt.ic.qualis.qualis.Requests;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.ufmt.ic.qualis.qualis.Manipulador.Conferencia;
import br.ufmt.ic.qualis.qualis.Manipulador.Correlacao;

public class HttpCorrelacao extends AsyncTask<Void, Void, Correlacao> {

    private final String opcao;

    public HttpCorrelacao(String opcao) {
        this.opcao = opcao;
    }

    protected Correlacao doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        URL url;
        try {

            url = new URL("http://qualis.ic.ufmt.br/todos2.json");


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

        return new Gson().fromJson(resposta.toString(), Correlacao.class);
    }
}
