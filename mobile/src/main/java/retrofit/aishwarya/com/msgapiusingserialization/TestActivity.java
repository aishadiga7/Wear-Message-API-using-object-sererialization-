package retrofit.aishwarya.com.msgapiusingserialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit.aishwarya.com.sharemodule.Movie;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        TextView name = (TextView) findViewById(R.id.name);
        TextView revenue = (TextView) findViewById(R.id.revenue);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Movie movie = (Movie) bundle.getSerializable("movie_data");
            if (movie != null) {
                name.setText(movie.getMovieName());
                revenue.setText(movie.getRevenue());
            }
        }
    }
}
