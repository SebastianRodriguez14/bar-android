package idat.com.bar_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import idat.com.bar_android.db.DbUsers;

public class LoginActivity extends AppCompatActivity {
    //agregado--------------------
    EditText inputEmail, inputPassword;

    TextView textView;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //agregado----------
        inputEmail = findViewById(R.id.editText_Correo);
        inputPassword = findViewById(R.id.editText_Clave);

        textView = findViewById(R.id.text_register);
        btnMenu = findViewById(R.id.btnAccederMenu);

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
                System.out.println(" DATOS DEL USUARIO");
                System.out.println("Correo: " + email);
                System.out.println("Contraseña: " + password);
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }else {
                    DbUsers dbUsers = new DbUsers(LoginActivity.this);
                    boolean exists = dbUsers.isUserExists(email, password);
                    if (exists) {
                        Toast.makeText(LoginActivity.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();
                    } else {
                        long id = dbUsers.insertUser(email, password);
                        if (id > 0) {
                            Toast.makeText(LoginActivity.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                            limpiarCampos();
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario no creado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }


    private void limpiarCampos(){
        inputEmail.setText("");
        inputPassword.setText("");
    }
}
