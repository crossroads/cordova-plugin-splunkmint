package org.apache.cordova.splunkmint;

import com.splunk.mint.Mint;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Splunkmint extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException
  {

    try {
      String mintApiKey = args.getString(0);

      if(mintApiKey != null && mintApiKey.length() != 0) {
        Mint.initAndStartSession(cordova.getActivity().getApplicationContext(), mintApiKey);
        Log.v("MintPlugin", "Mint initAndStartSession done");
      } else {
        Log.v("MintPlugin", "Mint API key is not provided.");
      }

    } catch(Exception e) {
      Log.v("MintPlugin Error", e.getMessage());
    }

    return true;
  }
}
