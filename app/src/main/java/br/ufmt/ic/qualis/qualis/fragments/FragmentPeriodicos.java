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
import br.ufmt.ic.qualis.qualis.Manipulador.Periodico;
import br.ufmt.ic.qualis.qualis.R;
import br.ufmt.ic.qualis.qualis.Requests.HttpConferencias;
import br.ufmt.ic.qualis.qualis.Requests.HttpPeriodicos;

public class FragmentPeriodicos extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_periodicos,container,false);
        final EditText btn_cep = view.findViewById(R.id.etMain_cep);

        final TextView respostaIssn = view.findViewById(R.id.textIssn);
        final TextView respostaPeriodicos = view.findViewById(R.id.texPeriodico);
        final TextView respostaExtrato = view.findViewById(R.id.textExtrato);


        Button btnBuscarCep = (Button) view.findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Periodico retorno = new HttpPeriodicos("conferencia").execute().get();
                    respostaIssn.setText((String)retorno.getObjetc().getIssn());
                    respostaPeriodicos.setText((String) retorno.getObjetc().getPeriodico());
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
