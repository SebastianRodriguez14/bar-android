package idat.com.bar_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import idat.com.bar_android.db.DbUsers;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText inEmail, inPassword;

    TextView textView;
    Button btn_menuRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseApp.initializeApp(this);
        textView = findViewById(R.id.text_login);
        inEmail = findViewById(R.id.editText_Correo_R);
        inPassword = findViewById(R.id.editText_Clave_R);
        btn_menuRegister = findViewById(R.id.btnMenu_R);
        mAuth = FirebaseAuth.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_menuRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inEmail.getText().toString();
                String password = inPassword.getText().toString();
                System.out.println(" DATOS DEL USUARIO - REGISTRAR");
                System.out.println("Correo: " + email);
                System.out.println("Contraseña: " + password);
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Complete los campos!!!", Toast.LENGTH_SHORT).show();
                } else {
                    DbUsers dbUsers = new DbUsers(RegisterActivity.this);
                    boolean exists = dbUsers.isUserExists(email, password);
                    if(exists){
                        Toast.makeText(RegisterActivity.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegisterActivity.this, "Inicie sesion para acceder", Toast.LENGTH_SHORT).show();
                    } else{
                        long id = dbUsers.insertUser(email, password);
                        if(id > 0){
                            Log.d("RegisterActivity:","Usuario creado correctamente en la base de datos = sqlite");
                            //Toast.makeText(RegisterActivity.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                            mAuth.createUserWithEmailAndPassword(email,password)
                                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(RegisterActivity.this,"Usuario creado", Toast.LENGTH_SHORT).show();
                                                        limpiarCampos();
                                                        //volviendo al login
                                                        Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    } else {
                                                        Toast.makeText(RegisterActivity.this,"Usuario no creado", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                        } else{
                            Toast.makeText(RegisterActivity.this, "Usuario no creado", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
            }
        });
    }

    private void limpiarCampos(){
        inEmail.setText("");
        inPassword.setText("");
        inPassword.clearFocus();
    }
}