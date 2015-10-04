package joni.tattoo.studio;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Joni on 3/2/14.
 */
public class LoginScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_screen);

        ImageButton adminmain= (ImageButton) findViewById(R.id.adminbutton);
        adminmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoginScreen.this,AdminMain.class));
                PasswordDialog dialog=new PasswordDialog(LoginScreen.this);
                dialog.show();
            }
        });

        ImageButton usermain= (ImageButton) findViewById(R.id.userbutton);
        usermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this,UserMain.class));
            }
        });
    }
}