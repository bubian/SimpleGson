package blog.pds.com.gson.strategy

import android.util.Log
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes

/**
 * @author: pengdaosong
 * CreateTime:  2019/6/1 9:01 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class SimpleSerializationExclusionStrategy : ExclusionStrategy {

    companion object {
        private const val TAG = "SSES:"
    }
    override fun shouldSkipField(f: FieldAttributes?): Boolean {
        Log.i(TAG,"shouldSkipField:FieldAttributes=$f")
        return false
    }

    override fun shouldSkipClass(clazz: Class<*>?): Boolean {
        Log.i(TAG,"shouldSkipClass:clazz=$clazz")
        return false
    }

}