package com.ideura.buttonex;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//ボタンとダイアログ
public class ButtonEx extends Activity implements View.OnClickListener {
	private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
	private EditText editText;

	// アクティビティ起動時に呼ばれる
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// レイアウト生成
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundColor(Color.rgb(255, 255, 255));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		// ボタン生成
		layout.addView(makeButton("ダイアログの表示", "0"));
		layout.addView(makeButton("Yes/Noダイアログの表示", "1"));
		layout.addView(makeButton("テキストダイアログの表示", "2"));
		layout.addView(makeButton(res2bmp(this, R.drawable.sample), "3"));

	}

	// ボタンの生成
	private Button makeButton(String text, String tag) {

		Button button = new Button(this);
		button.setText(text);
		button.setTag(tag);
		button.setOnClickListener(this);
		button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
		return button;

	}

	// イメージボタンの生成
	private ImageButton makeButton(Bitmap bmp, String tag) {
		Bitmap pressed = filteringBmp(bmp, Color.LTGRAY,
				PorterDuff.Mode.MULTIPLY);
		ImageButton button = new ImageButton(this);
		button.setTag(tag);
		button.setOnClickListener(this);
		StateListDrawable drawables = new StateListDrawable();
		int statePressed = android.R.attr.state_pressed;
		drawables.addState(new int[] { statePressed }, new BitmapDrawable(
				pressed));
		drawables.addState(new int[] {}, new BitmapDrawable(pressed));
		button.setBackgroundDrawable(drawables);
		button.setLayoutParams(new LinearLayout.LayoutParams(bmp.getWidth(),
				bmp.getHeight()));
		return button;

	}

	private Bitmap filteringBmp(Bitmap bmp, int color, PorterDuff.Mode mode) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	// ビットマップフィルタ
	public static Bitmap res2bmp(Context context, int resID) {
		return BitmapFactory.decodeResource(context.getResources(), resID);

	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
