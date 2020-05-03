package com.example.crudammi.ui.aktivitasfisik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudammi.R;
import com.example.crudammi.api.ApiConfig;
import com.example.crudammi.api.ApiInterface;
import com.example.crudammi.models.InputAktifitas;
import com.example.crudammi.models.KeteranganAktifitas;
import com.example.crudammi.models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class AktivitasfisikActivity extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {

    private TextView tvDisplayChoice;
   // public static String[] list;

  //  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivitasfisik);

        tvDisplayChoice=findViewById(R.id.tvDisplayChoice);

        //inisialisasi progress dialog sebelum dipanggil
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Mengidentifikasi jenis aktifitas...");
//        progressDialog.setCancelable(false);

       // getAllInputAktifitas();

        Button btnSelectChoice=findViewById(R.id.btnSelectChoice);
        btnSelectChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog=new SingleChoiceDialogFragment();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Choice Dialog");
            }
        });

        Button btnSelectChoicetwo=findViewById(R.id.btnSelectChoicetwo);
        btnSelectChoicetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment myDialog=new DuoChoiceDialogFragment();
                myDialog.setCancelable(false);
                myDialog.show(getSupportFragmentManager(), "Choice Dialog");
            }
        });

    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        tvDisplayChoice.setText("Select choice = " + list[position]);
        //getSingleKeteranganAktifitas(String.valueOf(idKeteranganAktifitas));
    }

    @Override
    public void onNegativeButtonClicked() {
        tvDisplayChoice.setText("Select Item");
    }

}


//    public void getAllInputAktifitas() {
//        //Creating Retrofit rest adapter
//        //Creating an object of our api interface
//        ApiInterface api = new ApiConfig().instance();
//        Call<ArrayList<InputAktifitas>> call = api.getAllInputAktifitas();
//        progressDialog.show();
//
//        call.enqueue(new Callback<ArrayList<InputAktifitas>>() {
//            @Override
//            public void onResponse(Call<ArrayList<InputAktifitas>> call, Response<ArrayList<InputAktifitas>> response) {
//                progressDialog.hide();
//                list = new String[response.body().size()];
//                for (int i=0; i<response.body().size(); i++) {
//                    list[i]=response.body().get(i).getWaktuAktifitas();
//                }
//               // Toast.makeText(AktivitasfisikActivity.this, Arrays.toString(list), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<InputAktifitas>> call, Throwable t) {
//                progressDialog.hide();
//            }
//        });
//    }


//    public void getSingleKeteranganAktifitas(String idKeteranganAktifitas) {
//        //Creating Retrofit rest adapter
//        //Creating an object of our api interface
//        ApiInterface api = new ApiConfig().instance();
//        Call<ArrayList<KeteranganAktifitas>> call = api.getSingleKeteranganAktivitas(idKeteranganAktifitas);
//        progressDialog.show();
//
//        call.enqueue(new Callback<ArrayList<KeteranganAktifitas>>() {
//            @Override
//            public void onResponse(Call<ArrayList<KeteranganAktifitas>> call, Response<ArrayList<KeteranganAktifitas>> response) {
//                tvDisplayChoice.setText("Aktivitas = "+response.body().get(0).getKetAktifitas());
//                progressDialog.hide();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<KeteranganAktifitas>> call, Throwable t) {
//
//            }
//        });
//    }


