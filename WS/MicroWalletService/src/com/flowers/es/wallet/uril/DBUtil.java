package com.flowers.es.wallet.uril;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.flowers.es.wallet.helper.IPGTransactionHelper;
import com.microsoft.sqlserver.jdbc.*;

import io.swagger.model.WalletRequest1;
import io.swagger.model.WalletRequest2;
import io.swagger.model.WalletResponse;
import io.swagger.model.WalletResponse1;
import io.swagger.model.WalletResponse1Error;
import io.swagger.model.WalletResult1;
import io.swagger.model.WalletResult1Wallet;
import io.swagger.model.Wallets1;
import io.swagger.model.WalletsResponse;


public class DBUtil {
	static org.apache.log4j.Logger  m_log = org.apache.log4j.Logger.getLogger(DBUtil.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//callUSP_GetAccountRefInfo("3123");
			deleteWalletCard("4444341234","8");
			//callUpdateUSP_INSERT_UPDATE_WalletID(strAccountRefID, walletRequest)
			//WalletRequest2 req = new WalletRequest2();
			//WalletResult1Wallet wallet = new ;
			//req.setWallet(wallet );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static WalletResponse deleteWalletCard(String strAccountRefID, String strwalledId) throws SQLException{
		Connection con = null;
		CallableStatement cstmt = null;
		WalletResponse res = setDefaultWalletResponseData(null);
		con = getSQLDBConnection();
		cstmt = con.prepareCall("{call microsvcdb.wallet.USP_INSERT_UPDATE_WalletID(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//cstmt.setString(1, str_xml);
		cstmt.setLong("AccountRefID", Long.parseLong(strAccountRefID));			
		cstmt.setLong("WalletID", Long.parseLong(strwalledId));	
		cstmt.setString("CardType", null);
		cstmt.setString("PayType", null);
		cstmt.setString("Status", "I");	
		cstmt.setString("CardHolderName", null);
		cstmt.setString("CardNumber", null);
		cstmt.setString("LastFour", null);
		cstmt.setString("Expdate", null);
		cstmt.setString("User", "JOYS");
		cstmt.registerOutParameter("WalletID_New",  Types.BIGINT);
		/*cstmt.setLong(1, Long.parseLong(strAccountRefID));			
		cstmt.setString(2, null);
		cstmt.setString(3, null);
		cstmt.setShort(4, Short.parseShort("1"));
		cstmt.setString(5, null);
		cstmt.setString(6, null);
		cstmt.setNull(7, Types.TINYINT);
		cstmt.setString(8, null);
		cstmt.setString(9, "JOYS");*/
		//cstmt.sets
		//cstmt.setString(9, "JOYS");
		//cstmt.setLong("WalletID", Long.parseLong(strwalledId));
		cstmt.registerOutParameter("ERRCD", Types.INTEGER);
		cstmt.registerOutParameter("ERRCDDescr", Types.VARCHAR);
		System.out.println("Starting USP_INSERT_UPDATE_WalletID for deleting walled id: "+strwalledId+"for: "+strAccountRefID);	

		cstmt.execute();
		System.out.println("Starting USP_INSERT_UPDATE_WalletID completd for deleting walled id ");
		int errorcode=0;
		if(cstmt.getObject("ERRCD")!= null){
			errorcode = (int) cstmt.getObject("ERRCD");
			System.out.println("erroce code  for USP_INSERT_UPDATE_WalletID "+errorcode);	
		}
		/*if(cstmt.getObject(12)!= null){
			String str_err_mesage= (String) cstmt.getObject(11);
			System.out.println("errr message  for USP_INSERT_UPDATE_WalletID "+str_err_mesage);	
		}*/
		String str_err_mesage = "";
		if(cstmt.getObject("ERRCDDescr")!= null){
			str_err_mesage = (String) cstmt.getObject("ERRCDDescr");
			System.out.println("errr message  for USP_INSERT_UPDATE_WalletID "+str_err_mesage);	
		}
		if(errorcode != 0){
			addErrorObjectsToResponse(res, str_err_mesage, errorcode, "305");
		}
		
		return res;
		
	}
	public static WalletResponse callUpdateUSP_INSERT_UPDATE_WalletID(String strAccountRefID    , WalletRequest1 walletRequest) throws Exception{

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		int iseq =0;
		long i_walletID = 0;
		WalletResponse res = setDefaultWalletResponseData(null);
		WalletResult1Wallet wallet = walletRequest.getWallet();
		
		//wallet.get

		con = getSQLDBConnection();
		cstmt = con.prepareCall("{call microsvcdb.wallet.USP_INSERT_UPDATE_WalletID(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//cstmt.setString(1, str_xml);
		
		
		cstmt.setLong("AccountRefID", Long.parseLong(strAccountRefID));			
		cstmt.setLong("WalletID", Long.parseLong(wallet.getWalletId()));	
		cstmt.setString("CardType", wallet.getCardType());
		cstmt.setString("PayType", wallet.getPayType());
		if(wallet.getStatus() != null && wallet.getStatus().trim().length() > 0){
			cstmt.setString("Status", wallet.getStatus().trim());
		}
		else{
			cstmt.setNull("Status", Types.VARCHAR);
		}			
		cstmt.setString("CardHolderName", wallet.getCardHolderName());
		cstmt.setString("CardNumber", wallet.getCardNumber());
		cstmt.setString("LastFour", wallet.getLastFourDigits());
		cstmt.setString("Expdate", wallet.getExpiryDate());
		cstmt.setString("User", "JOYS");
		cstmt.registerOutParameter("WalletID_New",  Types.BIGINT);
		/*cstmt.setLong(1, Long.parseLong(strAccountRefID));			
		cstmt.setString(2, null);
		cstmt.setString(3, null);
		cstmt.setShort(4, Short.parseShort("1"));
		cstmt.setString(5, null);
		cstmt.setString(6, null);
		cstmt.setNull(7, Types.TINYINT);
		cstmt.setString(8, null);
		cstmt.setString(9, "JOYS");*/
		//cstmt.sets
		//cstmt.setString(9, "JOYS");
		//cstmt.setLong("WalletID", Long.parseLong(strwalledId));
		/*cstmt.registerOutParameter("ERRCD", Types.BIGINT);
		cstmt.registerOutParameter("ERRCDDescr", Types.VARCHAR);
		
		cstmt.setLong(1, Long.parseLong(strAccountRefID));			
		cstmt.setString(2, wallet.getCardType());
		cstmt.setString(3, wallet.getPayType());
		cstmt.setShort(4, Short.parseShort("0"));
		cstmt.setString(5, wallet.getCardHolderName());
		cstmt.setString(6, wallet.getCardNumber());
		cstmt.setShort(7, Short.parseShort(wallet.getLastFourDigits()));
		cstmt.setString(8, wallet.getExpiryDate());
		cstmt.setString(9, "JOYS");
		//cstmt.setString(9, "JOYS");
		cstmt.registerOutParameter(10, Types.BIGINT);
		cstmt.registerOutParameter(11, Types.INTEGER);*/
		//cstmt.registerOutParameter(12, Types.VARCHAR);
		cstmt.registerOutParameter("ERRCD", Types.INTEGER);
		cstmt.registerOutParameter("ERRCDDescr", Types.VARCHAR);
		System.out.println("Starting USP_INSERT_UPDATE_WalletID for "+strAccountRefID);	

		cstmt.execute();
		System.out.println("Starting USP_INSERT_UPDATE_WalletID completd for "+strAccountRefID);

		if(cstmt.getObject("ERRCD")!= null){
			iseq = (int) cstmt.getObject("ERRCD");
			System.out.println("erroce code  for USP_INSERT_UPDATE_WalletID "+iseq);	
		}
		String str_err_mesage = "";
		if(cstmt.getObject("ERRCDDescr")!= null){
			 str_err_mesage= (String) cstmt.getObject("ERRCDDescr");
			System.out.println("errr message  for USP_INSERT_UPDATE_WalletID "+str_err_mesage);	
		}
		if(cstmt.getObject("WalletID_New")!= null){
			i_walletID = (long) cstmt.getObject("WalletID_New");
			System.out.println("Completd  USP_INSERT_UPDATE_WalletID and Wallet ID: "+i_walletID);	
		}
		if(iseq != 0){
			addErrorObjectsToResponse(res, str_err_mesage, iseq, "304");
		}
		WalletResult1 result = new WalletResult1();
		WalletResult1Wallet walletre = new WalletResult1Wallet();
		walletre.setWalletId(wallet.getWalletId()+"");
		result.setWallet(walletre );
		res.setResult(result );

		return res;
	}
	public static WalletResponse callUSP_INSERT_UPDATE_WalletID(String strAccountRefID    , WalletRequest2 walletRequest) throws Exception{

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;		
		int iseq =0;
		long i_walletID = 0;
		WalletResponse res = setDefaultWalletResponseData(null);
		
		WalletResult1Wallet wallet = walletRequest.getWallet();
		
		String str_request_card_number = wallet.getCardNumber();
		System.out.println("Starting Call IPG for "+str_request_card_number);
		if(WalletUtil.isValidCCNumber(str_request_card_number)){
			String IPG_XML = WalletUtil.getIPGTokenRequestXML(str_request_card_number);
			String IPG_response_XML = IPGTransactionHelper.sendRequestToIPG(IPG_XML);
			if(IPG_response_XML.contains("<TKI>")){
				str_request_card_number = IPG_response_XML.substring(IPG_response_XML.indexOf("<TKI>")+"<TKI>".length(),IPG_response_XML.indexOf("</TKI>"));
			}
		}
		System.out.println("Completed Call IPG for "+str_request_card_number);
		con = getSQLDBConnection();
		System.out.println("Connection Completed");
		cstmt = con.prepareCall("{call microsvcdb.wallet.USP_INSERT_UPDATE_WalletID(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		//cstmt.setString(1, str_xml);
		/*cstmt.setLong(1, Long.parseLong(strAccountRefID));			
		cstmt.setString(2, wallet.getCardType());
		cstmt.setString(3, wallet.getPayType());
		cstmt.setShort(4, Short.parseShort("0"));
		cstmt.setString(5, wallet.getCardHolderName());
		cstmt.setString(6, wallet.getCardNumber());
		cstmt.setShort(7, Short.parseShort(wallet.getLastFourDigits()));
		cstmt.setString(8, wallet.getExpiryDate());
		cstmt.setString(9, "JOYS");
		//cstmt.setString(9, "JOYS");
		cstmt.registerOutParameter(10, Types.BIGINT);
		cstmt.registerOutParameter(11, Types.INTEGER);*/
		
		cstmt.setLong("AccountRefID", Long.parseLong(strAccountRefID));			
		cstmt.setNull("WalletID", Types.BIGINT);	
		cstmt.setString("CardType", wallet.getCardType());
		cstmt.setString("PayType", wallet.getPayType());
		if(wallet.getStatus() != null && wallet.getStatus().trim().length() > 0){
			cstmt.setString("Status", wallet.getStatus().trim());
		}
		else{
			cstmt.setString("Status", "A");
		}			
		cstmt.setString("CardHolderName", wallet.getCardHolderName());
		cstmt.setString("CardNumber", str_request_card_number);
		cstmt.setString("LastFour", wallet.getLastFourDigits());
		cstmt.setString("Expdate", wallet.getExpiryDate());
		cstmt.setString("User", "JOYS");
		cstmt.registerOutParameter("WalletID_New",  Types.BIGINT);
		cstmt.registerOutParameter("ERRCD", Types.INTEGER);
		cstmt.registerOutParameter("ERRCDDescr", Types.VARCHAR);
		
		//cstmt.registerOutParameter(12, Types.VARCHAR);
		System.out.println("Starting USP_INSERT_UPDATE_WalletID for "+strAccountRefID);	

		cstmt.execute();
		System.out.println("Starting USP_INSERT_UPDATE_WalletID completd for "+strAccountRefID);
		if(cstmt.getObject("WalletID_New")!= null){
			i_walletID = (long) cstmt.getObject("WalletID_New");
			System.out.println("Completd  USP_INSERT_UPDATE_WalletID and Wallet ID: "+i_walletID);	
		}
		if(cstmt.getObject("ERRCD")!= null){
			iseq = (int) cstmt.getObject("ERRCD");
			System.out.println("erroce code  for USP_INSERT_UPDATE_WalletID "+iseq);	
		}
		String str_err_mesage="";
		if(cstmt.getObject("ERRCDDescr")!= null){
			 str_err_mesage= (String) cstmt.getObject("ERRCDDescr");
			System.out.println("errr message  for USP_INSERT_UPDATE_WalletID "+str_err_mesage);	
		}
		
		if(iseq != 0){
			addErrorObjectsToResponse(res, str_err_mesage, iseq, "303");
		}
		WalletResult1 result = new WalletResult1();
		WalletResult1Wallet walletre = new WalletResult1Wallet();
		walletre.setWalletId(i_walletID+"");
		result.setWallet(walletre );
		res.setResult(result );

		return res;
	}
	public static Connection getSQLDBConnection(){
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		/*String hostname = DataLoadPropertyUtil.getFuctionalParameterValue("DB_HOST", "");
		String portNumber = DataLoadPropertyUtil.getFuctionalParameterValue("DB_PORT", "");
		String str_DB_Name = DataLoadPropertyUtil.getFuctionalParameterValue("DB_NAME", "");
		String str_DB_user= DataLoadPropertyUtil.getFuctionalParameterValue("DB_USER", "");
		String str_DB_pass = DataLoadPropertyUtil.getFuctionalParameterValue("DB_PASS", "");*/
		SQLServerDataSource ds = new SQLServerDataSource();
		//ds.setIntegratedSecurity(true);
		/*ds.setServerName("10.201.43.101");
		ds.setPortNumber(1433); 
		ds.setDatabaseName("MicroSvcDB");
		ds.setUser("paymentdev");
		ds.setPassword("paymentdev");*/

		/*ds.setServerName(hostname);
		ds.setPortNumber(Integer.parseInt(portNumber)); 
		ds.setDatabaseName(str_DB_Name);
		ds.setUser(str_DB_user);
		ds.setPassword(str_DB_pass);*/
		String str_new_url="jdbc:sqlserver://msazdbt01.database.windows.net:1433;database=MicroSvcDB;user=webservMicro@msazdbt01;password=webM1%$12rJKlm@01;encrypt=true;trustServerCertificate=false;hostNameInCertificate=eastus1-a.control.database.windows.net;loginTimeout=30";
		//String str_new_url = "jdbc:sqlserver://msazdbt01.database.windows.net:1433;database=PaymentDB;user=webservuser@msazdbt01;password=web12rJKlm@01;encrypt=true;trustServerCertificate=false;hostNameInCertificate=eastus1-a.control.database.windows.net;loginTimeout=30";
		ds.setURL(str_new_url);
		try {
			//DBConnectionUtil.getDBConnection("jdbc:apache:commons:dbcp:/PaymentDB");
			con = ds.getConnection();
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static WalletsResponse callUSP_GetAccountRefInfo(String str_externalReferenceID) throws Exception{
		
		WalletsResponse walletsResponse = setDefaultWalletsResponseData(null);
		//Wallets1 result ;
		//WalletsResponse.setResult(result );

		Wallets1 wallets = new Wallets1();
		List<WalletResult1Wallet> wallet =  new ArrayList<WalletResult1Wallet>();
		//wallet =  new List();
		//List<WalletResult1Wallet> wallet = new List<WalletResult1Wallet>;
		wallets.setWallet(wallet);
		
		//walletsList.asetWallet(wallet);
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	
		long long_externalReferenceID=0;
		long long_walletID =0;
		
		System.out.println("Calling   USP_GetAccountRefInfo for:"+str_externalReferenceID);
		if(str_externalReferenceID != null && str_externalReferenceID.trim().length() > 0){
			str_externalReferenceID = str_externalReferenceID.trim();
			long_externalReferenceID = Long.parseLong(str_externalReferenceID);
		}
		int  errorCode=0;

		con = getSQLDBConnection();
		System.out.println("Connection for   USP_GetAccountRefInfo completed");
		cstmt = con.prepareCall("{call microsvcdb.Wallet.USP_GetWalletInfo(?,?,?,?)}");
		cstmt.setLong(1, long_externalReferenceID);
		cstmt.setNull(2, Types.BIGINT);//(2, long_walletID);
		//cstmt.setLong(2, long_walletID);//(1, long_walletID);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.VARCHAR);

		cstmt.execute();
		System.out.println("Executing  USP_GetAccountRefInfo Completed");	
		rs =  cstmt.getResultSet();
		if(rs!=null){
			while(rs.next()){
				WalletResult1Wallet walletItem = new WalletResult1Wallet();
				walletItem.setCardHolderName(rs.getString("CardHolderName"));
				walletItem.setCardNumber(rs.getString("CardNumber"));
				walletItem.setCardType(rs.getString("CardTypeID"));
				walletItem.setExpiryDate(rs.getString("Expdate"));
				//walletItem.setFirstTwoDigits(rs.getString("CardTypeID"));
				walletItem.setLastFourDigits(rs.getString("LastFour"));
				walletItem.setPayType(rs.getString("PayTypeID"));
				walletItem.setWalletId(rs.getString("WalletId"));
				walletItem.setStatus(rs.getString("Status"));
				wallet.add(walletItem);
				//wallet.
			}
		}

		if(cstmt.getObject(3)!= null){
			errorCode = (int) cstmt.getObject(3);
			System.out.println("error code  for USP_GetAccountRefInfo "+errorCode);	
		}

		String str_error_msg ="";
		if(cstmt.getObject(4)!= null){
			 str_error_msg = (String) cstmt.getObject(4);
			System.out.println("errore message  for USP_GetAccountRefInfo "+str_error_msg);	
		}
		if(errorCode != 0){
			addErrorObjectsToWalletsResponse(walletsResponse,str_error_msg,errorCode,"302");
		}
		walletsResponse.setResult(wallets );
		return walletsResponse;
	}

	public static WalletResponse callUSP_GetWalletInfo(String str_externalReferenceID,String str_walletID) throws Exception{

		WalletResponse res = setDefaultWalletResponseData(null);
		WalletResult1 walletResult = new WalletResult1();
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;	
		long long_externalReferenceID=0;
		long long_walletID =Long.parseLong(str_walletID);

		System.out.println("Calling   USP_GetWalletInfo for:"+str_externalReferenceID);
		if(str_externalReferenceID != null && str_externalReferenceID.trim().length() > 0){
			str_externalReferenceID = str_externalReferenceID.trim();
			long_externalReferenceID = Long.parseLong(str_externalReferenceID);
		}
		int  errorCode=0;

		con = getSQLDBConnection();
		System.out.println("Connection for   USP_GetWalletInfo completed");
		cstmt = con.prepareCall("{call microsvcdb.Wallet.USP_GetWalletInfo(?,?,?,?)}");
		cstmt.setLong(1, long_externalReferenceID);
		//cstmt.setNull(2, Types.BIGINT);//(2, long_walletID);
		cstmt.setLong(2, long_walletID);//(1, long_walletID);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.VARCHAR);
		System.out.println("Executing USP_GetWalletInfo");

		cstmt.execute();
		System.out.println("Executing USP_GetWalletInfo Completed");		


		rs =  cstmt.getResultSet();
		if(rs !=null){
			while(rs.next()){
				WalletResult1Wallet walletItem = new WalletResult1Wallet();
				walletItem.setCardHolderName(rs.getString("CardHolderName"));//CardHolderName
				walletItem.setCardNumber(rs.getString("CardNumber"));
				walletItem.setCardType(rs.getString("CardTypeID"));
				walletItem.setExpiryDate(rs.getString("Expdate"));
				//walletItem.setFirstTwoDigits(rs.getString("CardTypeID"));
				walletItem.setLastFourDigits(rs.getString("LastFour"));
				walletItem.setPayType(rs.getString("PayTypeID"));
				walletItem.setWalletId(rs.getString("WalletId"));
				walletItem.setStatus(rs.getString("Status")+"");
				///WalletResult1Wallet walletItem22;
				walletResult.setWallet(walletItem);
				System.out.println("In loop Wallet"+walletItem.getWalletId());
			}
		}
		if(cstmt.getObject(3)!= null){
			errorCode = (int) cstmt.getObject(3);
			System.out.println("error code  for USP_GetWalletInfo "+errorCode);	
		}
		if(errorCode==0){	

			//System.out.println("error code  for USP_GetWalletInfo "+errorCode);	
		}
		String str_error_msg ="";
		if(cstmt.getObject(4)!= null){
			str_error_msg = (String) cstmt.getObject(4);
			System.out.println("error message  for USP_GetWalletInfo "+str_error_msg);	
		}
		if(errorCode!=0){
			addErrorObjectsToResponse(res,str_error_msg,errorCode,"301");
		}
		res.setResult(walletResult);
		return res;
	}

	public static WalletResponse addErrorObjectsToResponse(WalletResponse res, String str_error_msg, int erorCode, String statusCode){
		if(res == null){
			res =   setDefaultWalletResponseData(null);
		}
		WalletResponse1Error error = new WalletResponse1Error();
		error.setErrorCode(erorCode+"");
		error.setErrorDesc(str_error_msg);
		res.setError(error);
		res.setStatusCode(statusCode);
		return res;
		
	}
	public static WalletsResponse addErrorObjectsToWalletsResponse(WalletsResponse res, String str_error_msg, int erorCode, String statusCode){
		if(res == null){
			res = setDefaultWalletsResponseData(null);
		}
		WalletResponse1Error error = new WalletResponse1Error();
		error.setErrorCode(erorCode+"");
		error.setErrorDesc(str_error_msg);
		res.setError(error);
		res.setStatusCode(statusCode);
		return res;
		
	}
	
	public static WalletResponse setDefaultWalletResponseData(WalletResponse walletResponse1){
		if(walletResponse1 == null){
			walletResponse1 = new WalletResponse();
		}
    	walletResponse1.setUserAgent("1-800-Flowers, Inc./api Enterprise Services");
    	walletResponse1.setVersion("1.1.1");
    	walletResponse1.setStatusCode("200");
    	walletResponse1.setServiceTime("Yet To calculate");
    	return walletResponse1;
	}
	public static WalletsResponse setDefaultWalletsResponseData(WalletsResponse walletResponse){
		if(walletResponse == null){
			walletResponse = new WalletsResponse();
		}		
		walletResponse.setUserAgent("1-800-Flowers, Inc./api Enterprise Services");
		walletResponse.setVersion("1.1.1");
		walletResponse.setStatusCode("200");
		walletResponse.setServiceTime("Yet To calculate");
    	return walletResponse;
	}
	
}
