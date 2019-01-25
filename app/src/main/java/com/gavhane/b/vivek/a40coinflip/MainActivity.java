package com.gavhane.b.vivek.a40coinflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_flip;

    ImageView iv_coin;

    Random r;

    int coinSide;       //0 for heads   and  1 for tails

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_flip = (Button) findViewById(R.id.b_flip);
        iv_coin = (ImageView) findViewById(R.id.iv_coin);

        r = new Random();

        b_flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coinSide = r.nextInt(2);        // this will generate random number from 0 to 1 i.e. below 2

                if(coinSide == 0){
                    iv_coin.setImageResource(R.drawable.head);
                    Toast.makeText(MainActivity.this, "Heads", Toast.LENGTH_SHORT).show();
                }else if (coinSide == 1){
                    iv_coin.setImageResource(R.drawable.tail);
                    Toast.makeText(MainActivity.this, "Tails", Toast.LENGTH_SHORT).show();
                }

                //This is to rotate the coin

                RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);       //  if u click error red line before passong the constructor parameters then u will understand which parameters we need to pass
                rotate.setDuration(1000);
                iv_coin.startAnimation(rotate);
            }
        });

    }
}
