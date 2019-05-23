package yonko.com.retrofit.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RetrofitNetworkCall {

    /**
     * This method does the actual call to the server
     *
     * @param endPoint a url that is added to the base url to create the full url
     * @param headers  authorization headers to be sent with the request eg bearer, basic
     * @param body     actual params as raw data
     */
    public static void sendPostCall(String endPoint, String headers, RequestBody body, Callback<ResponseBody> callback) {

        RetrofitServiceRequests calls = RetrofitService.createService(RetrofitServiceRequests.class);

        Call<ResponseBody> result = calls.postRequest(endPoint, headers, body);

        result.enqueue(callback);
    }
}
