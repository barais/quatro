package ur1.demoandroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Demo3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);


        Button gotTo2 = (Button) findViewById(R.id.back);
        // findViewById permet de récuperer l'objet correspondant à une vue

        gotTo2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent transition = new Intent(Demo3.this, Plateau.class);
                startActivity(transition);
            }
        });
    }
}
