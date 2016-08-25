package com.devfusion.saurav.invision;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class RegistrationActivity extends AppCompatActivity {


    private EditText inputName, inputEmail, inputPassword,input_confirm;
  //  private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword,input_layout_confirmpassword;
    private Button btnSignUp;
    TextView tv_signin;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        getSupportActionBar().hide();
       /* inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_confirmpassword = (TextInputLayout) findViewById(R.id.input_layout_confirmpassword);*/


        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        input_confirm=(EditText)findViewById(R.id.input_confirmpassword);

        btnSignUp = (Button) findViewById(R.id.btn_signup);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        tv_signin=(TextView)findViewById(R.id.tv_signin);

        String text = "<font color=#cfcfcf>Already have an account? </font> <font color=#FFFFFF> <b>Sign In</b></font>";
        tv_signin.setText(Html.fromHtml(text));

        vv=(VideoView)findViewById(R.id.myvideo);
        vv.setVideoPath("android.resource://"+getPackageName()+"/" + R.raw.splash);
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp) {
                /*Intent in=new Intent(splash.this,MainActivity.class);
                startActivity(in);
                finish();*/
                vv.start();
            }
        });
        vv.start();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {return;}
        if (!validateEmail()) {return;}
        if (!validatePassword()) {return;}
        if (!validateConfirm()){return;}

        vv.stopPlayback();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(), "Register Successfully!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
           // inputLayoutName.setError(getString(R.string.err_msg_name));
            inputName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
           // inputLayoutName.setErrorEnabled(false);

        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {
           // inputLayoutEmail.setError(getString(R.string.err_msg_email));
            inputEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } //else {inputLayoutEmail.setErrorEnabled(false);}
        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            //inputLayoutPassword.setError(getString(R.string.err_msg_password));
            inputPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } //else {inputLayoutPassword.setErrorEnabled(false);}
        return true;
    }
    private boolean validateConfirm(){
        if (input_confirm.getText().toString().trim().isEmpty() || (!(input_confirm.getText().toString()).equals(inputPassword.getText().toString()))){
            System.out.println("pwd--"+input_confirm.getText().toString()+"--"+inputPassword.getText().toString());
           // input_layout_confirmpassword.setError("Password not match");
            input_confirm.setError("Password not match");
            requestFocus(input_confirm);
            return  false;
        }//else{input_layout_confirmpassword.setErrorEnabled(false);}
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }
}

