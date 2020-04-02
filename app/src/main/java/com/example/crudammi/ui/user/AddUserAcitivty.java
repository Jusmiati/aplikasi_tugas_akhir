package com.example.crudammi.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;
import com.example.crudammi.api.ApiConfig;
import com.example.crudammi.api.ApiInterface;
import com.example.crudammi.models.User;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserAcitivty extends AppCompatActivity {
    ProgressDialog progressDialog;

    private RadioGroup radioGroup;
    String rokokData;
    //private RadioButton radioButton;
    //private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_acitivty);

        radioGroup =findViewById(R.id.radio);
        RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        rokokData = "";

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton rB = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            boolean isChecked = rB.isChecked();
            if (isChecked) {
                rokokData = rB.getText().toString();
                Toast.makeText(getBaseContext(), rokokData, Toast.LENGTH_SHORT).show();
            }
        });

        //inisialisasi progress dialog sebelum dipanggil
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Mengirim data...");
        progressDialog.setCancelable(false);

        EditText namaET = findViewById(R.id.nameET);
        EditText genderET = findViewById(R.id.genderET);
        EditText umurET = findViewById(R.id.umurET);
        EditText nohpET = findViewById(R.id.nohpET);
        EditText nohpkeluargaET = findViewById(R.id.nohpkeluargaET);
        EditText alamatET = findViewById(R.id.alamatET);
        EditText tahunJantungaET = findViewById(R.id.tahunJantungET);
        EditText pendTerakhirET = findViewById(R.id.pendidikanET);
        EditText pekerjaanET = findViewById(R.id.pekerjaanET);
        EditText penghasilanET = findViewById(R.id.penghasilanET);
        EditText agamaET = findViewById(R.id.agamaET);
        EditText sukuET = findViewById(R.id.sukuET);
        TextView rokokET = findViewById(R.id.rokokET);
        EditText alkoholET = findViewById(R.id.alkoholET);
        Button tambahUser = findViewById(R.id.addUserDataBTN);

        tambahUser.setOnClickListener(v -> {
           // String rokok = addListenerOnButton();
            JsonObject body = new JsonObject();
            body.addProperty("nama", namaET.getText().toString());
            body.addProperty("gender", genderET.getText().toString());
            body.addProperty("umur", umurET.getText().toString());
            body.addProperty("no_hp", nohpET.getText().toString());
            body.addProperty("no_hp_keluarga", nohpkeluargaET.getText().toString());
            body.addProperty("alamat", alamatET.getText().toString());
            body.addProperty("tahun_jantung", tahunJantungaET.getText().toString());
            body.addProperty("pendidikan_terakhir", pendTerakhirET.getText().toString());
            body.addProperty("pekerjaan", pekerjaanET.getText().toString());
            body.addProperty("penghasilan", penghasilanET.getText().toString());
            body.addProperty("agama", agamaET.getText().toString());
            body.addProperty("suku", sukuET.getText().toString());
            body.addProperty("rokok", rokokData);
            body.addProperty("alkohol", alkoholET.getText().toString());
            Log.d("payload: ", body.toString());
            getSingleUser(body);
        });
    }

    public void getSingleUser(JsonObject body) {
        //Creating Retrofit rest adapter
        //Creating an object of our api interface
        ApiInterface api = new ApiConfig().instance();
        Call<User> call = api.addUser(body);

        //munculkan progres dialog
        progressDialog.show();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                finish();
                Toast.makeText(AddUserAcitivty.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                progressDialog.hide();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                /*Toast.makeText(AddUserAcitivty.this, t.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.hide();*/
                finish();
                Toast.makeText(AddUserAcitivty.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public String addListenerOnButton() {
//        radioGroup = (RadioGroup) findViewById(R.id.radio);
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//
//        // find the radiobutton by returned id
//        radioButton = (RadioButton) findViewById(selectedId);
////                radioButton = (RadioButton) findViewById(R.id.radio_one);
////                radioButton = (RadioButton) findViewById(R.id.radio_two);
////                radioButton = (RadioButton) findViewById(R.id.radio_three);
//
//        Toast.makeText(AddUserAcitivty.this, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
//        String data = "";
//        data = radioButton.getText().toString();
//        return data;
//    }
}
