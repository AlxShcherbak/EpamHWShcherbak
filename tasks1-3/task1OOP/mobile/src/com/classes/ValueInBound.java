package com.classes;

/**
 * Created by Alx Shcherbak on 01.06.2015.
 */
public class ValueInBound {
    Double downBound;
    Double upBound;

    public ValueInBound(Double downBound, Double upBound) {
        this.downBound = downBound;
        this.upBound = upBound;
    }

    /**
     * check that value at bounds
     *
     * @param value - value that checked
     * @return - true at bounds, false out of bounds
     */
    public Boolean valueInBound(Double value) {
        if (downBound == null && upBound == null) {
            return true;
        }
        if (value != null) {
            if (downBound != null && upBound != null) {
                if (downBound <= value && upBound >= value) return true;
                else return false;
            }
            if (downBound != null && upBound == null) {
                if (downBound <= value) return true;
                else return false;
            }
            if (downBound == null && upBound != null) {
                if (value <= upBound) return true;
                else return false;
            }
        } else {
            if (value == null)
                throw new NullPointerException("valueInBound value exist");
            if (downBound > upBound)
                throw new BoundValueException("down bound > up bound");
        }
        return false;
    }

    public Double getDownBound() {
        return downBound;
    }

    public void setDownBound(Double downBound) {
        this.downBound = downBound;
    }

    public Double getUpBound() {
        return upBound;
    }

    public void setUpBound(Double upBound) {
        this.upBound = upBound;
    }

    /**
     * Value bound exception
     */
    public class BoundValueException extends RuntimeException {
        /**
         * Constructs a new exception with {@code null} as its detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         */
        public BoundValueException() {
        }

        /**
         * Constructs a new exception with the specified detail message.  The
         * cause is not initialized, and may subsequently be initialized by
         * a call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public BoundValueException(String message) {
            super(message);
        }
    }
}
