✅ What This Project Does

This project demonstrates a safe network request pattern in Kotlin to prevent Android applications from crashing when internet connectivity is unavailable or when an API request fails.

Normally, when an app directly calls a remote API and the user is offline or the server is down, the app throws an exception and may crash.
This project fixes that by introducing a structured, safe way to handle network failures without breaking the UI.

✅ What Changes I Made

I added a Safe Network Wrapper implementation with the following updates:

✅ 1. Introduced NetworkResult Sealed Class

A new sealed class that represents different outcomes of a network request:

Success(data)

Offline

Error(message)

This standardizes how results are returned.

✅ 2. Added safeApiCall() helper

This function wraps network calls inside a try/catch block:

Catches exceptions

Converts them into NetworkResult

Prevents application crashes

✅ 3. Updated UserRepository

All API calls are now executed using safeApiCall() instead of being called directly.
So the repository always returns NetworkResult, not raw data or exceptions.

✅ 4. Added Unit Tests

Tests ensure:

Successful API → Success

Offline → Offline

Unknown exceptions → Error

✅ Benefits

✅ Prevents Crashes
The UI never crashes when the network fails.

✅ Cleaner & Structured Error Handling
All API results follow the same format → easier to manage.

✅ Better User Experience
Users see friendly messages instead of a crash.

✅ More Testable Code
Repository logic can be tested without depending on real network calls.

✅ Easier Debugging
Failures are clearly categorized.

✅ Scalable Pattern
This approach fits well in real-world apps and can be reused for all API calls.
