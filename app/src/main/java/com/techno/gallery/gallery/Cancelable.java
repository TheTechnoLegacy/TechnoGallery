package com.techno.gallery.gallery;

public interface Cancelable<T> {
    void await() throws java.lang.InterruptedException;

    T get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException;

    boolean requestCancel();
}