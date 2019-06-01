package blog.pds.com.simple.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Since
import com.google.gson.annotations.Until

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 9:16 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

class ItemLoveEntity{
    companion object {
        const val DATA = "{" +
                "\"gril_name\": \"刘亦菲\"," +
                "\"gril_header\": \"www.jianshu.com\"," +
                "\"gril_age\": 21," +
                "\"header_birth\": \"1999.0.1\"" +
                "}"
    }
    @SerializedName(value = "gril_name")
    @Since(value = 1.5)
    var grilName: String = ""
    @Until(value = 1.5)
    var gril_header: String = ""
    @Since(value = 1.0)
    @Until(value = 2.2)
    var gril_age : Int = 0
    @Expose(deserialize = true,serialize = true)
    var header_birth :String = ""
    override fun toString(): String {
        return "ItemLoveEntity(grilName='$grilName', gril_header='$gril_header', gril_age=$gril_age, header_birth='$header_birth')"
    }
}