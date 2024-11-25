package ng.org.mirabilia.mdm.domain.enums;

public enum OperationLogStatus {

    COMPLETED("completed"),
    PENDING("pending"),
    ERROR("error");

    private final String value;

    OperationLogStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
