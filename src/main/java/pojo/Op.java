package pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "token", "updatedAt" })
public class Op {

	@JsonIgnore
	private Integer v;
	@JsonProperty("token")
	private String token;
	@JsonIgnore
	private String createdAt;
	@JsonProperty("type")
	private String type;
	@JsonProperty("backgroundColor")
	private String backgroundColor;
	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("_id")
	private String id;
	@JsonProperty("isDeleted")
	private Boolean isDeleted;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("__v")
	public Integer getV() {
		return v;
	}

	@JsonProperty("__v")
	public void setV(Integer v) {
		this.v = v;
	}

	@JsonProperty("createdAt")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("createdAt")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("backgroundColor")
	public String getBackgroundColor() {
		return backgroundColor;
	}

	@JsonProperty("backgroundColor")
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@JsonProperty("createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("createdBy")
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("_id")
	public String getId() {
	return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
	this.id = id;
	}

	@JsonProperty("isDeleted")
	public Boolean getIsDeleted() {
	return isDeleted;
	}

	@JsonProperty("isDeleted")
	public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
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