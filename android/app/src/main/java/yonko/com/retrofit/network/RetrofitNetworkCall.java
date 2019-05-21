package yonko.com.retrofit.network;

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
}
