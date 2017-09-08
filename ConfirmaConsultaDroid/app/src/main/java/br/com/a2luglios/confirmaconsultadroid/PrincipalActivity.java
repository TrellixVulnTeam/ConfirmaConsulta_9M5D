package br.com.a2luglios.confirmaconsultadroid;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.com.a2luglios.confirmaconsultadroid.fragment.FragmentAgenda;
import br.com.a2luglios.confirmaconsultadroid.fragment.FragmentMeusDados;
import br.com.a2luglios.confirmaconsultadroid.fragment.FragmentNotificacoes;

public class PrincipalActivity extends AppCompatActivity {

    private static final String[] permissions = {Manifest.permission.WRITE_CALENDAR};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_layout);

        PrincipalActivity.this.setTitle("Agenda");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissions, 101);
            }
        }

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_place, new FragmentAgenda());
        transaction.commit();

        ImageButton btnMeusDados = (ImageButton) findViewById(R.id.btnMeusDados);
        btnMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrincipalActivity.this.setTitle("Meus Dados");

                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_place, new FragmentMeusDados());
                transaction.commit();
            }
        });

        ImageButton btnAgenda = (ImageButton) findViewById(R.id.btnCalendario);
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrincipalActivity.this.setTitle("Agenda");

                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_place, new FragmentAgenda());
                transaction.commit();
            }
        });

        ImageButton btnNotificacoes = (ImageButton) findViewById(R.id.btnNotificacoes);
        btnNotificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrincipalActivity.this.setTitle("Notificações");

                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_place, new FragmentNotificacoes());
                transaction.commit();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
