package io.github.config4k.readers

import com.typesafe.config.Config
import com.typesafe.config.ConfigValue
import io.github.config4k.Config4kException
import java.time.Duration
import kotlin.reflect.KClass


class SelectReader {
    /**
     * Don't use this method.
     * Called by an inline function [io.github.config4k.Extension.extract],
     * this method is public even though it is just for internal.
     *
     * Add new case to support new type.
     *
     * @param type a instance got from the given type by reflection
     * @throws Config4kException.UnSupportedType if the passed type is not supported
     */
    fun getReader(type: KClass<*>): Reader<*> =
            when (type) {
                Int::class -> IntReader()
                String::class -> StringReader()
                Boolean::class -> BooleanReader()
                Double::class -> DoubleReader()
                Long::class -> LongReader()
                Duration::class -> DurationReader()
                Config::class -> ConfigReader()
                ConfigValue::class -> ConfigValueReader()
                else -> throw Config4kException.UnSupportedType(type)
            }
}