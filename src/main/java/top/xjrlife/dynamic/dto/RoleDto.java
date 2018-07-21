package top.xjrlife.dynamic.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 创建人：xjz
 * 创建时间：2018/7/19
 */
public class RoleDto {

    private Integer id;
    @NotNull(message = "角色名不能为空")
    @Size(min = 2, max = 30, message = "角色名长度必须大小{min},小于{max}位")
    private String roleName;
    private Integer isAvailable = 0;
    private Integer sort = 100;
    private Date createTime;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == "on"?0:1;
    }


}
