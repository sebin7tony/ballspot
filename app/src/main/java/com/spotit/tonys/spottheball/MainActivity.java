package com.spotit.tonys.spottheball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Integer curImage = R.drawable.messi1;
    private Integer counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialImage();
        switchImage();
    }

    private void setImage(Integer imageToSet){

        final ImageView imageview = (ImageView)findViewById(R.id.Display);
        imageview.setImageResource(imageToSet);
    }

    private void setInitialImage(){

        setImage(curImage);
    }

    private void switchImage(){

        final Button nextButton= (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter > 4){

                    counter = 1;
                }
                System.out.println("Inside");
                drawImage(counter);
            }
        });
    }

    private void drawImage(Integer count){

        final Integer c = count;
        new Thread(){
            public void run(){

                final Integer newImageId = getResources().getIdentifier("messi"+c,"drawable",getPackageName());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final ImageView imageview = (ImageView)findViewById(R.id.Display);
                        imageview.setImageResource(newImageId);
                    }
                });
            }

        }.start();



    }
}
