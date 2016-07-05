package retrofit.aishwarya.com.msgapiusingserialization;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import retrofit.aishwarya.com.sharemodule.Movie;
import retrofit.aishwarya.com.sharemodule.SerializeUtils;

/**
 * Created by aishwarya on 24/6/16.
 */
public class UtilityService  extends IntentService {
    private static final String TAG = UtilityService.class.getSimpleName();
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UtilityService(String name) {
        super(name);
    }
    public UtilityService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        byte[] byteArray  = bundle.getByteArray("movie");
        Movie movie = (Movie) SerializeUtils.deserialize(byteArray);
        Intent loginIntent =new Intent(this, TestActivity.class);
        loginIntent.putExtra("movie_data", movie);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(loginIntent);
    }

   /* public static void triggerLoginClick(Context ctx) {

        // intent.setAction(Constants.DataApiConstant.ACCOUNT);
        Intent intent = new Intent(ctx, UtilityService.class);
        ctx.startService(intent);
    }*/

}

