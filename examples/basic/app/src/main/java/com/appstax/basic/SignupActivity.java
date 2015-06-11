package com.appstax.basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appstax.AxException;
import com.appstax.AxUser;
import com.appstax.android.Appstax;
import com.appstax.android.Callback;


public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        createToolbar();

        Button signupButton = (Button) findViewById(R.id.signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signup();
            }
        });
    }

    protected void signup() {
        Appstax.signup(editTextVal(R.id.email), editTextVal(R.id.password), new Callback<AxUser>() {
            public void onSuccess(AxUser output) {
                dialog("welcome", Appstax.getCurrentUser().getUsername());
            }
            public void onError(AxException e) {
                dialog("error", e.getMessage());
            }
        });
    }

}
