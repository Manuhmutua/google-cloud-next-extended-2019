package yonko.com.retrofit.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitServiceRequests {

    @POST
    Call<ResponseBody> postRequest(@Url String endpoint, @Header("Content-Type") String headers, @Body RequestBody requestBody);
}
