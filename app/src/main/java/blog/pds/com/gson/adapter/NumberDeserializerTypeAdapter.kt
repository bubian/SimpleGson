package blog.pds.com.gson.adapter

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/31 6:58 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class NumberDeserializerTypeAdapter : JsonDeserializer<Number>{

    companion object {
        private const val TAG = "NumberDeserializer:"
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Number = try {
        Log.d(TAG,"type = $typeOfT")
        json!!.asNumber
    } catch (e: NumberFormatException) {
        -0.01
    }
}