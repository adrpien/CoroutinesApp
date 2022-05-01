package com.adrpien.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.concurrent.thread


/*

Corutine is light weight thread - asynchronous task (wątek w tle)

How to Coroutine:
1. Add depency and repositories in build.gradle (module)
2. Create coroutine job
3. Use runBlocking if you want to block main thread until coroutine is done.
   You can use suspended function from coroutine or another suspended function.
4. Use Deferred<T>  class to make coroutine with result
5. Use await method to get result


Suspending functions are at the center of everything coroutines.
A suspending function is simply a function that can be paused and resumed at a later time.
They can execute a long running operation and wait for it to complete without blocking.

Deffered is a job with result. Deferred class inherite Job class.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deffered: Deferred<Long> = CoroutineScope(Dispatchers.IO).async {
            delay(10000L)
            Log.d("DEFERRED_TAG", "Deferred message")
            10L
        }

        job = CoroutineScope(Dispatchers.IO).launch {
            delay(10000L)
            Log.d("COROUTINE_TAG", "Coroutine message")
        }

        // Thread.sleep(1000L)
        // job.join()

    }
}
