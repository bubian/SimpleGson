package blog.pds.com.gson.adapter

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 12:20 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

class JsonAdapterIDateDeserializer : JsonDeserializer<Date> {

    companion object {
        private const val TAG = "JsonAdapterDate:"
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date {
        Log.d(TAG,"type = $typeOfT")
        return Date()
    }

}