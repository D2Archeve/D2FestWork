package org.d2fest.d2archive.domain;

import java.util.Date;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Document {
	
    @GraphId
    private Long nodeId;
    
    /** 문서식별자 */
    @Indexed(unique=true)
    private Long id;
    
    /** 제목 */
    private String title;
    
    /** 본문 */
    private String content;
    
    /** 작성일자 */
    private Date createDate;
    
    /** 수정일자 */
    private Date modifyDate;

	@Fetch
	@RelatedTo(type = "IS_DOCUMENT_OF", direction = Direction.OUTGOING)
	private Archive archive;
	
	public Document(Long nodeId, Long id, String title, String content,
			Date createDate, Date modifyDate, Archive archive) {
		super();
		this.nodeId = nodeId;
		this.id = id;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.archive = archive;
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

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

}

