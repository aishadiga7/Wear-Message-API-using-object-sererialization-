package retrofit.aishwarya.com.msgapiusingserialization;

import android.os.Bundle;
import android.view.View;

import retrofit.aishwarya.com.sharemodule.Constants;
import retrofit.aishwarya.com.sharemodule.Movie;
import retrofit.aishwarya.com.sharemodule.SerializeUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_msg).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_msg) {
            Movie movie = new Movie();
            movie.setMovieName("ABCD2");
            movie.setRevenue("500000");
            final byte[] movieData = SerializeUtils.serialize(movie);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MsgApiUtils.sendMessageApi(MainActivity.this, Constants.SAMPLE, movieData);
                }
            }).start();
           // new SendMessageTask(this).execute()
        }

    }
}
