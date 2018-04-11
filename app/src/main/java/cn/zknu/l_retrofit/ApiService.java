package cn.zknu.l_retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018\4\11 0011.
 */

public interface ApiService {
    @GET("get.php")
    Call<String> requestGet(@Query("key") String key);

    @FormUrlEncoded
    @POST("post.php")
    Call<String> requestPost(@Field("key") String key);

    @GET("{url}")
    Call<String> getUrlString1(@Path("url") String url);
}
