package codes.hipporasy.sleepsounds.core.data.remote.services.repository

import codes.hipporasy.sleepsounds.core.data.remote.services.SleepService
import codes.hipporasy.sleepsounds.core.domain.repository.SleepRepository

internal class SleepRepositoryImpl(private val sleepService: SleepService) : SleepRepository {
    override suspend fun getSleepSounds(): List<String> {
        TODO("Not yet implemented")
    }

}
