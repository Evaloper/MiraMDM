package ng.org.mirabilia.mdm.domain.enums;

public enum OperationLogType {

    REVOKE_POLICY("revoke policy"),
    DEVICE_LOCATION("device location"),
    APPLICATION_LIST("application list"),
    DEVICE_INFO("device info");

    private final String value;

    OperationLogType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
