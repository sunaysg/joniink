package joni.tattoo.studio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Joni on 3/3/14.
 */
public class UserMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_main);

        Button tattoobut= (Button) findViewById(R.id.tattooorder);
        tattoobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMain.this,OrderTattoo1.class));
            }
        });

        Button piercingbut= (Button) findViewById(R.id.piercingorder);
        piercingbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMain.this,OrderPiercing1.class));
            }
        });

        Button orderlistbut= (Button) findViewById(R.id.orderlistbutton);
        orderlistbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMain.this,OrderList.class));
            }
        });
    }
}