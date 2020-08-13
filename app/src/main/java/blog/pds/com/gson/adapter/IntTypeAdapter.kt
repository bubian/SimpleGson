package blog.pds.com.three.gson.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/21 5:11 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

class IntTypeAdapter : TypeAdapter<Int>() {

    override fun read(i: JsonReader): Int? {
        if (i.peek() == JsonToken.NULL) {
            i.nextNull()
            return 0
        }
        return try {
            i.nextInt()
        } catch (e: Exception) {
            0
        }
    }

    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Int) {
        out.value(value)
    }

}