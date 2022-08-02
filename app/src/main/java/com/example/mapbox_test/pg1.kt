package com.example.mapbox_test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.HttpAuthHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mapbox_test.databinding.Page1Binding
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.StringReader
import java.util.*


//import com.mapbox.maps.MapView



class Page1Fragment : Fragment() {

    private lateinit var binding: Page1Binding

    val arrData = mutableListOf<String>()

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible) {
            // Do something

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Page1Binding.inflate(inflater, container, false)
        val webView: WebView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient() {

            override fun onReceivedHttpAuthRequest(
                view: WebView?,
                handler: HttpAuthHandler,
                host: String?,
                realm: String?
            ) {
                handler.proceed("secuser", "aUFgb/3P")
            }

            override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest): Boolean {
                return false
            }
        }


        @Throws(XmlPullParserException::class, IOException::class)
        fun getXmlData(xml: String) {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(StringReader(xml))
            var eventType = parser.eventType
            var x = 0
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    when (parser.name) {
                        "link" -> {
                            parser.next()
                            if((parser.text != "https://www.sakigake.jp/")&&(parser.text != "https://www.sakigake.jp/news/article/20180415AK0000/")) {
                                Log.d("XXX", parser.text.takeLast(15).take(14))
                                arrData.add(parser.text.takeLast(15).take(14))
                                x += 1
                            }
                        }
                    }
                }
                eventType = parser.next()
            }
            val index: Int = Random().nextInt(arrData.size)
            val url = arrData[index]
            webView.loadUrl("https://www.sakigake.jp/test/mirai/app/article.jsp?kc=$url")
        }

        val url = "https://www.sakigake.jp/rss/news/akita.jsp"
        val queue = Volley.newRequestQueue(requireActivity().getApplicationContext())
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                getXmlData(response)
                //Log.d("XXX", response)
            },
            Response.ErrorListener {
                //Log.d("XXX", "error")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)


        //val index: Int = 5 //Random().nextInt(arrData.size)
        //val url2 = arrData[index]

        //Log.d("XXX", arrData[0])
        //webView.loadUrl("https://www.sakigake.jp/test/mirai/app/article.jsp?kc=20220729AK0015")
        //webView.loadUrl(url2)
        return binding.root
    }

}






//data class Item(val title: String?, val description: String?, val link: String? val pubDate: String?)
//// Parses the contents of an item. If it encounters a title, summary, or link tag, hands them off
//// to their respective "read" methods for processing. Otherwise, skips the tag.
//@Throws(XmlPullParserException::class, IOException::class)
//private fun readItem(parser: XmlPullParser): Item {
//    parser.require(XmlPullParser.START_TAG, ns, "rss")
//    var title: String? = null
//    var description: String? = null
//    var link: String? = null
//    var pubDate: String? = null
//    while (parser.next() != XmlPullParser.END_TAG) {
//        if (parser.eventType != XmlPullParser.START_TAG) {
//            continue
//        }
//        when (parser.name) {
//            "title" -> title = readTitle(parser)
//            "description" -> description = readDescription(parser)
//            "link" -> link = readLink(parser)
//            "pubDate" -> pubDate = readPubDate(parser)
//            else -> skip(parser)
//        }
//    }
//    return Item(title, description, link ,pubDate)
//}
//
//// Processes title tags in the rss.
//@Throws(IOException::class, XmlPullParserException::class)
//private fun readTitle(parser: XmlPullParser): String {
//    parser.require(XmlPullParser.START_TAG, ns, "title")
//    val title = readText(parser)
//    parser.require(XmlPullParser.END_TAG, ns, "title")
//    return title
//}
//
//// Processes link tags in the rss.
//@Throws(IOException::class, XmlPullParserException::class)
//private fun readLink(parser: XmlPullParser): String {
//    var link = ""
//    parser.require(XmlPullParser.START_TAG, ns, "link")
//    val tag = parser.name
//    val relType = parser.getAttributeValue(null, "rel")
//    if (tag == "link") {
//        if (relType == "alternate") {
//            link = parser.getAttributeValue(null, "href")
//            parser.nextTag()
//        }
//    }
//    parser.require(XmlPullParser.END_TAG, ns, "link")
//    return link
//}
//
//// Processes summary tags in the rss.
//@Throws(IOException::class, XmlPullParserException::class)
//private fun readDescription(parser: XmlPullParser): String {
//    parser.require(XmlPullParser.START_TAG, ns, "description")
//    val description = readText(parser)
//    parser.require(XmlPullParser.END_TAG, ns, "description")
//    return description
//}
//
//// Processes pubDate tags in the rss.
//@Throws(IOException::class, XmlPullParserException::class)
//private fun readPubDate(parser: XmlPullParser): String {
//    parser.require(XmlPullParser.START_TAG, ns, "pubDate")
//    val pubDate = readText(parser)
//    parser.require(XmlPullParser.END_TAG, ns, "pubDate")
//    return pubDate
//}
//
//// For the tags title and summary, extracts their text values.
//@Throws(IOException::class, XmlPullParserException::class)
//private fun readText(parser: XmlPullParser): String {
//    var result = ""
//    if (parser.next() == XmlPullParser.TEXT) {
//        result = parser.text
//        parser.nextTag()
//    }
//    return result
//}
//
//@Throws(XmlPullParserException::class, IOException::class)
//private fun skip(parser: XmlPullParser) {
//    if (parser.eventType != XmlPullParser.START_TAG) {
//        throw IllegalStateException()
//    }
//    var depth = 1
//    while (depth != 0) {
//        when (parser.next()) {
//            XmlPullParser.END_TAG -> depth--
//            XmlPullParser.START_TAG -> depth++
//        }
//    }
//}
//
//class NetworkActivity : Activity() {
//
//    companion object {
//
//        const val WIFI = "Wi-Fi"
//        const val ANY = "Any"
//        const val SO_URL = "http://stackoverflow.com/feeds/tag?tagnames=android&sort=newest"
//        // Whether there is a Wi-Fi connection.
//        private var wifiConnected = false
//        // Whether there is a mobile connection.
//        private var mobileConnected = false
//
//        // Whether the display should be refreshed.
//        var refreshDisplay = true
//        // The user's current network preference setting.
//        var sPref: String? = null
//    }
//
//
//
//    // Uses AsyncTask subclass to download the XML feed from stackoverflow.com.
//    // Uses AsyncTask to download the XML feed from stackoverflow.com.
//    fun loadPage() {
//
//        if (sPref.equals(ANY) && (wifiConnected || mobileConnected)) {
//            DownloadXmlTask().execute(SO_URL)
//        } else if (sPref.equals(WIFI) && wifiConnected) {
//            DownloadXmlTask().execute(SO_URL)
//        } else {
//            // show error
//        }
//    }
//
//
//}
//
//// Implementation of AsyncTask used to download XML feed from stackoverflow.com.
//private inner class DownloadXmlTask : AsyncTask<String, Void, String>() {
//    override fun doInBackground(vararg urls: String): String {
//        return try {
//            loadXmlFromNetwork(urls[0])
//        } catch (e: IOException) {
//            resources.getString(R.string.connection_error)
//        } catch (e: XmlPullParserException) {
//            resources.getString(R.string.xml_error)
//        }
//    }
//
//    override fun onPostExecute(result: String) {
//        setContentView(R.layout.main)
//        // Displays the HTML string in the UI via a WebView
//        findViewById<WebView>(R.id.webview)?.apply {
//            loadData(result, "text/html", null)
//        }
//    }
//}
//
//// Uploads XML from stackoverflow.com, parses it, and combines it with
//// HTML markup. Returns HTML string.
//@Throws(XmlPullParserException::class, IOException::class)
//private fun loadXmlFromNetwork(urlString: String): String {
//    // Checks whether the user set the preference to include summary text
//    val pref: Boolean = PreferenceManager.getDefaultSharedPreferences(this)?.run {
//        getBoolean("summaryPref", false)
//    } ?: false
//
//    val items: List<*> = downloadUrl(urlString)?.use { stream ->
//        // Instantiate the parser
//        AkitaNewsXmlParser().parse(stream)
//    } ?: emptyList()
//
//    return StringBuilder().apply {
//        append("<h3>${resources.getString(R.string.page_title)}</h3>")
//        append("<em>${resources.getString(R.string.updated)} ")
//        append("${formatter.format(rightNow.time)}</em>")
//        // StackOverflowXmlParser returns a List (called "entries") of Entry objects.
//        // Each Entry object represents a single post in the XML feed.
//        // This section processes the entries list to combine each entry with HTML markup.
//        // Each entry is displayed in the UI as a link that optionally includes
//        // a text summary.
//        items.forEach { item ->
//            append("<p><a href='")
//            append(item.link)
//            append("'>" + entry.title + "</a></p>")
//            // If the user set the preference to include summary text,
//            // adds it to the display.
//            if (pref) {
//                append(item.description)
//            }
//        }
//    }.toString()
//}
//
//// Given a string representation of a URL, sets up a connection and gets
//// an input stream.
//@Throws(IOException::class)
//private fun downloadUrl(urlString: String): InputStream? {
//    val url = URL(urlString)
//    return (url.openConnection() as? HttpURLConnection)?.run {
//        readTimeout = 10000
//        connectTimeout = 15000
//        requestMethod = "GET"
//        doInput = true
//        // Starts the query
//        connect()
//        inputStream
//    }
//}