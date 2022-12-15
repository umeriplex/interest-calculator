package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    BankAcc bankAcc;
    EditText accNo, accBl, noYears, rate;
    Button btn;
    AD adapter;
    RecyclerView recView;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        accNo = findViewById(R.id.accNOet);
        accBl = findViewById(R.id.accBLet);
        noYears = findViewById(R.id.noOFYearsET);
        rate = findViewById(R.id.annIntRateET);
        btn = findViewById(R.id.calculateBTN);
        recView = findViewById(R.id.recView);

        btn.setOnClickListener(v->{
            if(TextUtils.isEmpty(accNo.getText().toString()) || TextUtils.isEmpty(accBl.getText().toString()) || TextUtils.isEmpty(noYears.getText().toString()) || TextUtils.isEmpty(rate.getText().toString())){
                Toast.makeText(this, "fields are empty", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (Integer.parseInt(accNo.getText().toString()) <= 0)
                binding.accNOet.setError("number should`t <= 0");
            else if(Integer.parseInt(accBl.getText().toString()) < 1000)
                binding.accBLet.setError("balance should`t < 1000");
            else if(Integer.parseInt(noYears.getText().toString()) < 0 )
                binding.accBLet.setError("year should`t < 0");
            else if(Integer.parseInt(rate.getText().toString()) < 0)
                binding.accBLet.setError("interest rate should`t < 0");
            else{
                binding.linearLayout3.setVisibility(View.VISIBLE);
                binding.recView.setVisibility(View.VISIBLE);
                cal();
            }


        });

    }

    private void cal(){
        bankAcc = new BankAcc(Integer.parseInt(accBl.getText().toString()),Integer.parseInt(accNo.getText().toString()),Integer.parseInt(rate.getText().toString()));
        bankAcc.computeInterest(Integer.parseInt(noYears.getText().toString()));
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new AD(this,bankAcc.accBLList);
        recView.setAdapter(adapter);

        binding.t1.setText("Account Number : "+accNo.getText().toString());
        binding.t2.setText("Opening Balance  : "+accBl.getText().toString());
        binding.t3.setText("Annual Interest Rate : "+rate.getText().toString()+"%");
        binding.t4.setText("No. Of Years : "+noYears.getText().toString());
        binding.t5.setText("Interest Earned Each Year : "+bankAcc.instPerYear);
        binding.t6.setText("Total Interest Earned : "+bankAcc.totalE);
        binding.t7.setText("Account Balance After "+noYears.getText().toString()+" Years : "+bankAcc.accBLY);


    }
}