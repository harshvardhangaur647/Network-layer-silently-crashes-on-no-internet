<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Networklayersilentlycrashesonnointernet_0"></a>Network-layer-silently-crashes-on-no-internet</h1>
<p class="has-line-data" data-line-start="1" data-line-end="2">Many Android/Kotlin apps fetch remote data. If the user is offline, API calls throw exceptions. A common mistake: the repository just forwards the exception → UI crashes → bad UX.</p>
<p class="has-line-data" data-line-start="3" data-line-end="6">Safe Network Wrapper — Kotlin Sample<br>
A simple way to prevent crashes from failed network requests in Android apps using Kotlin.<br>
This example shows how to use safeApiCall() and the NetworkResult sealed class, so your UI doesn’t break when the API or internet fails.</p>
<p class="has-line-data" data-line-start="7" data-line-end="9">🚨 Problem<br>
Direct API calls like:</p>
<p class="has-line-data" data-line-start="10" data-line-end="13">kotlin<br>
val user = api.getUser()<br>
can crash your app if:</p>
<p class="has-line-data" data-line-start="14" data-line-end="15">Internet is off</p>
<p class="has-line-data" data-line-start="16" data-line-end="17">Server is down</p>
<p class="has-line-data" data-line-start="18" data-line-end="19">API returns error</p>
<p class="has-line-data" data-line-start="20" data-line-end="21">The app crashes → Bad user experience.</p>
<p class="has-line-data" data-line-start="22" data-line-end="24">✅ Goal<br>
✔ Handle API errors neatly, so your app:&lt;br&gt;</p>
<p class="has-line-data" data-line-start="25" data-line-end="26">✔ Never crashes&lt;br&gt;</p>
<p class="has-line-data" data-line-start="27" data-line-end="28">✔ Returns a clear result every time&lt;br&gt;</p>
<p class="has-line-data" data-line-start="29" data-line-end="30">✔ Three types of results:&lt;br&gt;</p>
<p class="has-line-data" data-line-start="31" data-line-end="32">✔ Success(data)&lt;br&gt;</p>
<p class="has-line-data" data-line-start="33" data-line-end="34">✔ Offline&lt;br&gt;</p>
<p class="has-line-data" data-line-start="35" data-line-end="36">Error(message)&lt;br&gt;</p>
<p class="has-line-data" data-line-start="37" data-line-end="39">✅ Solution Overview&lt;br&gt;<br>
✅ Add a sealed class: NetworkResult</p>
<p class="has-line-data" data-line-start="40" data-line-end="41">✅ Write a helper function: safeApiCall()</p>
<p class="has-line-data" data-line-start="42" data-line-end="43">✅ Update repository to use the wrapper</p>
<p class="has-line-data" data-line-start="44" data-line-end="45">✅ Add unit tests</p>
<p class="has-line-data" data-line-start="46" data-line-end="47">This gives you:</p>
<p class="has-line-data" data-line-start="48" data-line-end="49">✔ No crashes</p>
<p class="has-line-data" data-line-start="50" data-line-end="51">✔ Clear error handling</p>
<p class="has-line-data" data-line-start="52" data-line-end="53">✔ Easier UI updates</p>
<p class="has-line-data" data-line-start="54" data-line-end="55">✔ Well-tested code&lt;br&gt;</p>
<p class="has-line-data" data-line-start="57" data-line-end="58">✅ Why This Matters</p>
<p class="has-line-data" data-line-start="59" data-line-end="64">✔ Avoids app crashes<br>
✔ Improves UX<br>
✔ Cleaner data flow<br>
✔ Helps debugging<br>
✔ Makes repository layer properly testable</p>
<p class="has-line-data" data-line-start="65" data-line-end="66">A common real-world pattern in Android + Kotlin.</p>
<p class="has-line-data" data-line-start="69" data-line-end="71">✅ FINAL SUBMISSION<br>
✅ Repository: <a href="https://github.com/harshvardhangaur647/kotlin-safe-network-wrapper">https://github.com/harshvardhangaur647/kotlin-safe-network-wrapper</a> &lt;br&gt;</p>
<p class="has-line-data" data-line-start="72" data-line-end="73">✅ Repository: Exact Commit</p>
<pre><code>    ` ` `
         e.g.  b71c4a92d8fe38c1a6f97d1563db1ee13b9a045c
    ` ` ` 
</code></pre>
<p class="has-line-data" data-line-start="78" data-line-end="80">After pushing code:&lt;br&gt;<br>
GitHub → Your Repo → Commits → Copy SHA</p>
<p class="has-line-data" data-line-start="81" data-line-end="83">✅ Task Description&lt;br&gt;<br>
❌ Problem</p>
<p class="has-line-data" data-line-start="84" data-line-end="85">When calling remote APIs, the app crashes when:</p>
<p class="has-line-data" data-line-start="86" data-line-end="87">No internet (IOException)</p>
<p class="has-line-data" data-line-start="88" data-line-end="89">Backend/server failure</p>
<p class="has-line-data" data-line-start="90" data-line-end="91">Unknown runtime error</p>
<p class="has-line-data" data-line-start="92" data-line-end="93">Because the repository directly invokes the API → unhandled exception → app crash</p>
<p class="has-line-data" data-line-start="94" data-line-end="95">✅ Expected&lt;br&gt;</p>
<p class="has-line-data" data-line-start="96" data-line-end="97">API errors must be handled safely:</p>
<p class="has-line-data" data-line-start="98" data-line-end="99">Do NOT crash app</p>
<p class="has-line-data" data-line-start="100" data-line-end="101">Return proper structured response to UI</p>
<p class="has-line-data" data-line-start="102" data-line-end="103">Allow UI to display user-friendly behavior</p>
<p class="has-line-data" data-line-start="105" data-line-end="106">✅ Goal&lt;br&gt;</p>
<p class="has-line-data" data-line-start="107" data-line-end="111">Implement a safe network wrapper pattern to:<br>
✅ Prevent app crash<br>
✅ Convert failures into NetworkResult<br>
✅ Improve testability &amp; UX</p>
<p class="has-line-data" data-line-start="112" data-line-end="114">✅ Solution (Kotlin)<br>
✅ Fix Summary</p>
<p class="has-line-data" data-line-start="115" data-line-end="119">✔ Added sealed NetworkResult wrapper<br>
✔ Added safeApiCall() helper<br>
✔ Updated UserRepository to use safe execution<br>
✔ Added tests for success, offline &amp; unknown error</p>
<p class="has-line-data" data-line-start="120" data-line-end="126">✅ Key Files Modified / Added<br>
<code></code> <code>app/src/main/java/com/example/network/NetworkResult.kt 
app/src/main/java/com/example/network/safeApiCall.kt 
app/src/main/java/com/example/repository/UserRepository.kt</code> <code></code></p>
<p class="has-line-data" data-line-start="127" data-line-end="130">✅ Prevents crashes &lt;br&gt;<br>
✅ Standardizes error handling<br>
✅ Works offline safely</p>
<p class="has-line-data" data-line-start="132" data-line-end="133">✅ Patch (Code Change)</p>
<p class="has-line-data" data-line-start="134" data-line-end="138">Provide EITHER:<br>
✅ GitHub commit link<br>
OR<br>
✅ Google Drive .patch file</p>
<p class="has-line-data" data-line-start="139" data-line-end="144">✅ Validation Tests<br>
Added file:<br>
<code></code> <code>app/src/test/java/com/example/repository/UserRepositoryTest.kt</code> <code></code></p>
<p class="has-line-data" data-line-start="145" data-line-end="146">Test Coverage</p>
<p class="has-line-data" data-line-start="147" data-line-end="151">✔ Verifies API success returns Success<br>
✔ Verifies IOException returns Offline<br>
✔ Verifies unknown exception returns Error<br>
✔ No crashes during API failure</p>
<p class="has-line-data" data-line-start="153" data-line-end="154">✅ Test Command&lt;br&gt;</p>
<p class="has-line-data" data-line-start="155" data-line-end="159">Standard test:<br>
<code></code> <code>./gradlew test</code> <code></code></p>
<p class="has-line-data" data-line-start="160" data-line-end="164">Run only specific test:<br>
<code></code> <code>./gradlew test --tests=&quot;com.example.repository.UserRepositoryTest&quot;</code> <code></code></p>
