package br.com.barrsoft.progressbars;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

class ProgressBarAsync extends AsyncTask<Void,Integer,Void> {


    private static final String TAG = ProgressBarAsync.class.getName();
    private View view ;
    ProgressBar progressBar;


    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public ProgressBarAsync(View view) {
        this.view = view;
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(view.getContext(),"onPreExecute()",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "doInBackground: ");
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(view.getContext(),"onPostExecute",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
        super.onPostExecute(aVoid);
    }

}