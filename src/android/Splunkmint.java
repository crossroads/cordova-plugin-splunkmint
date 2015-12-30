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

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.os.Bundle;

public class Splunkmint extends CordovaPlugin {

  private static final String MINT_META_NAME = "mint_apikey";

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    String mintApiKey = "";

    try {
      ApplicationInfo ai = cordova.getActivity().getPackageManager().getApplicationInfo(
          cordova.getActivity().getPackageName(),
          PackageManager.GET_META_DATA);
      Bundle bundle = ai.metaData;
      mintApiKey = bundle.getString(MINT_META_NAME);

      if(mintApiKey != null && mintApiKey.length() != 0) {
        Mint.initAndStartSession(cordova.getActivity().getApplicationContext(), mintApiKey);
        Log.v("MintPlugin", "Mint initAndStartSession done");
      } else {
        Log.v("MintPlugin", "Mint API key is not provided.");
      }

    } catch(Exception e) {
      Log.v("MintPlugin Error", e.getMessage());
    }
  }
}
