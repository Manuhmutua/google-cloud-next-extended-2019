package yonko.com.retrofit;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import retrofit2.Response;
import yonko.com.retrofit.models.TweetObJect.Status;

import java.io.IOException;

public class TweetActivity extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
        //doTheThing();
    }

//    private void doTheThing() {
//
//        String url = RetrofitVariables.getBaseUrl();
//        getRecipe(url,topic, new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.body() != null && response.code() == 200) {
//                    mapIt(response);
//                } else if (response.code() == 500) {
//                    Log.e(TAG, "Server error");
//                } else {
//                    Log.e(TAG, "********* Something went wrong " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }

    private void mapIt(Response<ResponseBody> response) {
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        Log.e(TAG, "******** response is  " + response.body());
        try {

            JsonNode jsonNode = null;
            if (response.body() != null) {
                jsonNode = objectMapper.readTree(response.body().string());
            }
            if (jsonNode != null && jsonNode.get("statuses") != null) {
                Status status[] = objectMapper.treeToValue(jsonNode.get("statuses"), Status[].class);
//                String text = status.get(0).text;
                Log.e(TAG, "******************* text " + status.length + " by ");
            } else {
                Log.e(TAG, "********* we didnt get statuses " + jsonNode);
            }
        } catch (IOException e) {
            Log.e(TAG, "******** " + e);
        }
    }
}
