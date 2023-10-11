package codes.hipporasy.sleepsounds.core.domain.repository

import codes.hipporasy.sleepsounds.core.domain.repository.base.BaseRepository


interface SleepRepository : BaseRepository {
    suspend fun getSleepSounds(): List<String>
}
