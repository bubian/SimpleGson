package blog.pds.com.simple.entity

import com.google.gson.annotations.Expose

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 9:24 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class SinceUntilEntity : BaseGsonItemEntity() {

    companion object {

        const val DATA = "{" +
                "\"user_name\": \"dao_zhang\"," +
                "\"user_phone\": \"1570000000\"," +
                "\"time_stamp\": 15700000000," +
                "\"time_d\": \"ppp\"," +
                "\"user_sex\": \"1\"," +
                "\"user_age\": \"\"," +
                "\"user_id\": \"124555ddddddd\"," +
                "\"itemEntity\": ${ItemEntity.DATA}," +
                "\"loveEntity\": ${ItemLoveEntity.DATA}" +
                "}"
    }

    var itemEntity : ItemEntity? = null
    @Expose(deserialize = true,serialize = true)
    var loveEntity: ItemLoveEntity? = null

    override fun toString(): String {
        return "${super.toString()} \\n SinceUntilEntity(itemEntity=$itemEntity, loveEntity=$loveEntity)"
    }
}