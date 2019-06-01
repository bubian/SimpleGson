package blog.pds.com.simple.entity

import com.google.gson.annotations.SerializedName

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/31 5:18 PM
 * Email：pengdaosong@medlinker.com
 * Description:
 */

open class BaseGsonItemEntity {

    companion object {
        const val DATA = "{" +
                "\"user_name\": \"dao_zhang\"," +
                "\"user_phone\": \"1570000000\"," +
                "\"time_stamp\": 15700000000," +
                "\"time_d\": \"ppp\"," +
                "\"user_sex\": \"1\"," +
                "\"user_age\": \"\"," +
                "\"user_id\": \"124555ddddddd\"" +
                "}"
    }

    @SerializedName(value = "user_name",alternate = ["userName","username"])
    var userName: String = ""
    var userPhone: String = ""
    @SerializedName(value = "time_stamp")
    val timeStamp : Long = -1
    @SerializedName(value = "time_d")
    val timeD : Number = 0.0
    var userAge: Int = -1
    var userSex: Int = -1
    var userId: Int = -1

    override fun toString(): String {
        return "BaseGsonItemEntity(userName='$userName', userPhone='$userPhone', userAge=$userAge, userSex=$userSex, userId=$userId, timeStamp=$timeStamp, timeD=$timeD)"
    }
}