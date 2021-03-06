/*
 * Wallet API Service
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.WalletResponse1Error;
import io.swagger.model.WalletResult1;
import javax.validation.constraints.*;

/**
 * WalletResponse
 */
@JsonInclude(Include.NON_EMPTY)
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class WalletResponse   {
	
  @JsonProperty("user_agent")
  private String userAgent = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("serviceTime")
  private String serviceTime = null;

  @JsonProperty("error")
  private WalletResponse1Error error = null;

  @JsonProperty("result")
  private WalletResult1 result = null;

  public WalletResponse userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /**
   * User Agent
   * @return userAgent
   **/
  @JsonProperty("user_agent")
  @ApiModelProperty(example = "1-800-Flowers, Inc./api Enterprise Services", value = "User Agent")
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public WalletResponse version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Version
   * @return version
   **/
  @JsonProperty("version")
  @ApiModelProperty(example = "1.1.1", value = "Version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public WalletResponse statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * statusCode
   * @return statusCode
   **/
  @JsonProperty("statusCode")
  @ApiModelProperty(example = "200", value = "statusCode")
  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public WalletResponse serviceTime(String serviceTime) {
    this.serviceTime = serviceTime;
    return this;
  }

  /**
   * serviceTime
   * @return serviceTime
   **/
  @JsonProperty("serviceTime")
  @ApiModelProperty(example = "234", value = "serviceTime")
  public String getServiceTime() {
    return serviceTime;
  }

  public void setServiceTime(String serviceTime) {
    this.serviceTime = serviceTime;
  }

  public WalletResponse error(WalletResponse1Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   **/
  @JsonProperty("error")
  @ApiModelProperty(value = "")
  public WalletResponse1Error getError() {
    return error;
  }

  public void setError(WalletResponse1Error error) {
    this.error = error;
  }

  public WalletResponse result(WalletResult1 result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  @JsonProperty("result")
  @ApiModelProperty(value = "")
  public WalletResult1 getResult() {
    return result;
  }

  public void setResult(WalletResult1 result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletResponse walletResponse = (WalletResponse) o;
    return Objects.equals(this.userAgent, walletResponse.userAgent) &&
        Objects.equals(this.version, walletResponse.version) &&
        Objects.equals(this.statusCode, walletResponse.statusCode) &&
        Objects.equals(this.serviceTime, walletResponse.serviceTime) &&
        Objects.equals(this.error, walletResponse.error) &&
        Objects.equals(this.result, walletResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAgent, version, statusCode, serviceTime, error, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletResponse {\n");
    
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    serviceTime: ").append(toIndentedString(serviceTime)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

