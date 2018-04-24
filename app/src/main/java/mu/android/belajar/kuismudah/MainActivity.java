import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import mu.android.belajar.kuismudah.R;

public class MainActivity extends AppCompatActivity {



    TextView mPertanyaan;
    RadioButton mPilih1,mPilih2,mPilih3,mPilih4;
    RadioGroup rg;
    int no = 0;
    public static int benar, salah, hasil;

    String [] soal_pertanyaan = new String[] {
            "Yang manakah yang merupakan framework PHP?",
            "Bahasa pemrograman apa yang disupport Android Studio?",
            "Pilih tools untuk membuat wireframe",
            "Yang merupakan layanan web Version Control System adalah, kecuali",
            "Apakah peruntukan kelas elemen-elemen dasar pada java?"
    };

    String [] pilihan = new String[] {
            "Rails","React","Laravel","Vue",
            "Kotlin","C","Ruby","Pascal",
            "WinBox","Sublime Text","Power Designer","Balsamic",
            "GitHub","GitLab","BitBucket","Git",
            "java.lang","java.io","java.util","java.net",
    };

    String [] jawaban_benar = new String[] {
            "Laravel",
            "Kotlin",
            "Balsamic",
            "Git",
            "java.lang",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPertanyaan = findViewById(R.id.pertanyaan);
        rg = findViewById(R.id.radio);
        mPilih1 = findViewById(R.id.pilih1);
        mPilih2 = findViewById(R.id.pilih2);
        mPilih3 = findViewById(R.id.pilih3);
        mPilih4 = findViewById(R.id.pilih4);

        mPertanyaan.setText(soal_pertanyaan[no]);
        mPilih1.setText(pilihan[0]);
        mPilih2.setText(pilihan[1]);
        mPilih3.setText(pilihan[2]);
        mPilih4.setText(pilihan[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void submit (View view) {
        if (mPilih1.isChecked() || mPilih2.isChecked() || mPilih3.isChecked() || mPilih4.isChecked()) {
            RadioButton klik_jawaban = findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban = klik_jawaban.getText().toString();
            rg.check(0);
            if (ambil_jawaban.equalsIgnoreCase(jawaban_benar[no])) benar++;
            else salah++;
            no++;

            if (no < soal_pertanyaan.length) {
                mPertanyaan.setText(soal_pertanyaan[no]);
                mPilih1.setText(pilihan[(no * 4) + 0]);
                mPilih2.setText(pilihan[(no * 4) + 1]);
                mPilih3.setText(pilihan[(no * 4) + 2]);
                mPilih4.setText(pilihan[(no * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), score.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}