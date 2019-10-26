package br.com.barrsoft.progressbars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName() ;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.circular_progress)
    ProgressBar progressBar;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.progressBar)
    ProgressBar progressBar1;
    ProgressBarAsync progressBarAsync;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);
        progressBar1.setVisibility(View.GONE);

    }

    @OnClick(R.id.button)
    public void submit(View view) {
        // TODO submit data to server...

        Toast.makeText(getApplicationContext(),"ProgressBar Start",Toast.LENGTH_SHORT).show();
        progressBarAsync = new ProgressBarAsync(view);
        progressBarAsync.setProgressBar(progressBar);
        progressBarAsync.execute();
    }

    @OnClick(R.id.button1)
    public void submit1(View view){
        // TODO submit data to server...
        Toast.makeText(getApplicationContext(),"ProgressBar Start",Toast.LENGTH_SHORT).show();
        progressBarAsync = new ProgressBarAsync(view);
        progressBarAsync.setProgressBar(progressBar1);
        progressBarAsync.execute();
    }

}