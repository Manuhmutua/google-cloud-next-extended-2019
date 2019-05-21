package yonko.com.retrofit.models.recipe;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "recipe"
})
public class Hit implements Serializable {

    @JsonProperty("recipe")
    private Recipe recipe;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7982816025301709147L;

    @JsonProperty("recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @JsonProperty("recipe")
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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