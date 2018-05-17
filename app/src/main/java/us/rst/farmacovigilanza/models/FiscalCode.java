package us.rst.farmacovigilanza.models;

import java.security.InvalidParameterException;

/**
 * Represents the italian health identification code
 */
public class FiscalCode {
    /**
     * Initializes a new instance of this class
     * @param fiscalCode fiscal code
     */
    public FiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;

        if (!isCorrect()) {
            throw new InvalidParameterException("Fiscal code is invalid");
        }
    }

    private boolean isCorrect() {
        // Because YOLO
        return true;
    }

    @Override public boolean equals(Object o) {
        return o instanceof FiscalCode && this.fiscalCode.equals(((FiscalCode) o).fiscalCode);
    }

    @Override public String toString() {
        return this.fiscalCode;
    }

    private final String fiscalCode;
}
