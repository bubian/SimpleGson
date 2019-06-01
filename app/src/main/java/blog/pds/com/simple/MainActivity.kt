package blog.pds.com.simple

import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import blog.pds.com.gson.SimpleGson
import blog.pds.com.simple.entity.BaseGsonItemEntity
import blog.pds.com.simple.entity.JsonAdapterEntity
import blog.pds.com.simple.entity.SinceUntilEntity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity:"
    }

    val simpleGson = SimpleGson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // @JsonAdapter注解使用
        val jsonAdapterEntity = simpleGson.fromJson<JsonAdapterEntity>(BaseGsonItemEntity.DATA,JsonAdapterEntity::class.java)
        Log.i(TAG,"JsonAdapterEntity:deserialize:$jsonAdapterEntity")
        Log.i(TAG,"JsonAdapterEntity:serialize:${simpleGson.toJson(jsonAdapterEntity)}")
        // Since和Until使用
        val sinceUntilGson = SimpleGson(1.1)
        val sinceUntilEntity = sinceUntilGson.fromJson<SinceUntilEntity>(SinceUntilEntity.DATA,SinceUntilEntity::class.java)
        Log.i(TAG,"SinceUntilEntity:deserialize:$sinceUntilEntity")
        Log.i(TAG,"SinceUntilEntity:serialize:${sinceUntilGson.toJson(sinceUntilEntity)}")
        // enableComplexMapKeySerialization
        val original = LinkedHashMap<Point, String>()
        original[Point(5, 6)] = "a"
        original[Point(8, 8)] = "b"
        Log.i(TAG,"LinkedHashMap:serialize:${simpleGson.toJson(original)}")

    }
}
