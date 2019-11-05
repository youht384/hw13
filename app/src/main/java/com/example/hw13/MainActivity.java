package com.example.hw13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int image[] = {
                R.drawable.catpuch1,
                R.drawable.catpuch2,
                R.drawable.catpuch3,
                R.drawable.catpuch4,
                R.drawable.catpuch5,
                R.drawable.catpuch6,
                R.drawable.catpuch7,
                R.drawable.catpuch8,
                R.drawable.catpuch9,
                R.drawable.catpuch10};
        final ImageView imageview = findViewById(R.id.imageView2);
        final EditText editText = findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText.getText().toString().matches(""))
                {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不能是空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    int imageID = Integer.parseInt(editText.getText().toString());
                    if (imageID > 10 || imageID < 1) {
                        Toast toast = Toast.makeText(MainActivity.this, "請輸入1~10!!", Toast.LENGTH_LONG);
                        toast.show();

                        imageID = Integer.parseInt(editText.getText().toString());
                    }
                    else {
                        imageview.setImageResource(image[imageID-1]);
                    }
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    editText.setText("");
                }
            }
        });


    }
}