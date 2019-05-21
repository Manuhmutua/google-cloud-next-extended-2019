package yonko.com.retrofit.models.recipe;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "q",
        "from",
        "to",
        "count",
        "hits"
})
public class RecipeResponse implements Serializable {

    @JsonProperty("q")
    private String q;
    @JsonProperty("from")
    private Integer from;
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("hits")
    private List<Hit> hits = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3753823108687630110L;

    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty("from")
    public Integer getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Integer from) {
        this.from = from;
    }

    @JsonProperty("to")
    public Integer getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Integer to) {
        this.to = to;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("hits")
    public List<Hit> getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(List<Hit> hits) {
        this.hits = hits;
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