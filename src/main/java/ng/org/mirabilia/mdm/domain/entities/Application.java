package ng.org.mirabilia.mdm.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_version")
    private String applicationVersion;

    @Column(name = "device_id")
    private Long deviceId;
}
