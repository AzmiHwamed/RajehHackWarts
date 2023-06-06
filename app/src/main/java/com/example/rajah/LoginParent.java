package com.example.rajah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginParent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_parent);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth mAuth=FirebaseAuth.getInstance();
                EditText email=findViewById(R.id.emailparent);
                EditText pass=findViewById(R.id.passparent);
                mAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference usersRef = database.getReference("Users");
                            DatabaseReference userRef = usersRef.child(mAuth.getCurrentUser().getUid());
                            ValueEventListener valueEventListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        String userType = dataSnapshot.child("type").getValue(String.class);
                                        if(userType.equals("parent")){
                                            startActivity(new Intent(getApplicationContext(),PodCastListParent.class));
                                        }
                                        else{
                                            Toast.makeText(LoginParent.this, "Not A parent Account\nليس حساب ولي ", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            };

                            userRef.addValueEventListener(valueEventListener);

                        }
                        else{
                            Toast.makeText(LoginParent.this, "No user with exists with this creds\nلا يوجد حساب بهذه البيانات ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
});
}
}