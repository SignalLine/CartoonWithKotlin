package com.singal.cartoonwithkotlin.model

import com.singal.cartoonwithkotlin.getHtml
import org.jsoup.Jsoup

/**
 * 详细来源
 *
 * Created by li on 2017/6/22.
 */
class BookDetailSource() : Source<BookDetail> {
    override fun obtain(url: String): BookDetail {
        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        val pages = ArrayList<Page>()
        val elements = doc.select("div.volumeControl").select("a")

        for(element in elements){
            val title = element.text()
            val link = "http:ishuhui.net/" + element.attr("href")
            val page = Page(title, link)
            pages.add(page)
        }

        val updateTime = doc.select("div.mangaInfoDate").text()
        val detail = doc.select("div.mangaInfoTextare").text()
        val info = BookInfo(updateTime,detail)

        return BookDetail(pages, info)
    }
}