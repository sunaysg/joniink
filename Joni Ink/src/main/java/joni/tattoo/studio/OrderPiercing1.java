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
public class OrderPiercing1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.orderpiercing1);

        Button nextbut= (Button) findViewById(R.id.nextbutton);
        nextbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPiercing1.this, OrderPiercing2.class));
            }
        });

    }
}
