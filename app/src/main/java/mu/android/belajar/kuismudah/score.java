package mu.android.belajar.kuismudah;

/**
 * Created by MUL-09 on 24/04/2018.
 */
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class score extends Activity {

    @Override

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView total = (TextView)findViewById(R.id.total);

        hasil.setText("Jawaban yang Benar: "+MainActivity.benar+"\nJawaban Salah: "+MainActivity.salah);
        total.setText(""+MainActivity.hasil);
    }

    public void coba (View view){
        finish();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

}
