# Network-layer-silently-crashes-on-no-internet
Many Android/Kotlin apps fetch remote data. If the user is offline, API calls throw exceptions. A common mistake: the repository just forwards the exception → UI crashes → bad UX.

🚨 Problem

Many Android/Kotlin apps call remote APIs directly:
    val user = api.getUser()
     

