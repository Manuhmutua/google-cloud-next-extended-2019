package yonko.com.retrofit.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import yonko.com.retrofit.BuildConfig;
import yonko.com.retrofit.Constants;

public class RetrofitNetworkCall {
    /**
     * @param endpoint this is the base url for the call
     * @param callback
     */
    public static void getRecipe(String endpoint, String searchTerm, Callback<ResponseBody> callback) {
        RetrofitServiceRequests retrofitService = RetrofitService.createService(RetrofitServiceRequests.class);

        // endpoint is https://api.twitter.com/1.1/search/
        // so now we add tweets.json because the full url is to be https://api.twitter.com/1.1/search/tweets.json?
        endpoint = endpoint + Constants.URL_MODIFIER;

        Call<ResponseBody> responseBodyCall = retrofitService.getRequest("", searchTerm, BuildConfig.APP_ID, BuildConfig.APPLICATION_KEY, "0", "40");

        responseBodyCall.enqueue(callback);
    }

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
