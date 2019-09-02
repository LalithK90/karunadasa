package lk.learners.karunadasa.asset.commonAsset.Enum;

public enum Designation {
    MANAGER("Manager"),
    CASHIER("Cashier"),
    DRIVER("Instructor"),
    CLERK("Clerk"),
    STUDENT("Student");

    private final String designation;

    Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
