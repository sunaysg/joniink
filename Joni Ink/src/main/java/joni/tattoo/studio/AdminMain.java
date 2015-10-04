package joni.tattoo.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Joni on 3/2/14.
 */
public class AdminMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.admin_main);

        Button tattoobut= (Button) findViewById(R.id.tattoomenu);
        tattoobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminMain.this,TattooPage.class));
            }
        });

        Button piercingbut= (Button) findViewById(R.id.piercingmenu);
        piercingbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminMain.this,PiercingPage.class));
            }
        });

    }
}