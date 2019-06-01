package blog.pds.com.simple.entity

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Since
import com.google.gson.annotations.Until

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 9:11 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
@Since(value = 1.3)
@Until(value = 2.2)
class ItemEntity{
    companion object {
        const val DATA = "{" +
                "\"url\": \"www.baidu.com\"," +
                "\"header_image\": \"www.jianshu.com\"," +
                "\"time\": \"21:00\"" +
                "}"
    }

    var url: String = ""
    @SerializedName(value = "header_image")
    var headerImage: String = ""
    var time : String = ""


    override fun toString(): String {
        return "ItemEntity(url='$url', headerImage='$headerImage', time='$time')"
    }
}