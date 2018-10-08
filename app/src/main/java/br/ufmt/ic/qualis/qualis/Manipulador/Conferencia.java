package br.ufmt.ic.qualis.qualis.Manipulador;

import java.util.ArrayList;
import java.util.List;

public class Conferencia {

    private ArrayList data;
    private ArrayList<Json> jsonArrayList = new ArrayList<>();
    private Json json;


    public ArrayList<Json> getData() {
        ArrayList aux;


        for(int i=0;i<data.size();i++){
            aux = (ArrayList) data.get(i);

            json = new Json();
            json.setSiglas(aux.get(0).toString());
            json.setConferencia(aux.get(1).toString());
            json.setExtrato(aux.get(2).toString());

            jsonArrayList.add(json);
        }
        return jsonArrayList;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }


    public ArrayList<Json> getObjetc() {
        return getData();
    }
}
