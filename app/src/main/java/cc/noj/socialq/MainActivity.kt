package cc.noj.socialq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity() {
    private lateinit var xWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize WebView
        xWebView = findViewById(R.id.xWebView)
        webViewSetup()
    }


    private fun webViewSetup() {
        xWebView.webViewClient = WebViewClient()
        xWebView.apply {
            loadUrl("https://socialq.noj.cc")
            settings.javaScriptEnabled = true
        }

        // Create a callback for handling back button presses
        val backButtonCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Check if the WebView can go back
                if (xWebView.canGoBack()) {
                    isEnabled = true
                    xWebView.goBack()
                } else {
                    isEnabled = false // use default back behavior.
                }
            }
        }
        // Add the callback to the OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, backButtonCallback)
    }
}