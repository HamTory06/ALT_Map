package com.example.alt_map

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


object Getweather {
    public fun get(): String {

        val lat = "35.6632493";
        val lon = "128.4141269";
        val API_key = "814ea831f9adecdf0164966dbecab1ce"
        val sb =
            readFromUrl("https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$lon&appid=$API_key")
        return sb.toString()
    }

    private fun readFromUrl(url_addr: String): StringBuffer? {
        var url: URL? = null
        var conn: HttpURLConnection? = null
        var `in`: InputStream? = null
        var reader: InputStreamReader? = null
        var br: BufferedReader? = null
        val buf = CharArray(512)
        val sb = StringBuffer()
        try {
            url = URL(url_addr)
            conn = url.openConnection() as HttpURLConnection
            if (conn != null) {
                conn.connectTimeout = 2000
                conn.requestMethod = "GET"
                conn.addRequestProperty(
                    "Content-Type",
                    "application/x-www-form-urlencoded; charset=UTF-8"
                )
                conn.useCaches = false
                conn.connect()
                val responseCode = conn.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    `in` = conn.inputStream
                    reader = InputStreamReader(`in`, "utf-8")
                    br = BufferedReader(reader)
                    var cnt: Int
                    while (br.read(buf).also { cnt = it } != -1) {
                        sb.append(buf, 0, cnt)
                    }
                } else {
                    return null
                }
            } else {
                return null
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                br!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            conn?.disconnect()
        }
        val indf = sb.indexOf("main") + 7
        val indl = sb.substring(indf).indexOf("\"") + indf
        return StringBuffer(sb.substring(indf, indl))
    }
}