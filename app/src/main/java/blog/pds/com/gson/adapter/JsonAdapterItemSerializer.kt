package blog.pds.com.gson.adapter

import android.util.Log
import blog.pds.com.simple.entity.BaseGsonItemEntity
import blog.pds.com.simple.entity.JsonAdapterEntity
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/31 6:15 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

class JsonAdapterItemSerializer :JsonSerializer<JsonAdapterEntity>{

    companion object {
        private const val TAG = "JsonAdapter:"
        private const val SUFFIX = "_serializer"
    }
    override fun serialize(src: JsonAdapterEntity?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        Log.d(TAG,"type = $typeOfSrc")
        if (null == src){
            return JsonObject()
        }
        val jsonObject = JsonObject()
        jsonObject.addProperty("user_name",src.userName + SUFFIX)
        jsonObject.addProperty("user_phone",src.userPhone + SUFFIX)
        return jsonObject
    }
}