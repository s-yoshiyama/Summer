package com.summer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setInputKeyClickListeners();
    }

    /**
     * 入力箇所を押下した時のイベントを設定する。
     */
    private void setInputKeyClickListeners() {
        this.findViewById(R.id.zero).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.zero);
            textView.setText(currentText);
        });
        this.findViewById(R.id.one).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.one);
            textView.setText(currentText);
        });
        this.findViewById(R.id.two).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.two);
            textView.setText(currentText);
        });
        this.findViewById(R.id.three).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.three);
            textView.setText(currentText);
        });
        this.findViewById(R.id.four).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.four);
            textView.setText(currentText);
        });
        this.findViewById(R.id.five).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.five);
            textView.setText(currentText);
        });
        this.findViewById(R.id.six).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.six);
            textView.setText(currentText);
        });
        this.findViewById(R.id.seven).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.seven);
            textView.setText(currentText);
        });
        this.findViewById(R.id.eight).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.eight);
            textView.setText(currentText);
        });
        this.findViewById(R.id.nine).setOnClickListener((listener) -> {
            TextView textView = this.findViewById(R.id.current_area);
            String currentText = textView.getText().toString();
            currentText = currentText + this.getString(R.string.nine);
            textView.setText(currentText);
        });
        this.findViewById(R.id.clear).setOnClickListener((listener) -> {
            this.resetCurrentArea();
        });
        this.findViewById(R.id.enter).setOnClickListener((listener) -> {
            LinearLayout linearLayout = this.findViewById(R.id.decided_area);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextView currentTextView = this.findViewById(R.id.current_area);
            String currentText = currentTextView.getText().toString();
            TextView textView = new TextView(this);
            textView.setText(currentText);
            textView.setGravity(Gravity.RIGHT);
            textView.setOnClickListener((textViewListener) -> {
                TextView currentArea = this.findViewById(R.id.current_area);
                currentArea.setText(currentText);
                linearLayout.removeView(textView);
            });
            textView.setTextSize(40);
            textView.setBackground(this.getDrawable(R.drawable.input_key));
            linearLayout.addView(textView, layoutParams);
            this.resetCurrentArea();
        });
        this.findViewById(R.id.calc).setOnClickListener((listener) -> {
            LinearLayout linearLayout = this.findViewById(R.id.decided_area);
            int childCount = linearLayout.getChildCount();
            Integer sum = 0;
            for(int i = 0; i < childCount; i++) {
                TextView textView = (TextView) linearLayout.getChildAt(i);
                sum += Integer.parseInt(textView.getText().toString());
            }
            TextView textView = this.findViewById(R.id.current_area);
            textView.setText(sum.toString());
        });
    }

    private void resetCurrentArea() {
        TextView textView = this.findViewById(R.id.current_area);
        textView.setText("");
    }

}
