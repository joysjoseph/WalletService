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
 * WalletResponse1Error
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class WalletResponse1Error   {
  @JsonProperty("errorCode")
  private String errorCode = null;

  @JsonProperty("errorDesc")
  private String errorDesc = null;

  public WalletResponse1Error errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Error Code
   * @return errorCode
   **/
  @JsonProperty("errorCode")
  @ApiModelProperty(example = "305", value = "Error Code")
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public WalletResponse1Error errorDesc(String errorDesc) {
    this.errorDesc = errorDesc;
    return this;
  }

  /**
   * Error Description or message
   * @return errorDesc
   **/
  @JsonProperty("errorDesc")
  @ApiModelProperty(example = "Invalid id", value = "Error Description or message")
  public String getErrorDesc() {
    return errorDesc;
  }

  public void setErrorDesc(String errorDesc) {
    this.errorDesc = errorDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WalletResponse1Error walletResponse1Error = (WalletResponse1Error) o;
    return Objects.equals(this.errorCode, walletResponse1Error.errorCode) &&
        Objects.equals(this.errorDesc, walletResponse1Error.errorDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorDesc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WalletResponse1Error {\n");
    
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorDesc: ").append(toIndentedString(errorDesc)).append("\n");
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
