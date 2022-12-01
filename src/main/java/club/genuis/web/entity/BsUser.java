package club.genuis.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理后台用户
 * </p>
 *
 * @author cloud
 * @since 2022-11-29
 */
@TableName("bs_user")
public class BsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer roleId;

    /**
     * 真实姓名
     */
    private String name;


    /**
     * 岗位
     */
    private String position;

    /**
     * 状态 0-锁定  1-正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTm;

    @TableField(exist =  false)
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreateTm() {
        return createTm;
    }

    public void setCreateTm(LocalDateTime createTm) {
        this.createTm = createTm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "BsUser{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", roleId=" + roleId +
            ", name=" + name +
            ", position=" + position +
            ", status=" + status +
            ", createTm=" + createTm +
        "}";
    }
}
