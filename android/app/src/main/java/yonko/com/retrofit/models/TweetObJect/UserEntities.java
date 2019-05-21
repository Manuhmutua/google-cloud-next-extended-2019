package yonko.com.retrofit.models.TweetObJect;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "description"
})
@JsonIgnoreProperties(ignoreUnknown = true)

class UserEntities {

    @JsonProperty("url")
    private UserEntitiesUrl url;
    @JsonProperty("description")
    private Description description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public UserEntitiesUrl getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(UserEntitiesUrl url) {
        this.url = url;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
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
