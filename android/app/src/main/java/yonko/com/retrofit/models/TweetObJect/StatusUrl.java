package yonko.com.retrofit.models.TweetObJect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "urls"
})
@JsonIgnoreProperties(ignoreUnknown = true)

public class StatusUrl {

    @JsonProperty("urls")
    private List<UserUrl> urls = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("urls")
    public List<UserUrl> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<UserUrl> urls) {
        this.urls = urls;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
