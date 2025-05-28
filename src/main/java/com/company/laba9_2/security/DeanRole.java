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

@ResourceRole(name = "Dean Role", code = "dean-role")
public interface DeanRole {

    @EntityPolicy(entityClass = Student.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE, EntityPolicyAction.DELETE})
    @EntityPolicy(entityClass = ElectiveCourse.class, actions = {EntityPolicyAction.READ})
    void entityPolicies();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = ElectiveCourse.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void attributePolicies();

    @ViewPolicy(viewIds = {"Student.list", "Student.detail", "ElectiveCourse.list", "ElectiveCourse.detail"})
    @MenuPolicy(menuIds = {"Student.list", "ElectiveCourse.list"})
    void uiAccess();
}
