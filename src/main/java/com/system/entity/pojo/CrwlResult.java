package com.system.entity.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "t_result")
public class CrwlResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //支持回写的uuid
    private String id;

    /**
     * 关键词
     */
    private String gjc;

    /**
     */
    private String url;
    
    private String title;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

  
    private String userName;

    /**
     * 包含关键词的内容
     */
    private byte[] contents;
    
    @Transient
    private String content;
    
    private String type;

    private static final long serialVersionUID = 1L;

    public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
     * 获取关键词
     *
     * @return keys - 关键词
     */
 
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

    public String getGjc() {
		return gjc;
	}

	public void setGjc(String gjc) {
		this.gjc = gjc;
	}

	/**
     * 获取从哪里爬到的
     *
     * @return url - 从哪里爬到的
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置从哪里爬到的
     *
     * @param url 从哪里爬到的
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

   

    /**
     * 获取包含关键词的内容
     *
     * @return contents - 包含关键词的内容
     */
    public byte[] getContents() {
        return contents;
    }

    /**
     * 设置包含关键词的内容
     *
     * @param contents 包含关键词的内容
     */
    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", createTime=").append(createTime);
        sb.append(", contents=").append(contents);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}