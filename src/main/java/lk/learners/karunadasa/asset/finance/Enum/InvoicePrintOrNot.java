package lk.learners.karunadasa.asset.finance.Enum;

public enum InvoicePrintOrNot {
    PRINT("Required"),
    NOT("Not required");

    private final String invoicePrintOrNot;

    InvoicePrintOrNot(String invoicePrintOrNot) {
        this.invoicePrintOrNot = invoicePrintOrNot;
    }

    public String getInvoicePrintOrNot() {
        return invoicePrintOrNot;
    }
}

