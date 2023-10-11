package codes.hipporasy.sleepsounds.core.data.remote.services.ktor.connector

import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable.RequestMethod
import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable.Requestable
import io.ktor.client.HttpClient
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.content.OutgoingContent
import org.koin.core.component.KoinComponent

internal class KtorConnector(private val httpClient: HttpClient) :
    Connector<HttpRequestBuilder, KtorConnectorResponse>, KoinComponent {

    override suspend fun execute(request: Requestable): KtorConnectorResponse {
        val response: HttpResponse = httpClient.request(urlRequest(request))
        return KtorConnectorResponse(response)
    }

    override fun urlRequest(request: Requestable): HttpRequestBuilder {
        return HttpRequestBuilder().apply {
            method = HttpMethod(request.httpMethod.value)
            request.timeoutInSeconds?.let { timeout ->
                val timeoutInMillis = timeout * 1000L
                timeout {
                    requestTimeoutMillis = timeoutInMillis
                    connectTimeoutMillis = timeoutInMillis
                    socketTimeoutMillis = timeoutInMillis
                }
            }
            url("${request.url}/${request.path.removePrefix("/")}")
            headers {
                request.headers.forEach {
                    this.append(it.key, it.value)
                }
            }
            request.parameter?.forEach {
                parameter(it.key, it.value.toString())
            }
            if (request.httpMethod == RequestMethod.GET) {
                setBody(object : OutgoingContent.NoContent() {})
            } else {
                setBody(request.body)
            }
        }
    }
}
