import java.io.*;
import java.net.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.*;
import okhttp3.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;

public class Processor {

    private static String subscriptionKey = "YOUR_SUBSCRIPTION_KEY";
    private static String endpoint = "https://api.cognitive.microsofttranslator.com";
    String url = endpoint + "/translate?api-version=3.0&to=vi";

    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String text) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("[{\n\t\"Text\": \"" + text + "\"\n}]",
        		mediaType
                );
        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Content-type", "application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // Parse String
    public static String textResult(String json_text) throws JSONException {
    	String value = null;
    	String transValue = null;
        JSONArray jsonArray = new JSONArray(json_text);    
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            value = jsonObject1.optString("translations");
        }
        JSONArray trans = new JSONArray(value);
        for(int i=0;i<trans.length();i++)
        {
            JSONObject jsonObject1 = trans.getJSONObject(i);
            transValue = jsonObject1.optString("text");
        }
        return transValue;
    }
    
    public static String Translator(String text) {
        try {
            Processor translateRequest = new Processor();
            String response = translateRequest.Post(text);
            return textResult(response);
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;
    }
}