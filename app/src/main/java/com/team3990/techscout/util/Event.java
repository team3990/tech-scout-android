package com.team3990.techscout.util;

public final class Event<T> {

    /** Properties */

    private T mContent;
    private boolean mHasBeenHandled;

    /**
     * Constructor
     *
     * Creates a new Event instance
     * */
    public Event(T content) {
        mContent = content;
        mHasBeenHandled = false;
    }

    /** Methods */

    public T getContent() { return mContent; }

    public boolean getHasBeenHandled() { return mHasBeenHandled; }

    public T getContentIfNotHandled() {
        if (mHasBeenHandled) {
            return null;
        }
        mHasBeenHandled = true;
        return mContent;
    }

}
