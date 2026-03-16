package com.tai.code.entity.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name="role_id", nullable=false)
    Integer roleId;
            //role_id: 1-Admin, 2-Manager, 3-Staff, 4-Customer
    @Column(name="role_name", nullable = false, length = 50)
    String roleName;
}
