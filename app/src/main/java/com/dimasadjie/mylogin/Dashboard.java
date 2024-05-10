package com.dimasadjie.mylogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    private String[] menuItems = {"Dimas Adjie", "Bayu Nur", "Badriatun", "Yoga", "Fariscal"};
    private int[] itemImages = {R.drawable.baseline_person_2_24, R.drawable.baseline_person_2_24, R.drawable.baseline_person_2_24, R.drawable.baseline_person_2_24, R.drawable.baseline_person_2_24};
    private String[] names = {"Dimas Adjie", "Bayu Nur", "Badriatun", "Yoga", "Fariscal"};
    private String[] numbers = {"085156625661", "987-654-3210", "555-555-5555", "111-222-3333", "444-555-6666"};
    private String[] addresses = {"Gunung Sindur, Kab. Bogor", "Pasar Kemis, Kab. Tangerang", "Ciseeng, Kab. Bogor", "Pondok Cabe, Tangerang Selatan", "Semplak, Kota Bogor"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        ListView listView = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, menuItems, itemImages, names, numbers, addresses);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = menuItems[position];
                String selectedName = adapter.getItemName(position);
                String selectedNumber = adapter.getItemNumber(position);
                String selectedAddress = adapter.getItemAddress(position);
                // Tampilkan informasi yang diklik dalam dialog
                showItemClickDialog(selectedItem, selectedName, selectedNumber, selectedAddress);
            }
        });
    }

    private void showItemClickDialog(String item, String name, String number, String address) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kontak Dipilih");
        builder.setMessage("Kontak: " + item + "\nNama: " + name + "\nNomer: " + number + "\nAlamat: " + address);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        builder.show();


    }
}
