package club.genuis.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * banner表
 * </p>
 *
 * @author cloud
 * @since 2022-11-29
 */
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 区域
     */
    private String section;

    /**
     * 跳转的类型
     */
    private String type;

    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 链接
     */
    private String link;

    private Boolean isAppLink;

    private Integer location;

    private Boolean showStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public Boolean getIsAppLink() {
        return isAppLink;
    }

    public void setIsAppLink(Boolean isAppLink) {
        this.isAppLink = isAppLink;
    }
    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "Banner{" +
            "id=" + id +
            ", section=" + section +
            ", type=" + type +
            ", title=" + title +
            ", cover=" + cover +
            ", link=" + link +
            ", isAppLink=" + isAppLink +
            ", location=" + location +
            ", showStatus=" + showStatus +
        "}";
    }
}
