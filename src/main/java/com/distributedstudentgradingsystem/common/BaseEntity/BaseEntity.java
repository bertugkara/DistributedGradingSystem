package com.distributedstudentgradingsystem.common.BaseEntity;

import lombok.Getter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @CreatedDate
    @Column(updatable = false , nullable = false )
    private Instant createdDate;

    @LastModifiedDate
    @Column(updatable = false)
    private Instant lastModifiedDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof HibernateProxy) {
            obj = ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        if (this.id == null) {
            return false;
        } else {
            return this.id.equals(other.id);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
