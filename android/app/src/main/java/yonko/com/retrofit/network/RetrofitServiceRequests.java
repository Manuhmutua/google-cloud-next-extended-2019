package yonko.com.retrofit.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yonko.com.retrofit.Constants;

public interface RetrofitServiceRequests {
    /**
     * all data that is needed to make a call is added here.
     *
     * @param endpoint included the final URL without the base url
     *                 the base url is is defined in Service generator class
     * @return
     */
    @GET(Constants.SEARCH_PARAMETER)
    Call<ResponseBody> getRequest(
            @Query(Constants.URL_MODIFIER) String kilasi,
            @Query(Constants.QUERY_PARAMETERS) String searchTerm,
            @Query(Constants.APP_ID) String appId,
            @Query(Constants.APPLICATION_KEY) String appKey,
            @Query(Constants.FROM) String from,
            @Query(Constants.TO) String to)
    ;
}
