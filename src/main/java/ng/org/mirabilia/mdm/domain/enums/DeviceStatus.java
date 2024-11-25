package ng.org.mirabilia.mdm.domain.enums;

public enum DeviceStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    DeviceStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
