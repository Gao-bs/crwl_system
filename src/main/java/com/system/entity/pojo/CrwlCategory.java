package com.system.entity.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "t_category")
public class CrwlCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //支持回写的uuid
    private String id;

    /**
     * 分类名
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类url
     */
    @Column(name = "category_url")
    private String categoryUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;
    
    
    
    @Transient
    private String key;
    
    @Transient
    private Integer pageNum;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
     * 获取分类名
     *
     * @return category_name - 分类名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名
     *
     * @param categoryName 分类名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取分类url
     *
     * @return category_url - 分类url
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     * 设置分类url
     *
     * @param categoryUrl 分类url
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryUrl=").append(categoryUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}