package blog.pds.com.three.gson.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/21 5:05 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class StringTypeAdapter : TypeAdapter<String>() {

    override fun write(out: JsonWriter?, value: String?) {
        out?.value(value)
    }

    override fun read(i: JsonReader?): String {
        try {
            val peek = i?.peek()
            if (peek == JsonToken.NULL) {
                i.nextNull()
                return ""
            }
            return if (peek == JsonToken.BOOLEAN) java.lang.Boolean.toString(i.nextBoolean()) else i?.nextString() ?: ""
        }catch (e: Exception){
            return ""
        }
    }

}