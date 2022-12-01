package club.genuis.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cloud
 * @since 2022-11-29
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private String email;

    private Integer schoolId;

    private Integer collegeId;

    /**
     * edu 邮箱
     */
    private String schoolEmail;

    /**
     * 绑定地址
     */
    private String ethAddr;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 背景图
     */
    private String bgImage;

    /**
     * 个人简介
     */
    private String description;

    /**
     * 上级ID
     */
    private Integer topId;

    /**
     * 邀请码
     */
    private String inviteCode;

    private String twitter;

    private String facebook;

    private String instagram;

    /**
     * 0-初始状态，1-正常
     */
    private Integer status;

    private LocalDateTime createTm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }
    public String getEthAddr() {
        return ethAddr;
    }

    public void setEthAddr(String ethAddr) {
        this.ethAddr = ethAddr;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }
    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
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

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name=" + name +
            ", password=" + password +
            ", email=" + email +
            ", schoolId=" + schoolId +
            ", collegeId=" + collegeId +
            ", schoolEmail=" + schoolEmail +
            ", ethAddr=" + ethAddr +
            ", avatar=" + avatar +
            ", bgImage=" + bgImage +
            ", description=" + description +
            ", topId=" + topId +
            ", inviteCode=" + inviteCode +
            ", twitter=" + twitter +
            ", facebook=" + facebook +
            ", instagram=" + instagram +
            ", status=" + status +
            ", createTm=" + createTm +
        "}";
    }
}
