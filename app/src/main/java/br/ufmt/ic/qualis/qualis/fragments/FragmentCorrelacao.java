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
import br.ufmt.ic.qualis.qualis.Manipulador.Correlacao;
import br.ufmt.ic.qualis.qualis.R;
import br.ufmt.ic.qualis.qualis.Requests.HttpConferencias;
import br.ufmt.ic.qualis.qualis.Requests.HttpCorrelacao;

public class FragmentCorrelacao extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_correlacao,container,false);
        final EditText btn_cep = view.findViewById(R.id.etMain_cep);

        final TextView respostaIssn = view.findViewById(R.id.textIssn);
        final TextView respostaPeriodico = view.findViewById(R.id.texPeriodico);
        final TextView respostaExtratoComp = view.findViewById(R.id.textExtratoComp);
        final TextView respostaExtrato = view.findViewById(R.id.textExtrato);
        final TextView respostaArea = view.findViewById(R.id.textArea);


        Button btnBuscarCep = (Button) view.findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Correlacao retorno = new HttpCorrelacao("correlacao").execute().get();
                    respostaIssn.setText((String)retorno.getObjetc().getIssn());
                    respostaPeriodico.setText((String) retorno.getObjetc().getPeriodico());
                    respostaExtratoComp.setText((String) retorno.getObjetc().getExtratocomp());
                    respostaExtrato.setText((String) retorno.getObjetc().getExtrato());
                    respostaArea.setText((String) retorno.getObjetc().getArea());


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
