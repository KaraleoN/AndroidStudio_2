package com.geeks.androidstudio_2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView welcomeText;
    private TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        welcomeText = findViewById(R.id.welcome_text);
        descriptionText = findViewById(R.id.description_text);

        emailInput.addTextChangedListener(textWatcher);
        passwordInput.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    emailInput.setVisibility(View.GONE);
                    passwordInput.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                    descriptionText.setVisibility(View.GONE);
                    welcomeText.setText("Добро пожаловать");
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            loginButton.setEnabled(!email.isEmpty() && !password.isEmpty());
            loginButton.setBackgroundTintList(getResources().getColorStateList(
                    !email.isEmpty() && !password.isEmpty() ? R.color.orange : android.R.color.darker_gray));
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}