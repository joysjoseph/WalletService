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
import javax.validation.constraints.*;

/**
 * WalletResult2Membership
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class WalletResult2Membership   {
  @JsonProperty("startDate")
  private String startDate = null;

  @JsonProperty("endDate")
  private String endDate = null;

  @JsonProperty("status")
  private String status = null;

  public WalletResult2Membership startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * start Date
   * @return startDate
   **/
  @JsonProperty("startDate")
  @ApiModelProperty(example = "01/01/2017", required = true, value = "start Date")
  @NotNull
  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public WalletResult2Membership endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * end Date
   * @return endDate
   **/
  @JsonProperty("endDate")
  @ApiModelProperty(example = "01/01/2018", value = "end Date")
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public WalletResult2Membership status(String status) {
    this.status = status;
    return this;
  }

  /**
   * status
   * @return status
   **/
  @JsonProperty("status")
  @ApiModelProperty(example = "A", value = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletResult2Membership walletResult2Membership = (WalletResult2Membership) o;
    return Objects.equals(this.startDate, walletResult2Membership.startDate) &&
        Objects.equals(this.endDate, walletResult2Membership.endDate) &&
        Objects.equals(this.status, walletResult2Membership.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletResult2Membership {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
