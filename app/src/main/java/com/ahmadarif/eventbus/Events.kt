package com.ahmadarif.eventbus

/**
 * Created by ARIF on 21-Jun-17.
 */
class Events {

    // Event used to send message from fragment to activity.
    class FragmentActivityMessage(val message: String)

    // Event used to send message from activity to fragment.
    class ActivityFragmentMessage(val message: String)

    // Event used to send message from activity to activity.
    class ActivityActivityMessage(val message: String)

}