package com.nzf.markdown.video

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer

import org.joda.time.DateTime

import java.lang.reflect.Type

class DateTimeTypeAdapter : JsonSerializer<DateTime>, JsonDeserializer<DateTime> {

    override fun serialize(src: DateTime, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src.toString())
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): DateTime {
        return DateTime(json.asString)
    }

}
