package com.pacoapp.paco.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;

import com.pacoapp.paco.R;

/**
 * Created by JodliDev on 27.03.17.
 */

public class DialogActivity extends Activity {
  public static final String MSG_KEY = "DialogActivity_msg";
  public static final String TITLE_KEY = "DialogActivity_title";


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle extras = getIntent().getExtras();
    String title = (extras.getString(TITLE_KEY) == null) ? extras.getString(TITLE_KEY) : getString(R.string.app_name);
    final AlertDialog.Builder dialog_builder = new AlertDialog.Builder(this)
            .setIcon(R.drawable.paco64)
            .setTitle(R.string.app_name)
            .setTitle((extras.getString(TITLE_KEY) == null) ? getString(R.string.app_name) : extras.getString(TITLE_KEY))
            .setMessage(extras.getString(MSG_KEY))
            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                finish();
              }
            });
    final AlertDialog dialog = dialog_builder.create();
    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
              public void onDismiss(DialogInterface dialog) {
                finish();
              }
            });

    dialog.show();
  }
}
