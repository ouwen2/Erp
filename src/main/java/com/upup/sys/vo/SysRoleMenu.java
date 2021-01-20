package com.upup.sys.vo;

import com.upup.sys.model.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysRoleMenu extends SysMenu {
    private Integer roleUUID;
    private String menuId;
    public SysRoleMenu(){
    }
    public SysRoleMenu(Integer roleUUID){
        this.roleUUID = roleUUID;
    }
}
