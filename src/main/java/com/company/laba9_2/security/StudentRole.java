package com.company.laba9_2.security;

import com.company.laba9_2.entity.Student;
import com.company.laba9_2.entity.ElectiveCourse;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Student Role", code = "student-role")
public interface StudentRole {

    @EntityPolicy(entityClass = Student.class, actions = {EntityPolicyAction.READ})
    @EntityPolicy(entityClass = ElectiveCourse.class, actions = {EntityPolicyAction.READ})
    void entityPolicies();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = ElectiveCourse.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void attributePolicies();

    @ViewPolicy(viewIds = {
            "Student.detail",              // просмотр данных о себе
            "ElectiveCourse.list",         // список элективов
            "ElectiveCourse.detail"        // просмотр деталей курса
    })
    @MenuPolicy(menuIds = {
            "ElectiveCourse.list"
    })
    void uiAccess();
}
