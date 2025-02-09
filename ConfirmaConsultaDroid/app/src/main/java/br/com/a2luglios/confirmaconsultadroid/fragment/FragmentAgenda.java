package br.com.a2luglios.confirmaconsultadroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.a2luglios.confirmaconsultadroid.R;
import br.com.a2luglios.confirmaconsultadroid.adapter.ConsultaAdapter;

import br.com.a2luglios.confirmaconsultadroid.firebase.FirebaseUtilDB;
import br.com.a2luglios.confirmaconsultadroid.modelo.Consulta;

/**
 * Created by ettoreluglio on 14/08/17.
 */

public class FragmentAgenda extends Fragment {

    private List<Consulta> consultas;
    private View agenda;
    private ProgressBar progressLoagind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        agenda = inflater.inflate(R.layout.fragment_agenda, container, false);
        progressLoagind = (ProgressBar) agenda.findViewById(R.id.progressLoading);

        final ListView listConsultas = (ListView) agenda.findViewById(R.id.listConsultas);
        carregaLista();

        listConsultas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Ir para detalher", Toast.LENGTH_LONG).show();
            }
        });

        Button btnAddConsulta = (Button) agenda.findViewById(R.id.btnAddConsulta);
        btnAddConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();

                FragmentBusca busca = new FragmentBusca();

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_place, busca);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return agenda;
    }

    private void carregaLista() {
        consultas = new ArrayList<>();
        final ListView listConsultas = (ListView) agenda.findViewById(R.id.listConsultas);

        new FirebaseUtilDB().readRTDBConsultas(new FirebaseUtilDB.FirebaseRTDBUpdateLista<Consulta>() {
            @Override
            public void updateConsultas(List<Consulta> lista) {
                consultas = lista;
                consultas.sort(new Comparator<Consulta>() {
                    @Override
                    public int compare(Consulta consulta1, Consulta consulta2) {
                        return (int) (consulta1.getDataInicio() - consulta2.getDataInicio());
                    }
                });
                ConsultaAdapter adapter = new ConsultaAdapter(getContext(), consultas);
                adapter.setListener(new ConsultaAdapter.Update() {
                    @Override
                    public void update() {
                        carregaLista();
                    }
                });
                listConsultas.setAdapter(adapter);
                progressLoagind.setIndeterminate(false);
            }
        });
    }

}
