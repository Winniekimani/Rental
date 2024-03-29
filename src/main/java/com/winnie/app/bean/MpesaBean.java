package com.winnie.app.bean;

import com.winnie.constants.Constants;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.Base64;

@Stateless
@Remote
public class MpesaBean implements MpesaBeanI{
    public String authenticate() throws IOException {

        String appKeySecret = Constants.APP_KEY + ":" + Constants.APP_SECRET;
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic " + encoded)
                .addHeader("cache-control", "no-cache")

                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        System.out.println(jsonObject.getString("access_token"));
        return jsonObject.getString("access_token");
    }

    @Override
    public String STKPushSimulation(String amount, String phoneNumber) throws IOException {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BusinessShortCode", Constants.partyB);
        jsonObject.put("Password", Constants.stkPassWord);
        jsonObject.put("Timestamp", Constants.stkDefaultTimeStamp);
        jsonObject.put("TransactionType", Constants.transactionType);
        jsonObject.put("Amount", amount);
        jsonObject.put("PhoneNumber", phoneNumber);
        jsonObject.put("PartyA", phoneNumber);
        jsonObject.put("PartyB", Constants.partyB);
        jsonObject.put("CallBackURL", Constants.callBackUrl);
        jsonObject.put("AccountReference", Constants.accountRefence);
        jsonObject.put("TransactionDesc", Constants.transactionDesc);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");

        OkHttpClient client = new OkHttpClient();
        String url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestJson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + authenticate())
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        // System.out.println(response.body().string());
        return response.body().string();
    }
}
