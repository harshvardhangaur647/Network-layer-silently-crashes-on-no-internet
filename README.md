# Network-layer-silently-crashes-on-no-internet
Many Android/Kotlin apps fetch remote data. If the user is offline, API calls throw exceptions. A common mistake: the repository just forwards the exception → UI crashes → bad UX.

Safe Network Wrapper — Kotlin Sample
A simple way to prevent crashes from failed network requests in Android apps using Kotlin.
This example shows how to use safeApiCall() and the NetworkResult sealed class, so your UI doesn’t break when the API or internet fails.

🚨 Problem
Direct API calls like:

kotlin
val user = api.getUser()
can crash your app if:

Internet is off

Server is down

API returns error

The app crashes → Bad user experience.

✅ Goal
Handle API errors neatly, so your app:<br>

Never crashes<br>

Returns a clear result every time<br>

Three types of results:<br>

Success(data)<br>

Offline<br>

Error(message)<br>

✅ Solution Overview<br>
Add a sealed class: NetworkResult

Write a helper function: safeApiCall()

Update repository to use the wrapper

Add unit tests

This gives you:

No crashes

Clear error handling

Easier UI updates

Well-tested code<br>

📁 Project Structure<br>
text
/
├── network/
│   ├── NetworkResult.kt<br>
│   └── safeApiCall.kt<br>
├── api/<br>
│   └── UserApi.kt<br>
├── repository/
│   └── UserRepository.kt<br>
└── test/
    └── UserRepositoryTest.kt<br>
