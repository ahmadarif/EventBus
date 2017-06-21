package com.ahmadarif.eventbus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()

        btnSubmit.setOnClickListener {
            val message = Events.ActivityFragmentMessage(etMessage.text.toString())
            GlobalBus.bus.post(message)
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalBus.bus.register(this)
    }

    override fun onStop() {
        super.onStop()
        GlobalBus.bus.unregister(this)
    }

    private fun addFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, UserFragment())
                .commit()
    }

    @Subscribe
    fun getMessage(message: Events.FragmentActivityMessage) {
        txtMessage.text = "${getString(R.string.message_received)} ${message.message}"

        Toast.makeText(applicationContext,
                "${getString(R.string.message_main_activity)} ${message.message}",
                Toast.LENGTH_SHORT).show()
    }

}