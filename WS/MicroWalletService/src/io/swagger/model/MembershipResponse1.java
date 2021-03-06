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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.WalletResult2;
import javax.validation.constraints.*;

/**
 * MembershipResponse1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class MembershipResponse1   {
  @JsonProperty("user_agent")
  private String userAgent = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("statusCode")
  private String statusCode = null;

  @JsonProperty("serviceTime")
  private String serviceTime = null;

  @JsonProperty("result")
  private WalletResult2 result = null;

  public MembershipResponse1 userAgent(String userAgent) {
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

  public MembershipResponse1 version(String version) {
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

  public MembershipResponse1 statusCode(String statusCode) {
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

  public MembershipResponse1 serviceTime(String serviceTime) {
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

  public MembershipResponse1 result(WalletResult2 result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  @JsonProperty("result")
  @ApiModelProperty(value = "")
  public WalletResult2 getResult() {
    return result;
  }

  public void setResult(WalletResult2 result) {
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
    MembershipResponse1 membershipResponse1 = (MembershipResponse1) o;
    return Objects.equals(this.userAgent, membershipResponse1.userAgent) &&
        Objects.equals(this.version, membershipResponse1.version) &&
        Objects.equals(this.statusCode, membershipResponse1.statusCode) &&
        Objects.equals(this.serviceTime, membershipResponse1.serviceTime) &&
        Objects.equals(this.result, membershipResponse1.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userAgent, version, statusCode, serviceTime, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MembershipResponse1 {\n");
    
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    serviceTime: ").append(toIndentedString(serviceTime)).append("\n");
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

