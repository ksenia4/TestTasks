package com.webview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat.startActivity


class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

        if (Uri.parse(url).host == "maps.yandex.ru") {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("yandexmaps://maps.yandex.ru/"))
            return if (intent.resolveActivity(view.context.packageManager) != null) {
                startActivity(view.context, intent, null)
                true
            } else {
                false
            }
        } else if (Uri.parse(url).lastPathSegment == "pogoda") {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("yandexweather://weather.yandex.ru/"))
            return if (intent.resolveActivity(view.context.packageManager) != null) {
                startActivity(view.context, intent, null)
                true
            } else {
                view.loadUrl(url)
                true
            }

        } else {
            view.loadUrl(url)
            return true
        }
    }
}
