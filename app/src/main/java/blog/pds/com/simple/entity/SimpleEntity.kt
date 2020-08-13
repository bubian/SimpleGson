package blog.pds.com.simple.entity

/**
 * @author: pengdaosong
 * CreateTime:  2020-08-13 15:39
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class SimpleEntity {
    companion object {
        const val DATA = "{ \"userName\": \"dao_zhang\", \"userSex\": 1}"
    }

    var userName: String = ""
    var userSex: Int = 0
    override fun toString(): String {
        return "SimpleEntity(userName='$userName', userSex=$userSex)"
    }
}