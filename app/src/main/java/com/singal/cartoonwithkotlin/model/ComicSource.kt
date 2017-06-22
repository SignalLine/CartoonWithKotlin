package com.singal.cartoonwithkotlin.model

import com.singal.cartoonwithkotlin.getHtml
import org.jsoup.Jsoup

/**
 *
 *
 * Created by li on 2017/6/22.
 */
class ComicSource () : Source<ArrayList<Comic>>{

    override fun obtain(url: String): ArrayList<Comic> {
        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        val elements = doc.select("div.mangaContentMainImg").select("img")
        val list = ArrayList<Comic>()

        for (element in elements){
            val comicUrl: String
            val temp = element.attr("src")
            if(temp.contains(".png") || temp.contains(".jpg") || temp.contains(".JPEG")){
                comicUrl = temp
            }else if("" != (element.attr("data-original"))){
                comicUrl = element.attr("data-orginal")
            }else{
                continue
            }

            val comic = Comic(comicUrl)
            list.add(comic)
        }

        return list
    }

}