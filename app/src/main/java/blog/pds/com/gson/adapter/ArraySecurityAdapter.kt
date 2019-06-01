package blog.pds.com.gson.adapter

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 11:19 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class ArraySecurityAdapter: JsonDeserializer<List<*>> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): List<*> {
        return if(json!!.isJsonArray){
            val newGson = Gson()
            newGson.fromJson(json, typeOfT)
        }else{
            Collections.EMPTY_LIST
        }
    }
}
