package fr.kolgna_sec.portfolio_api.role.mappers;

import fr.kolgna_sec.portfolio_api.role.bean.Role;
import fr.kolgna_sec.portfolio_api.role.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO fromRole(Role role);

    Role fromRoleDTO(RoleDTO roleDTO);
}
