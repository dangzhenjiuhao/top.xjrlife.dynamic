package top.xjrlife.dynamic.pojo;

import java.io.Serializable;
import java.util.Date;

public class Power implements Serializable {
    private Integer id;

    private String powerName;

    private String powerCode;

    private String powerUrl;

    private Integer isMenu;

    private Integer isMenuParent;

    private Integer isMenuPid;

    private Integer isAvailable;

    private Integer sort;

    private Date createTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }

    public String getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode == null ? null : powerCode.trim();
    }

    public String getPowerUrl() {
        return powerUrl;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl == null ? null : powerUrl.trim();
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsMenuParent() {
        return isMenuParent;
    }

    public void setIsMenuParent(Integer isMenuParent) {
        this.isMenuParent = isMenuParent;
    }

    public Integer getIsMenuPid() {
        return isMenuPid;
    }

    public void setIsMenuPid(Integer isMenuPid) {
        this.isMenuPid = isMenuPid;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
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
        this.remark = remark == null ? null : remark.trim();
    }
}