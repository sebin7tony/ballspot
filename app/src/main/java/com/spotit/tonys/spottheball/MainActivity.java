package com.spotit.tonys.spottheball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Integer Images[] = {R.drawable.messi1,R.drawable.messi2,R.drawable.messi3,R.drawable.messi4};
    private Integer counter = 0;

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

        setImage(Images[0]);
    }

    private void switchImage(){

        final Button nextButton= (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                System.out.println("inside onclick event");
                if(counter > 3){

                    counter = 0;
                }
                //Integer newImageId = getResources().getIdentifier("messi"+counter++,"drawable",getPackageName());
                setImage(Images[counter]);
            }
        });
    }
}
