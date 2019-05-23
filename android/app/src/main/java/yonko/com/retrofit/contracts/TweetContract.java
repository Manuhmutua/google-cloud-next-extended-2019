package yonko.com.retrofit.contracts;

public interface TweetContract {

    interface Presenter {
        void sendName(String name);
    }

    interface View extends BaseView<Presenter> {

        void success();

        void showError(String error);
    }
}
