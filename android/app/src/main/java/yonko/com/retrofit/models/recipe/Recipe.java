package yonko.com.retrofit.models.recipe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import yonko.com.retrofit.models.recipe.Ingredient;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "uri",
        "label",
        "image",
        "source",
        "url",
        "shareAs",
        "yield",
        "dietLabels",
        "healthLabels",
        "cautions",
        "ingredientLines",
        "ingredients",
        "calories",
        "totalWeight",
        "totalTime"
})
public class Recipe implements Serializable
{

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("label")
    private String label;
    @JsonProperty("image")
    private String image;
    @JsonProperty("source")
    private String source;
    @JsonProperty("url")
    private String url;
    @JsonProperty("shareAs")
    private String shareAs;
    @JsonProperty("yield")
    private Integer yield;
    @JsonProperty("dietLabels")
    private List<String> dietLabels = null;
    @JsonProperty("healthLabels")
    private List<String> healthLabels = null;
    @JsonProperty("cautions")
    private List<String> cautions = null;
    @JsonProperty("ingredientLines")
    private List<String> ingredientLines = null;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients = null;
    @JsonProperty("calories")
    private Double calories;
    @JsonProperty("totalWeight")
    private Double totalWeight;
    @JsonProperty("totalTime")
    private Integer totalTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4052871249526103999L;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("shareAs")
    public String getShareAs() {
        return shareAs;
    }

    @JsonProperty("shareAs")
    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }

    @JsonProperty("yield")
    public Integer getYield() {
        return yield;
    }

    @JsonProperty("yield")
    public void setYield(Integer yield) {
        this.yield = yield;
    }

    @JsonProperty("dietLabels")
    public List<String> getDietLabels() {
        return dietLabels;
    }

    @JsonProperty("dietLabels")
    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    @JsonProperty("healthLabels")
    public List<String> getHealthLabels() {
        return healthLabels;
    }

    @JsonProperty("healthLabels")
    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    @JsonProperty("cautions")
    public List<String> getCautions() {
        return cautions;
    }

    @JsonProperty("cautions")
    public void setCautions(List<String> cautions) {
        this.cautions = cautions;
    }

    @JsonProperty("ingredientLines")
    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    @JsonProperty("ingredientLines")
    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    @JsonProperty("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("calories")
    public Double getCalories() {
        return calories;
    }

    @JsonProperty("calories")
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @JsonProperty("totalWeight")
    public Double getTotalWeight() {
        return totalWeight;
    }

    @JsonProperty("totalWeight")
    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @JsonProperty("totalTime")
    public Integer getTotalTime() {
        return totalTime;
    }

    @JsonProperty("totalTime")
    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
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