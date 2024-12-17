package ng.org.mirabilia.mdm.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ng.org.mirabilia.mdm.domain.enums.DeviceStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String model;
    private String vendor;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_status")
    private DeviceStatus deviceStatus;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "os_build_date")
    private Long osBuildDate;

    @Column(name = "battery_level")
    private int batteryLevel;

    @Column(name = "internal_total_memory")
    private double internalTotalMemory;

    @Column(name = "internal_available_memory")
    private double internalAvailableMemory;

    @Column(name = "external_total_memory")
    private double externalTotalMemory;

    @Column(name = "external_available_memory")
    private double externalAvailableMemory;

    @Column(name = "connection_type")
    private String connectionType;

    private String ssid;

    @Column(name = "cpu_usage")
    private int cpuUsage;

    @Column(name = "total_ram_memory")
    private long totalRamMemory;

    @Column(name = "available_ram_memory")
    private long availableRamMemory;

    @Column(name = "is_plugged_in")
    private boolean pluggedIn;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "is_encryption_enabled")
    private boolean encryptionEnabled;

    @Column(name = "is_passcode_enabled")
    private boolean passcodeEnabled;

    @Column(name = "operator")
    private String operator;

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Group> group = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registeredAt", nullable = false, updatable = false)
    private Date registeredAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;
}
