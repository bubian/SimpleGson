package blog.pds.com.gson

import blog.pds.com.gson.adapter.ArraySecurityAdapter
import blog.pds.com.gson.adapter.NumberDeserializerTypeAdapter
import blog.pds.com.gson.strategy.SimpleDeserializationExclusionStrategy
import blog.pds.com.gson.strategy.SimpleSerializationExclusionStrategy
import blog.pds.com.three.gson.adapter.IntDeserializerAdapter
import com.google.gson.*
import java.io.Reader
import java.lang.reflect.Modifier
import java.lang.reflect.Type

/**
 * @author: pengdaosong
 * CreateTime:  2019/5/30 11:35 AM
 * Email：pengdaosong@medlinker.com
 * Description:
 */
class SimpleGson {

    companion object {
        const val TAG = "SimpleGson"
        private const val IGNORE_VERSIONS = -1.0
    }

    /**
     * 实例化Gson对象
     */
    private val gson : Gson

    constructor() :this(IGNORE_VERSIONS)

    constructor(version:Double){
        val builder = GsonBuilder()
        if (version != IGNORE_VERSIONS){
            builder.setVersion(version)
        }
        // 继承TypeAdapter接管Int类型序列化和反序列化
//        builder.registerTypeAdapter(Int::class.java, IntTypeAdapter())
        // 继承JsonDeserializer接管Int类型反序列化
        builder.registerTypeAdapter(Int::class.java, IntDeserializerAdapter())
        builder.registerTypeHierarchyAdapter(Number::class.java,NumberDeserializerTypeAdapter())
        builder.registerTypeHierarchyAdapter(List::class.java, ArraySecurityAdapter())
        // 添加反序列化排除策略
        builder.addDeserializationExclusionStrategy(SimpleDeserializationExclusionStrategy())
        // 添加序列化排除策略
        builder.addSerializationExclusionStrategy(SimpleSerializationExclusionStrategy())
        // @Expose
//        builder.excludeFieldsWithoutExposeAnnotation()
        // 设置日期格式
        builder.setDateFormat("yyyy-M-d H:mm:ss")
        // 配置Gson在序列化期间排除内部类
        builder.disableInnerClassSerialization()
        // 默认情况下，Gson会转义HTML字符，例如＆lt; ＆GT;使用此选项可将Gson配置为按原样解析HTML字符。
        builder.disableHtmlEscaping()
        // 以一定形式输出map的key,value
        builder.enableComplexMapKeySerialization()
        // 配置Gson排除具有指定修饰符的字段
        builder.excludeFieldsWithModifiers(Modifier.STATIC,Modifier.FINAL)
        // 通过在生成的JSON前面添加一些特殊文本，使输出JSON在Javascript中不可执行,（多了")]}" 这4个字符）
        builder.generateNonExecutableJson()
        // 配置Gson序列化为空的字段。默认情况下，Gson序列化期间省略所有为空的字段
        builder.serializeNulls()
        // JSON 规范的第2.4节不允许特殊的double值（NaN，Infinity，-Infinity）,但是，Javascript规范（见第4.3.20,4.3.22,4.3.23节）允许这些值作为有效的 Javascript 值。
        // 此外，大多数 JavaScript 引擎将接受 JSON 中的这些特殊值，而没有问题。 因此，在实际应用中，即使不能作为 JSON 规范，但是接受这些值作为有效的 JSON 是有意义的。
        // 如果你 Java 对象中包含一个正常的 Float 或者 Double 类型的数据，是可以正常序列化得到 JSON的，如果你传入 Float.POSITIVE_INFINITY 值，Gson 将会抛出异常，因为这个值是不能符合 JSON 标准的。
        // 解决的办法就是通过 GsonBuilder 设置 serializeSpecialFloatingPointValues() 方法
        builder.serializeSpecialFloatingPointValues()
        // 默认 Gson是严格遵守JSON指定的 * <a href="http://www.ietf.org/rfc/rfc4627.txt"> RFC 4627 </a>。标准，此选项使解析器可以不严格遵守。反序列化过程可以通过设置lenient属性来解决Json标准问题
        builder.setLenient()
        // 批量添加字段筛选策略
        builder.setExclusionStrategies()
        // 配置Gson在序列化和反序列化期间将特定命名策略应用于对象的字段,即获取实体类字段名的时候的策略，看源码
        // private fun getFieldNames(f: Field): List<String> {
        //     val annotation = f.getAnnotation(SerializedName::class.java!!)
        //     if (annotation == null) {
        //         val name = fieldNamingPolicy.translateName(f)
        //         return listOf(name)
        //     }
        //         ...
        // }
        // FieldNamingPolicy.IDENTITY Gson默认
        builder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        //为Long,long配置特定的序列化策略
        // LongSerializationPolicy.DEFAULT Gson默认
        builder.setLongSerializationPolicy(LongSerializationPolicy.DEFAULT)
        // 配置Gson输出适合页面的Json,以进行漂亮的打印。此选项仅影响Json序列化
        builder.setPrettyPrinting()
        // 创建Gson对象
        gson = builder.create()
    }


    /**********************反序列化***************************/

    @Throws(JsonSyntaxException::class)
    fun <T> fromJson(json: String, classOfT: Class<T>): T? {
        return gson.fromJson(json, classOfT)
    }

    @Throws(JsonSyntaxException::class)
    fun <T> fromJson(json: String?, typeOfT: Type): T? {
        return gson.fromJson(json, typeOfT)
    }

    @Throws(JsonSyntaxException::class, JsonIOException::class)
    fun <T> fromJson(json: Reader, classOfT: Class<T>): T {
        return gson.fromJson(json, classOfT)
    }

    @Throws(JsonIOException::class, JsonSyntaxException::class)
    fun <T> fromJson(json: Reader, typeOfT: Type): T {
        return gson.fromJson(json, typeOfT)
    }

    /**********************序列化***************************/

    fun toJson(src: Any?): String {
        return if (src == null) gson.toJson(JsonNull.INSTANCE) else gson.toJson(src, src.javaClass)
    }
}