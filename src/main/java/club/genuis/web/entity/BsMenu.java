package club.genuis.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 后台菜单
 * </p>
 *
 * @author cloud
 * @since 2022-11-29
 */
@TableName("bs_menu")
public class BsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 路径
     */
    private String path;

    /**
     * 名称， 路由名称
     */
    private String name;

    /**
     * view文件路径
     */
    private String viewPath;

    private String icon;

    private Boolean keepAlive;

    /**
     * 是否显示
     */
    private Boolean showStatus;

    private Byte type;

    /**
     * 上级id
     */
    private Integer topId;

    /**
     * 所需要的角色
     */
    private String role;

    @TableField(exist = false)
    private List<BsMenu> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<BsMenu> getChildren() {
        return children;
    }

    public void setChildren(List<BsMenu> children) {
        this.children = children;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "BsMenu{" +
            "id=" + id +
            ", title=" + title +
            ", path=" + path +
            ", name=" + name +
            ", viewPath=" + viewPath +
            ", icon=" + icon +
            ", keepAlive=" + keepAlive +
            ", show=" + showStatus +
            ", type=" + type +
            ", topId=" + topId +
            ", role=" + role +
        "}";
    }
}
