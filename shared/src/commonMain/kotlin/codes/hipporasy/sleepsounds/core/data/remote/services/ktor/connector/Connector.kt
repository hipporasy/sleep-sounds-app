package codes.hipporasy.sleepsounds.core.data.remote.services.ktor.connector

import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable.Requestable

internal interface Connector<TRequest, TResponse> where TResponse : ConnectorResponse {

    suspend fun execute(request: Requestable): TResponse

    fun urlRequest(request: Requestable): TRequest
}
