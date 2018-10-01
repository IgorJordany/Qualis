package br.ufmt.ic.qualis.qualis.Manipulador;

import java.util.ArrayList;
import java.util.List;

public class CEP {

    private ArrayList data;
    private List<Conferencia> conferenciaList;
    private Conferencia conferencia;


    public Object getData() {
        ArrayList aux;


        for(int i=0;i<data.size();i++){
            aux = (ArrayList) data.get(i);

            conferencia = new Conferencia();
            conferencia.setSiglas(aux.get(0).toString());
            conferencia.setConferencia(aux.get(1).toString());
            conferencia.setExtrato(aux.get(2).toString());
        }

        return  conferencia;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }


    public Conferencia getObjetc() {
        return (Conferencia) getData();
    }
}
