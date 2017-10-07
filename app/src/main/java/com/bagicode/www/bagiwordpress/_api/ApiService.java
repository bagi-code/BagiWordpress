package com.bagicode.www.bagiwordpress._api;

import com.bagicode.www.bagiwordpress._wordpress.ItemPost;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bagicode on 05/10/2016.
 */

public interface ApiService {

    @GET("get_recent_posts")
    Call<ItemPost> getRecentPost();
}
