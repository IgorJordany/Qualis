package br.ufmt.ic.qualis.qualis.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import br.ufmt.ic.qualis.qualis.Manipulador.Conferencia;
import br.ufmt.ic.qualis.qualis.Manipulador.Json;
import br.ufmt.ic.qualis.qualis.Manipulador.Periodico;
import br.ufmt.ic.qualis.qualis.R;
import br.ufmt.ic.qualis.qualis.Requests.HttpConferencias;
import br.ufmt.ic.qualis.qualis.Requests.HttpPeriodicos;

public class FragmentPeriodicos extends Fragment {
    ArrayList<String> periodics=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView lv;
    SearchView sv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_periodicos,container,false);

        lv = (ListView) view.findViewById(R.id.lv);
        sv = (SearchView) view.findViewById(R.id.sv);

        try {
            fillData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spacecrafts);
        // ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spacecrafts);
        adapter = new ArrayAdapter<> (getActivity(), android.R.layout.simple_list_item_1,periodics);
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText (getActivity (), "Clique!", Toast.LENGTH_SHORT) .show ();
                Toast.makeText(getActivity (), adapter.getItem(position).getSiglas()+ adapter.getItem(position).getConferencia() + adapter.getItem(position).getExtrato(),Toast.LENGTH_LONG).show();

            }
        });
        */

        return view;
    }

    public void fillData() throws ExecutionException, InterruptedException {

        Periodico retorno = new HttpPeriodicos("periodico").execute().get();
        ArrayList<Json> aux = retorno.getData();

        int i = 0;
        while ( i < aux.size()){
            periodics.add(aux.get(i).getIssn()+" | "+ aux.get(i).getPeriodico() +" | "+ aux.get(i).getExtrato());
            i = i + 1;
        }
    }
}
