package com.ideura.edittextex;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;

public class EditTextEx extends Activity implements OnClickListener {

	private final static int WC =LinearLayout.LayoutParams.WRAP_CONTENT;
	private final static int MP=LinearLayout.LayoutParams.MATCH_PARENT;
	private EditText editText;//エディットテキスト
 	private Button button;//ボタン

	/* (非 Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		//レイアウト生成
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundColor(Color.rgb(255, 255, 255));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		//エディットテキストの生成
		editText=new EditText(this);
		editText.setText("これはテストです。",BufferType.NORMAL);
		editText.setLayoutParams(new LinearLayout.LayoutParams(MP,WC ));
		layout.addView(editText);

		//ボタンの生成
		button = new Button(this);
		button.setText("結果表示");
		button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		button.setOnClickListener(this);
		layout.addView(button);
	}

	@Override
	public void onClick(View v) {
		showDialog(this,"","エディット>"+editText.getText().toString());
	}

	private static void showDialog(Context context, String title, String text) {
		AlertDialog.Builder ad =new AlertDialog.Builder(context);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("OK", null);
		ad.show();
	}


}
