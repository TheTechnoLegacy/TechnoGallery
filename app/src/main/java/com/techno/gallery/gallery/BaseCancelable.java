package com.techno.gallery.gallery;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public abstract class BaseCancelable<T> implements Cancelable<T> {
    private static final int STATE_CANCELED = 8;
    private static final int STATE_CANCELING = 4;
    private static final int STATE_COMPLETE = 32;
    private static final int STATE_ERROR = 16;
    private static final int STATE_EXECUTING = 2;
    private static final int STATE_INITIAL = 1;
    private Cancelable<?> mCurrentTask;
    private Throwable mError;
    private T mResult;
    private int mState = STATE_INITIAL;
    private Thread mThread;

    public final T get() throws InterruptedException, ExecutionException {
        T handleTerminalStates;
        synchronized (this) {
            if (this.mState != STATE_INITIAL) {
                await();
                handleTerminalStates = handleTerminalStates();
            } else {
                this.mThread = Thread.currentThread();
                this.mState = STATE_EXECUTING;
                try {
                    this.mResult = execute();
                } catch (CancellationException e) {
                    CancellationException cancellationException = e;
                    this.mState = STATE_CANCELED;
                } catch (InterruptedException e2) {
                    InterruptedException interruptedException = e2;
                    this.mState = STATE_CANCELED;
                } catch (Throwable th) {
                    Throwable error = th;
                    synchronized (this) {
                        if (this.mState != STATE_CANCELING) {
                            this.mError = error;
                            this.mState = STATE_ERROR;
                        }
                    }
                    return handleTerminalStates;
                }
                synchronized (this) {
                    if (this.mState == STATE_CANCELING) {
                        this.mState = STATE_CANCELED;
                    }
                    if (this.mState == STATE_EXECUTING) {
                        this.mState = STATE_COMPLETE;
                    }
                    notifyAll();
                    if (this.mState == STATE_CANCELED && this.mResult != null) {
                        freeCanceledResult(this.mResult);
                    }
                    handleTerminalStates = handleTerminalStates();
                }
            }
        }
        return handleTerminalStates;
    }

    protected <T> T runSubTask(Cancelable<T> cancelable) throws InterruptedException, ExecutionException {
        synchronized (this) {
            if (this.mCurrentTask != null) {
                throw new IllegalStateException("cannot two subtasks at the same time");
            } else if (this.mState == STATE_CANCELING) {
                throw new CancellationException();
            } else {
                this.mCurrentTask = cancelable;
            }
        }
        try {
            Object obj = cancelable.get();
            synchronized (this) {
                this.mCurrentTask = null;
            }
            return obj;
        } catch (Throwable th) {
            synchronized (this) {
                this.mCurrentTask = null;
            }
        }
    }

    public synchronized boolean requestCancel() {
        boolean z;
        if (this.mState == STATE_INITIAL) {
            this.mState = STATE_CANCELED;
            notifyAll();
            z = false;
        } else if (this.mState == STATE_EXECUTING) {
            if (this.mCurrentTask != null) {
                this.mCurrentTask.requestCancel();
            }
            this.mState = STATE_CANCELING;
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private T handleTerminalStates() throws ExecutionException {
        if (this.mState == STATE_CANCELED) {
            throw new CancellationException();
        } else if (this.mState == STATE_ERROR) {
            throw new ExecutionException(this.mError);
        } else if (this.mState == STATE_COMPLETE) {
            return this.mResult;
        } else {
            throw new IllegalStateException();
        }
    }

    public synchronized void await() throws InterruptedException {
        while (!isInStates(56)) {
            wait();
        }
    }

    private boolean isInStates(int i) {
        return (this.mState & i) != 0;
    }

    protected void freeCanceledResult(T t) {
    }

    protected abstract T execute() throws Exception;
}