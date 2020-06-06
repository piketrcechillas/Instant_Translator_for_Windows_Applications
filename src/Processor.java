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
   

    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String text) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        String url = "https://api.mymemory.translated.net/get?q=" + text + "&langpair=en|vi&tbb=1&ie=UTF-8&oe=UTF-8&de=ngocphuongpro98@gmail.com";
        Request request = new Request.Builder()
                .url(url).get().build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // Parse String
    public static String textResult(String json_text) throws JSONException {
    	String value = null;
    	String transValue = null;
        JSONObject jsonObject = new JSONObject(json_text);    
        value = jsonObject.optString("responseData");
        JSONObject jsonObject1 = new JSONObject(value);   
        transValue = jsonObject1.optString("translatedText");

        return transValue;
    }
    
    public static void setKey(String key) {
    	subscriptionKey = key;
    }
    public static String getKey() {
    	return subscriptionKey;
    }
    
    public static String Translator(String text) {
        try {
            Processor translateRequest = new Processor();
            String response = translateRequest.Post(text);
            System.out.println(textResult(response));
            return textResult(response);
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;
    }
}