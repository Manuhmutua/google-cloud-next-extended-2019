package yonko.com.retrofit

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yonko.com.retrofit.contracts.TweetContract
import yonko.com.retrofit.network.RetrofitNetworkCall
import yonko.com.retrofit.network.RetrofitVariables

class TweetPresenter(view: TweetContract.View) : TweetContract.Presenter {

    var TAG = javaClass.simpleName
    private var mView: TweetContract.View = view

    init {
        mView.setPresenter(this)
    }

    override fun sendName(name: String) {
        val mRequestBody = RequestBody.create(MediaType.parse("application/json"), createRequestObject(name))
        RetrofitNetworkCall.sendPostCall(
            RetrofitVariables.getRandomNameUrl(),
            "application/json",
            mRequestBody,
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    mView.showError("Oops " + t.localizedMessage)
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.code() == 200) mView.success()
                }

            })
    }

    private fun createRequestObject(chosenName: String): String {
        val objectMapper = ObjectMapper()
        val record = objectMapper.createObjectNode()
        record.put("id", "1")
        record.put("name", chosenName)
        return record.toString()
    }
}