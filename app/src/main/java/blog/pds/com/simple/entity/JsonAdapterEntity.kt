package blog.pds.com.simple.entity

import blog.pds.com.gson.adapter.JsonAdapterParser
import com.google.gson.annotations.JsonAdapter

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 11:45 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

//@JsonAdapter(value = JsonAdapterItemDeserializer::class)
//@JsonAdapter(value = JsonAdapterItemSerializer::class)
@JsonAdapter(value = JsonAdapterParser::class)
class JsonAdapterEntity : BaseGsonItemEntity(){


}