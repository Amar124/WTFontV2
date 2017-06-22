package pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token"
})

public class AuthenticateResposneNew {

    @JsonProperty("token")
    private String token;

    @JsonProperty("token")
    public String getToken () {
        return token;
    }

    @JsonProperty("token")
    public void setToken( String token) {
        this.token = token;
    }
}
