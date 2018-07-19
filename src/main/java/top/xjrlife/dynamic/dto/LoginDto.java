package top.xjrlife.dynamic.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 创建人：xjz
 * 创建时间：2018/7/17
 */
public class LoginDto {
    @NotNull(message = "登录名不能为空")
    @Size(min = 2, max = 30, message = "用户名长度必须大小{min},小于{max}位")
    private String loginName;

    @NotNull(message = "密码不能为空")
    @Size(min = 2, max = 30, message = "密码长度必须大小{min},小于{max}位")
    private String loginPassword;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
