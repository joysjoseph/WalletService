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
import io.swagger.model.WalletResult1Wallet;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Wallets1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-18T17:40:34.896Z")
public class Wallets1   {
  @JsonProperty("wallet")
  private List<WalletResult1Wallet> wallet = null;

  public Wallets1 wallet(List<WalletResult1Wallet> wallet) {
    this.wallet = wallet;
    return this;
  }

  public Wallets1 addWalletItem(WalletResult1Wallet walletItem) {
    if (this.wallet == null) {
      this.wallet = new ArrayList<WalletResult1Wallet>();
    }
    this.wallet.add(walletItem);
    return this;
  }

  /**
   * Get wallet
   * @return wallet
   **/
  @JsonProperty("wallet")
  @ApiModelProperty(value = "")
  public List<WalletResult1Wallet> getWallet() {
    return wallet;
  }

  public void setWallet(List<WalletResult1Wallet> wallet) {
    this.wallet = wallet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Wallets1 wallets1 = (Wallets1) o;
    return Objects.equals(this.wallet, wallets1.wallet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wallet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Wallets1 {\n");
    
    sb.append("    wallet: ").append(toIndentedString(wallet)).append("\n");
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

