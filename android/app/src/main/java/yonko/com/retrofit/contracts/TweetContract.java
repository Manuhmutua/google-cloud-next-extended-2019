package yonko.com.retrofit.contracts;

import yonko.com.retrofit.models.recipe.RecipeResponse;

public interface TweetContract {

    interface Presenter {
        void getTweets(String topic);
        void sendName(String name);
    }

    interface View extends BaseView<Presenter> {
        void loadRecipes(RecipeResponse recipeResponses);

        void showProgressBar(Boolean showProgressbar);

        void success();

        void showError(String error);
    }
}
