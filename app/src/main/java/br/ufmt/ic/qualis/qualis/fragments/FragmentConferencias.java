package br.ufmt.ic.qualis.qualis.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import br.ufmt.ic.qualis.qualis.Manipulador.Conferencia;
import br.ufmt.ic.qualis.qualis.Requests.HttpConferencias;
import br.ufmt.ic.qualis.qualis.R;

public class FragmentConferencias extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_conferencias,container,false);
        final EditText btn_cep = view.findViewById(R.id.etMain_cep);

        final TextView respostaSiglas = view.findViewById(R.id.textSiglas);
        final TextView respostaConferencias = view.findViewById(R.id.texConferecias);
        final TextView respostaExtrato = view.findViewById(R.id.textExtrato);


        Button btnBuscarCep = (Button) view.findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Conferencia retorno = new HttpConferencias("conferencia").execute().get();
                    respostaSiglas.setText((String)retorno.getObjetc().getSiglas());
                    respostaConferencias.setText((String) retorno.getObjetc().getConferencia());
                    respostaExtrato.setText((String) retorno.getObjetc().getExtrato());


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });


        return view;


    }


}
