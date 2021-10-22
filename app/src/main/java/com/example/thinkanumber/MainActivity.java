package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button egyKockaGomb, kettoKockaGomb, dobasGomb, resetGomb;
    private TextView eredmeny;
    private ImageView kocka1, kocka2;
    private int megjelenitettKockakSzama, elsoKockaErteke, masodikKockaErteke, osszeg;
    private String dobasok,eredmenyek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        egyKockaGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(View.GONE);
                megjelenitettKockakSzama=1;
            }
        });

        kettoKockaGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(View.VISIBLE);
                megjelenitettKockakSzama=2;
            }
        });

        dobasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobas();
            }
        });

        resetGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    private void melyikKep(int randomSzam, ImageView imegeView) {
        switch (randomSzam) {
            case 1:
                imegeView.setImageResource(R.drawable.kocka1);
                break;
            case 2:
                imegeView.setImageResource(R.drawable.kocka2);
                break;
            case 3:
                imegeView.setImageResource(R.drawable.kocka3);
                break;
            case 4:
                imegeView.setImageResource(R.drawable.kocka4);
                break;
            case 5:
                imegeView.setImageResource(R.drawable.kocka5);
                break;
            case 6:
                imegeView.setImageResource(R.drawable.kocka6);
                break;
        }
    }

    private void dobas(){
        elsoKockaErteke=(int)(Math.random() * 6) + 1;
        dobasok=elsoKockaErteke+"";
        melyikKep(elsoKockaErteke,kocka1);
        if (megjelenitettKockakSzama == 1) {
            melyikKep(elsoKockaErteke,kocka1);
        }else{
            masodikKockaErteke=(int)(Math.random() * 6) + 1;
            osszeg=elsoKockaErteke+masodikKockaErteke;
            melyikKep(elsoKockaErteke,kocka1);
            melyikKep(masodikKockaErteke,kocka2);
            dobasok=osszeg+" "+" ("+elsoKockaErteke+"+"+masodikKockaErteke+")";
        }
        Toast.makeText(getApplicationContext(), dobasok, Toast.LENGTH_SHORT).show();
        eredmenyek=dobasok+"\n"+eredmenyek;
        eredmeny.setText(eredmenyek);
    }

    private void reset(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Reset");
        builder.setMessage("Biztos, hogy töröni szeretné az eddigi dobásokat");
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                closeContextMenu();
            }
        });
        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                uj();
            }
        });
        builder.create().show();
    }

    private void uj(){
        eredmeny.setText("");
        kocka1.setImageResource(R.drawable.kocka1);
        kocka2.setImageResource(R.drawable.kocka1);
        kocka2.setVisibility(View.VISIBLE);
        osszeg=0;
    }

    private void init(){
        egyKockaGomb=findViewById(R.id.btn_kocka1);
        kettoKockaGomb=findViewById(R.id.btn_kocka2);
        dobasGomb=findViewById(R.id.btn_dobas);
        resetGomb=findViewById(R.id.btn_reset);
        eredmeny=findViewById(R.id.txv_eredmeny);
        kocka1=findViewById(R.id.kepKocka1);
        kocka2=findViewById(R.id.kepKocka2);
        osszeg=0;

    }
}