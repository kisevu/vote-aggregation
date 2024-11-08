package com.ameda.kevin.kisevu.works.votes.exceptions;
/*
*
@author ameda
@project votes
*
*/

public class PollCouldNotBeFound extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public PollCouldNotBeFound(String message) {
    /*
    *
    @author ameda
    @project votes
    *
    */
        super(message);
    }

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public PollCouldNotBeFound() {
    /*
    *
    @author ameda
    @project votes
    *
    */
        super();
    }
}
