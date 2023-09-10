package codes.hipporasy.sleepsounds

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform