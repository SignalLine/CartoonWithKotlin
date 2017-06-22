package com.singal.cartoonwithkotlin.model

import com.singal.cartoonwithkotlin.getHtml
import org.jsoup.Jsoup

/**
 * Created by li on 2017/6/22.
 */
class BookSource(): Source<ArrayList<Cover>> {
    override fun obtain(url: String): ArrayList<Cover> {
        val list = ArrayList<Cover>()

        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        val elements = doc.select("ul.chinaMangaContentList").select("li")

        for (element in elements){
            val coverUrl = if(element.select("img").attr("src").contains("http")){
                element.select("img").attr("src")
            }else{
                "http://ishuhui.net" + element.select("img").attr("src")
            }

            val title = element.select("p").text()
            val link = "http://ishuhui.net" + element.select("div.chinaMangaContentImg").select("a").attr("href")

            val cover = Cover(coverUrl, title, link)

            list.add(cover)
        }

        return list
    }
}