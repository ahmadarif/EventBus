package com.ahmadarif.eventbus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_user.*
import org.greenrobot.eventbus.Subscribe
import android.widget.EditText




class UserFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        GlobalBus.bus.register(this)

        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
            // We are broadcasting the message here to listen to the subscriber.
            val fragmentActivityMessageEvent = Events.FragmentActivityMessage(editMessage.text.toString())
            GlobalBus.bus.post(fragmentActivityMessageEvent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        GlobalBus.bus.unregister(this)
    }

    @Subscribe
    fun getMessage(message: Events.ActivityFragmentMessage) {
        txtMessage.text = "${getString(R.string.message_received)} ${message.message}"
        Toast.makeText(activity, "${getString(R.string.message_fragment)} ${message.message}", Toast.LENGTH_SHORT).show()
    }

}