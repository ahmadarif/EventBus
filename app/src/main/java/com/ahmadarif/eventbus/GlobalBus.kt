package com.ahmadarif.eventbus

import org.greenrobot.eventbus.EventBus

/**
 * Created by ARIF on 21-Jun-17.
 */
object GlobalBus {
    private var sBus: EventBus? = null
    val bus: EventBus
        get() {
            if (sBus == null) sBus = EventBus.getDefault()
            return sBus!!
        }
}
