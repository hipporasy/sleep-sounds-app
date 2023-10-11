package codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable

import io.ktor.http.HttpHeaders

internal interface Requestable {
    val url: String

    val path: String

    val httpMethod: RequestMethod

    val headers: HashMap<String, String>
        get() {
            val hashMap = hashMapOf<String, String>()
            hashMap[HttpHeaders.ContentType] = "application/json"
            return hashMap
        }

    val parameter: Map<String, Any>?

    val body: Any?

    val timeoutInSeconds: Long?
        get() = 60
}

internal enum class RequestMethod(val value: String) {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT"),
    PATCH("PATCH")
}
