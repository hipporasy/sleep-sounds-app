package codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable

import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.connector.Connector
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
private val kJson = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
    encodeDefaults = true
    explicitNulls = false
}
internal abstract class ServiceRequestable<TRequestable : Requestable>(val connector: Connector<*, *>) {

    suspend inline fun <reified T> execute(request: TRequestable): T {
        val httpResponse = connector.execute(request)
        return kJson.decodeFromString(httpResponse.content())
    }
}
