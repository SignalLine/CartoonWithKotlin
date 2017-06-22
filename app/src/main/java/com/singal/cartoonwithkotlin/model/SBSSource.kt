package com.singal.cartoonwithkotlin.model

import com.singal.cartoonwithkotlin.getHtml
import org.jsoup.Jsoup

/**
 * Created by li on 2017/6/22.
 */
class SBSSource(): Source<String> {
    override fun obtain(url: String): String {
        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        val contentHtml =
                "<html>${doc.select("head").toString()}<body>${doc.select("div.mangaContentMainImg").toString()}</body></html>"

        return contentHtml
    }
}