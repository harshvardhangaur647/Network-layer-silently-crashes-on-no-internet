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
✔ Handle API errors neatly, so your app:<br>

✔ Never crashes<br>

✔ Returns a clear result every time<br>

✔ Three types of results:<br>

✔ Success(data)<br>

✔ Offline<br>

Error(message)<br>

✅ Solution Overview<br>
✅ Add a sealed class: NetworkResult

✅ Write a helper function: safeApiCall()

✅ Update repository to use the wrapper

✅ Add unit tests

This gives you:

✔ No crashes

✔ Clear error handling

✔ Easier UI updates

✔ Well-tested code<br>


✅ Why This Matters

✔ Avoids app crashes
✔ Improves UX
✔ Cleaner data flow
✔ Helps debugging
✔ Makes repository layer properly testable

A common real-world pattern in Android + Kotlin.



✅ FINAL SUBMISSION
✅ Repository: https://github.com/harshvardhangaur647/kotlin-safe-network-wrapper <br>

✅ Repository: Exact Commit

` ` `
       e.g.  b71c4a92d8fe38c1a6f97d1563db1ee13b9a045c
` ` ` 

After pushing code:<br>
GitHub → Your Repo → Commits → Copy SHA

✅ Task Description<br>
❌ Problem

When calling remote APIs, the app crashes when:

No internet (IOException)

Backend/server failure

Unknown runtime error

Because the repository directly invokes the API → unhandled exception → app crash

✅ Expected<br> 

API errors must be handled safely:

Do NOT crash app

Return proper structured response to UI

Allow UI to display user-friendly behavior


✅ Goal<br>

Implement a safe network wrapper pattern to:
✅ Prevent app crash
✅ Convert failures into NetworkResult
✅ Improve testability & UX

✅ Solution (Kotlin)
✅ Fix Summary

✔ Added sealed NetworkResult wrapper
✔ Added safeApiCall() helper
✔ Updated UserRepository to use safe execution
✔ Added tests for success, offline & unknown error

✅ Key Files Modified / Added<br>
 ` ` ` 
     app/src/main/java/com/example/network/NetworkResult.kt
     app/src/main/java/com/example/network/safeApiCall.kt
     app/src/main/java/com/example/repository/UserRepository.kt
` ` ` 

✅ Prevents crashes <br>
✅ Standardizes error handling
✅ Works offline safely


✅ Patch (Code Change)<br>

Provide EITHER:
✅ GitHub commit link
OR
✅ Google Drive .patch file

✅ Validation Tests
Added file:
` ` ` 
     app/src/test/java/com/example/repository/UserRepositoryTest.kt
     
` ` ` 

Test Coverage<br>

✔ Verifies API success returns Success
✔ Verifies IOException returns Offline
✔ Verifies unknown exception returns Error
✔ No crashes during API failure


✅ Test Command<br>

Standard test:
` ` `
     ./gradlew test
     
` ` ` 

Run only specific test:
` ` ` 
    ./gradlew test --tests="com.example.repository.UserRepositoryTest"
    
` ` ` 




