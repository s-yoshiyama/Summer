package com.summer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.summer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());
        this.setInputKeyClickListeners(binding);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 入力箇所を押下した時のイベントを設定する。
     */
    @SuppressLint("SetTextI18n")
    private void setInputKeyClickListeners(ActivityMainBinding binding) {
        binding.zero.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.zero);
            binding.currentArea.setText(setText);
        });
        binding.one.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.one);
            binding.currentArea.setText(setText);
        });
        binding.two.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.two);
            binding.currentArea.setText(setText);
        });
        binding.three.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.three);
            binding.currentArea.setText(setText);
        });
        binding.four.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.four);
            binding.currentArea.setText(setText);
        });
        binding.five.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.five);
            binding.currentArea.setText(setText);
        });
        binding.six.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.six);
            binding.currentArea.setText(setText);
        });
        binding.seven.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.seven);
            binding.currentArea.setText(setText);
        });
        binding.eight.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.eight);
            binding.currentArea.setText(setText);
        });
        binding.nine.setOnClickListener(listener -> {
            String setText = binding.currentArea.getText().toString() + this.getResources().getString(R.string.nine);
            binding.currentArea.setText(setText);
        });
        binding.clear.setOnClickListener(listener -> binding.currentArea.setText(""));
        binding.enter.setOnClickListener(listener -> {
            String currentText = binding.currentArea.getText().toString();
            if (!currentText.equals("")) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView = new TextView(this);
                textView.setText(currentText);
                textView.setGravity(Gravity.END);
                textView.setOnClickListener((textViewListener) -> {
                    binding.currentArea.setText(currentText);
                    binding.decidedArea.removeView(textViewListener);
                });
                textView.setTextSize(40);
                textView.setBackground(this.getDrawable(R.drawable.input_key));
                binding.decidedArea.addView(textView, layoutParams);
                binding.currentArea.setText("");
            }
        });
        binding.calc.setOnClickListener(listener -> {
            int childCount = binding.decidedArea.getChildCount();
            int sum = 0;
            for(int i = 0; i < childCount; i++) {
                TextView textView = (TextView) binding.decidedArea.getChildAt(i);
                sum += Integer.parseInt(textView.getText().toString());
            }
            binding.currentArea.setText(Integer.toString(sum));
        });
    }

}
