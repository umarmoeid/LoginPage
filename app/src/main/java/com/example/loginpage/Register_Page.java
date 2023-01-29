package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register_Page extends AppCompatActivity {



    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        EditText editFullName=findViewById(R.id.editFullName);
        EditText editMobile=findViewById(R.id.editMobileNumber);
        EditText editEmail=findViewById(R.id.editEmail);
        EditText editPassword =findViewById(R.id.editPassword);


        myRef= FirebaseDatabase.getInstance().getReference("User");
        user=new User();



        Button btnRegister=findViewById(R.id.btnSignup);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String fullName=editFullName.getText().toString();
            String mobile=editMobile.getText().toString();
            String email=editEmail.getText().toString();
            String pass=editPassword.getText().toString();

if(fullName!=null && mobile !=null && email != null && pass != null){
    storeDatatoDatabase(fullName,mobile,email,pass);
}
else{
    Toast.makeText(getApplicationContext(),"Some fields are empty",Toast.LENGTH_SHORT).show();
}

            }

        });

    }


    private void storeDatatoDatabase(String name,String mob,String em,String password){
user.setEmail(em);
user.setPassword(password);
user.setUserFullName(name);
user.setMobileNumber(mob);

myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        myRef.setValue(user);
        Toast.makeText(getApplicationContext(),"Data Stored",Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
Toast.makeText(getApplicationContext(),"Data not stored",Toast.LENGTH_SHORT).show();
    }
});
    }
}