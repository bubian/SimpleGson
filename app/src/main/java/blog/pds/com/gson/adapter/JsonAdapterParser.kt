package blog.pds.com.gson.adapter

import blog.pds.com.simple.entity.BaseGsonItemEntity
import blog.pds.com.simple.entity.JsonAdapterEntity
import com.google.gson.*
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/31 6:48 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class JsonAdapterParser : JsonDeserializer<BaseGsonItemEntity>,JsonSerializer<JsonAdapterEntity>{

    override fun serialize(src: JsonAdapterEntity?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonAdapterItemSerializer().serialize(src,typeOfSrc,context)
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): JsonAdapterEntity {
        return JsonAdapterItemDeserializer().deserialize(json,typeOfT,context)
    }

}