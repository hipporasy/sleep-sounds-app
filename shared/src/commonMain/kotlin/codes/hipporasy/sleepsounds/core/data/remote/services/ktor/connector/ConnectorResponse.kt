package codes.hipporasy.sleepsounds.core.data.remote.services.ktor.connector

internal interface ConnectorResponse {
    fun statusCode(): Int
    suspend fun content(): String
}
