package retrofit.aishwarya.com.msgapiusingserialization;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import retrofit.aishwarya.com.sharemodule.Constants;
import retrofit.aishwarya.com.sharemodule.Movie;
import retrofit.aishwarya.com.sharemodule.SerializeUtils;

/**
 * Created by aishwarya on 24/6/16.
 */
public class MessageListener  extends WearableListenerService {
    public static final String TAG = MessageListener.class.getSimpleName();

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        Log.d(TAG, messageEvent.getPath());
        if (messageEvent.getPath() != null) {
            switch (messageEvent.getPath())  {
                case Constants.SAMPLE:
                    Movie movie = (Movie) SerializeUtils.deserialize(messageEvent.getData());
                    Intent loginIntent =new Intent(this, TestActivity.class);
                    loginIntent.putExtra("movie_data", movie);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(loginIntent);
                    break;
            }
        }

    }
}

