package lk.learners.karunadasa.resourses.company.entity.Enum;

public enum Designation {
    MANAGER("Manager"),
    CASHIER("Cashier"),
    MLT("Medical Laboratory Technician"),
    ADMIN("Admin");

    private final String designation;

    Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
