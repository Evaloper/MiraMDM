package ng.org.mirabilia.mdm.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ng.org.mirabilia.mdm.domain.enums.OperationLogStatus;
import ng.org.mirabilia.mdm.domain.enums.OperationLogType;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Operation_logs")
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_log_type")
    private OperationLogType operationLogType;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_log_status")
    private OperationLogStatus operationLogStatus;

    @Column(name = "operation_date")
    private Date operationDate;

    @Column(name = "device_id")
    private Long deviceId;
}
