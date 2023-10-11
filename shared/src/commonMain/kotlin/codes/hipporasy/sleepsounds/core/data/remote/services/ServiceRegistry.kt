package codes.hipporasy.sleepsounds.core.data.remote.services

import codes.hipporasy.sleepsounds.core.data.remote.services.api.SleepApi
import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.connector.Connector
import codes.hipporasy.sleepsounds.core.data.remote.services.ktor.requestable.ServiceRequestable

internal class SleepService(connector: Connector<*, *>) : ServiceRequestable<SleepApi>(connector)