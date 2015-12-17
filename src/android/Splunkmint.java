import com.splunk.mint.Mint;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;

import java.util.Random;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.os.Bundle;

public class Splunkmint extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException
  {
    String mintApiKey = "";
    boolean mintKeyFound = false;

    // load flurry api key from manifest meta data
    try {
      mintApiKey = args[0];
      mintKeyFound = true;
    } catch (PackageManager.NameNotFoundException e) {
      Log.e("MintPlugin", "Failed to load meta-data, NameNotFound: " + e.getMessage());
    } catch (NullPointerException e) {
      Log.e("MintPlugin", "Failed to load meta-data, NullPointer: " + e.getMessage());
    } catch (Exception e) {
      Log.e("MintPlugin", "MintPlugin Exception: " + e.getMessage());
    }

    if (mintKeyFound) {
      Mint.initAndStartSession(cordova.getActivity(), mintApiKey);
      Log.v("MintPlugin", "Mint initAndStartSession done");
    }
  }
}
