package blog.pds.com.three.gson.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/21 6:05 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

/**
 * 只影响反序列化过程
 */
class IntDeserializerAdapter : JsonDeserializer<Int> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Int = try {
        json!!.asInt
    } catch (e: NumberFormatException) {
        0
    }
}