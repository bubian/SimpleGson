package blog.pds.com.gson.adapter

import android.util.Log
import blog.pds.com.simple.entity.BaseGsonItemEntity
import blog.pds.com.simple.entity.JsonAdapterEntity
import com.google.gson.*
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/31 5:20 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

class JsonAdapterItemDeserializer : JsonDeserializer<JsonAdapterEntity>{

    companion object {
        private const val TAG = "JsonAdapterItem:"
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): JsonAdapterEntity {
        Log.d(TAG,"type = $typeOfT")
        if (null == json){
            return JsonAdapterEntity()
        }

        val item = JsonAdapterEntity()
        try {
            val jsonObj = json.asJsonObject
            val userName = jsonObj.get("user_name").asString
            item.userName = userName
            val userPhone = jsonObj.get("user_phone").asString
            item.userPhone = userPhone
            val userSex = jsonObj.get("user_sex").asInt
            item.userSex = userSex
            val userAge = jsonObj.get("user_age").asInt
            item.userAge = userAge
            val userId = jsonObj.get("user_id").asInt
            item.userId = userId
        }catch (e :Exception){
            e.printStackTrace()
        }
        return item
    }
}