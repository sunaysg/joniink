package joni.tattoo.studio;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.sql.SQLException;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Joni on 3/15/14.
 */
public class PasswordDialog extends Dialog {

    public PasswordDialog(final Context context) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.password_field);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        Button butlogin= (Button) findViewById(R.id.btnLogin);
        butlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,AdminMain.class));

    //            DBOperations dbOperations = new DBOperations(getContext());
      //          try {
         //         dbOperations.open();
           //     } catch (SQLException e) {
             //       e.printStackTrace();
               // }
                //dbOperations.validate("Sunay","kozmi1");
            }
        });
    }



    protected PasswordDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public PasswordDialog(Context context, int theme) {
        super(context, theme);
    }
}
