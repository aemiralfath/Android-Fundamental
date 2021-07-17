package com.aemiralfath.myservice

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.aemiralfath.myservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mServiceBound = false
    private lateinit var myBoundService: MyBoundService
    private lateinit var binding: ActivityMainBinding

    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val myBinder = p1 as MyBoundService.MyBinder
            myBoundService = myBinder.getService
            mServiceBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mServiceBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            startService(Intent(this@MainActivity, MyService::class.java))
        }

        binding.btnStartJobIntentService.setOnClickListener {
            val mStartIntentService = Intent(this@MainActivity, MyJobIntentService::class.java)
            mStartIntentService.putExtra(MyJobIntentService.EXTRA_DURATION, 5000L)
            MyJobIntentService.enqueueWork(this, mStartIntentService)
        }

        binding.btnStartBoundService.setOnClickListener {
            bindService(
                Intent(this, MyBoundService::class.java),
                mServiceConnection,
                BIND_AUTO_CREATE
            )
        }

        binding.btnStopBoundService.setOnClickListener {
            unbindService(mServiceConnection)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mServiceBound) {
            unbindService(mServiceConnection)
        }
    }
}