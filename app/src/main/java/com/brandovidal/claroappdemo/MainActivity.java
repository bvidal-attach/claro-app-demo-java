package com.brandovidal.claroappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    // Initialize analytics
    private final FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    void setWebView() {
        // Define URL
        String URL = "https://www.pythontutorial.net";

        // Define WebView
        WebView webView = (WebView) findViewById(R.id.webview);

        // Define WebViewClint
        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadJS(webView);
            }
        };

        // Load WebViewClient
        webView.setWebViewClient(webViewClient);

        // Load setting
        webView.getSettings().setJavaScriptEnabled(true);

        // Load view
        webView.loadUrl(URL);

        // add JavaScript
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
    }

    public static class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
    
    void loadJS(WebView webView) {
        String injection =
                "javascript: var title = document.querySelector('h1.entry-title');" +
                "title.style.color = 'green';" +
                "title.addEventListener('click', function() { Android.showToast('inject code from java'); });"+
                "window.localStorage.setItem('is-java-native', 'true');"
                ;
        webView.evaluateJavascript(injection, null);
//        webView.loadUrl(injection);
    }

    void screenView() {
        Bundle params = new Bundle();
        params.putString(FirebaseAnalytics.Param.SCREEN_NAME, "centro de ayuda");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params);
    }

    void inicio_sesion() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "login");
        params.putString("event_action", "click");
        params.putString("event_label", "$nombre_elemento");

        mFirebaseAnalytics.logEvent("inicio_sesion", params);

    }

    void menu_inferior_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "menu principal");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("menu_inferior_click", params);
    }

    void herramientas_vendemas_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "herramientas vendemas");
        params.putString("event_action", "click");
        params.putString("event_label", "sobre la app");

        mFirebaseAnalytics.logEvent("herramientas_vendemas_click", params);
    }

    void menu_ver_mas_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "herramientas vendemas");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("menu_ver_mas_click", params);
    }

    void regresar_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "volver");
        params.putString("event_action", "click");
        params.putString("event_label", "$nombre_pantalla");

        mFirebaseAnalytics.logEvent("regresar_click", params);
    }

    void dashboard_slider_change() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard slider");
        params.putString("event_action", "change");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_slider_change", params);
    }

    void dashboard_saldo_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard saldo");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_saldo_click", params);
    }

    void dashboard_plan_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard plan");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_plan_click", params);
    }

    void dashboard_saldo_prepago_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard saldo prepago");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_saldo_prepago_click", params);
    }

    void dashboard_plan_prepago_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard plan prepago");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_plan_prepago_click", params);
    }

    void dashboard_servicio_hogar_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard servicio hogar");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_servicio_hogar_click", params);
    }

    void dashboard_pendiente_pago_click() {
        Bundle params = new Bundle();
        // Datos genéricos
        params.putString("event_category", "dashboard pendiente pago");
        params.putString("event_action", "click");
        params.putString("event_label", "$opcion");

        mFirebaseAnalytics.logEvent("dashboard_pendiente_pago_click", params);
    }

    void sendCustomEvent() {
        // Find button
//        Button btnSend = findViewById(R.id.btn_send);

        // Add Listener to button click
//        btnSend.setOnClickListener(view -> {
        Bundle params = new Bundle();
        params.putString("event_category", "preguntas frecuentes");
        params.putString("event_action", "click");
        params.putString("event_label", "caja de busqueda");

        // Send event
        mFirebaseAnalytics.logEvent("preguntas_frecuentes_click", params);
//        });

    }
}