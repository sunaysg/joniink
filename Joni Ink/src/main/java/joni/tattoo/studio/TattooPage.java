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
public class TattooPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tattoopage);

        Button addbut= (Button) findViewById(R.id.addtattoobut);
        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivityForResult(new Intent(TattooPage.this, AddTattoo1.class), 1);
                startActivity(new Intent(TattooPage.this, AddTattoo1.class));
            }
        });


    }
}