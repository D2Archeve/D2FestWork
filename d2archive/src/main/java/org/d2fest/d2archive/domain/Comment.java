package org.d2fest.d2archive.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Comment {
	
    @GraphId
    private Long nodeId;
    
    /** 코멘트식별자 */
    @Indexed(unique=true)
    private Long id;
    
    /** 제목 */
    private String title;
    
    /** 본문 */
    private String content;
    
    /** 작성일자 */
    private Date createDate;
    
    

	public Comment(Long nodeId, Long id, String title, String content,
			Date createDate) {
		this.nodeId = nodeId;
		this.id = id;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}

