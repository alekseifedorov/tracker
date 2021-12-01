package my.assignment.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import my.assignment.entity.enumeration.BugPriority;
import my.assignment.entity.enumeration.BugStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "BUG")
@FieldNameConstants
public class BugEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private BugStatus status;

    @Enumerated(EnumType.STRING)
    private BugPriority priority;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperEntity developer;

    @CreatedDate
    private ZonedDateTime createdDate;
}
