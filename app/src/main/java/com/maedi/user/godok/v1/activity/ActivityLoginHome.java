package com.maedi.user.godok.v1.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.utils.DataScreenSize;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/14/2016.
 */

public class ActivityLoginHome extends AppCompatActivity {
    FragmentActivity fragmentActivity;

    Button login;

    RelativeLayout lcreg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);
        fragmentActivity = this;

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(fragmentActivity);
                String url ="http://47.88.214.175:38080/AskDocServ/app";

                //Map<String, String> params = new HashMap();
                //params.put("service", "LoginService");
                //params.put("method", "userLogin");
                try{
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("service", "LoginService");
                    jsonBody.put("method", "userLogin");
                    jsonBody.put("username", "0816936999");
                    jsonBody.put("password", "00000000");
                    final String requestBody = jsonBody.toString();

                    JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            // TODO Auto-generated method stub
                            Log.i("testVolley", "onResponse: "+response.toString());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub
                            Log.i("testVolley", "onError: "+error.toString());
                        }
                    }){

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() {
                            try {
                                return requestBody == null ? null : requestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                                return null;
                            }
                        }

                        @Override
                        protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                            String responseString = "";
                            try {
                                if (response != null) {
                                    responseString = new String(response.data, "UTF-8");
                                    // can get more details such as response.headers
                                    Log.i("testVolley", "Response<JSONObject>: "+responseString);
                                }

                                return Response.success(new JSONObject(responseString), HttpHeaderParser.parseCacheHeaders(response));
                            } catch (JSONException e) {
                                return Response.error(new ParseError(e));
                            } catch (UnsupportedEncodingException e) {
                                return Response.error(new ParseError(e));
                            }
                        }
                    };

                    queue.add(jsObjRequest);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(fragmentActivity,MainNavigationDrawer.class);
                startActivity(intent);
                fragmentActivity.finish();
            }
        });

        lcreg = (RelativeLayout)findViewById(R.id.layout_creg);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        DataScreenSize ds = new DataScreenSize(this);
        int heightScreen = ds.getHeight();
        Log.i("heightScreen", ""+heightScreen);
        int plusHg = ds.DpToPixel(80, this);
        int mtopMdpi = 300+plusHg;//px
        int mtopHdpi = 440+plusHg;
        int mtopXhdpi = 586+plusHg;
        int mtopXXhdpi = 880+plusHg;

        if(heightScreen <= 800)
            p.setMargins(0, mtopMdpi, 0, 0);
        else if(heightScreen > 800 & heightScreen <= 1280)
            p.setMargins(0, mtopHdpi, 0, 0);//left,top,right,bottom

        lcreg.setLayoutParams(p);

        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        }
        return super.onKeyDown(keyCode, event);
    }
}
