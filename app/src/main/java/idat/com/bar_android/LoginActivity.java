package idat.com.bar_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseUser;

import idat.com.bar_android.db.DbUsers;

public class LoginActivity extends AppCompatActivity {
    //-------------------
    private FirebaseAuth mAuth;
    EditText inputEmail, inputPassword;

    TextView textView;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //----------
        FirebaseApp.initializeApp(this);
        inputEmail = findViewById(R.id.editText_Correo);
        inputPassword = findViewById(R.id.editText_Clave);
        textView = findViewById(R.id.text_register);
        btnMenu = findViewById(R.id.btnAccederMenu);
        mAuth = FirebaseAuth.getInstance();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                System.out.println(" DATOS DEL USUARIO - LOGIN");
                System.out.println("Correo: " + email);
                System.out.println("Contraseña: " + password);
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        if(user != null){
                                            //accediendo al menu
                                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        System.out.println("Usuario desde FIREBASE------>" + user.toString());
                                        Toast.makeText(LoginActivity.this,"Usuario conectado", Toast.LENGTH_SHORT).show();

                                    } else{
                                        Toast.makeText(LoginActivity.this,"Usuario no conectado", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                    /*DbUsers dbUsers = new DbUsers(LoginActivity.this);
                    boolean exists = dbUsers.isUserExists(email, password);
                    if (exists) {
                        Toast.makeText(LoginActivity.this, "Iniciando sesion...", Toast.LENGTH_SHORT).show();
                        //accediendo al menu
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuario no registrado!", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                    }*/
                }
            }
        });

    }


    private void limpiarCampos(){
        inputEmail.setText("");
        inputPassword.setText("");
        inputPassword.clearFocus();
    }
}
