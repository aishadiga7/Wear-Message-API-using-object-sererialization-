package retrofit.aishwarya.com.sharemodule;

import java.io.Serializable;

/**
 * Created by aishwarya on 24/6/16.
 */
public class Movie implements Serializable{

    private String mMovieName;
    private String mRevenue;

    public Movie() {

    }


    public String getMovieName() {
        return mMovieName;
    }

    public void setMovieName(String movieName) {
        mMovieName = movieName;
    }

    public String getRevenue() {
        return mRevenue;
    }

    public void setRevenue(String revenue) {
        mRevenue = revenue;
    }


}
