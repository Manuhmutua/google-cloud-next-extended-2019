package yonko.com.retrofit;

/**
 * This file contains a reference to the sensitive data for authentication for the twitter api call
 * The actual values are stored in the gradle.properties file which will be ignored. Such that if anyone clones the project
 * they will not have access to this data
 */
public class Constants {

    public static final String CONSUMER_KEY = BuildConfig.TWITTER_CONSUMER_KEY;
    public static final String CONSUMER_SECRET = BuildConfig.TWITTER_CONSUMER_SECRET;
    public static final String TOKEN = BuildConfig.TWITTER_TOKEN;
    public static final String TOKEN_SECRET = BuildConfig.TWITTER_TOKEN_SECRET;
    public static final String QUERY_PARAMETERS = "q";
    public static final String SEARCH_PARAMETER = "search";
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String TOPIC = "@ma3route";
    public static final String URL_MODIFIER = "recipe";
    public static final String APP_ID = "app_id";
    public static final String APPLICATION_KEY = "app_key";


}
