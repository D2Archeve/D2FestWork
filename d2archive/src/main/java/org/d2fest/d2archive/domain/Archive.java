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
public class Archive {
	
    @GraphId
    private Long nodeId;
    
    /** 아카이브식별자 */
    @Indexed(unique=true)
    private Long id;
    
    /** 제목 */
    private String title;
    
    /** 작성일자 */
    private Date createDate;
    
    /** 평점 */
    private int point;
    
    /** 수정가능여부 */
    private boolean isModifiable;
    
    /** 클론가능여부 */
    private boolean isColneable;
    
    /** 공개가능여부 */
    private boolean isPublicable;
    
    /** 수집가능여부 */
    private boolean isCollectable;
    
	@Fetch
	@RelatedTo(type = "IS_TERRITORY_OF", direction = Direction.INCOMING)
	private Set<Document> documents;
    
	public Archive(Long nodeId, Long id, String title, Date createDate,
			int point, boolean isModifiable, boolean isColneable,
			boolean isPublicable, boolean isCollectable, Set<Document> documents) {
		super();
		this.nodeId = nodeId;
		this.id = id;
		this.title = title;
		this.createDate = createDate;
		this.point = point;
		this.isModifiable = isModifiable;
		this.isColneable = isColneable;
		this.isPublicable = isPublicable;
		this.isCollectable = isCollectable;
		this.documents = documents;
	}

	public List<Document> getDocuments() {
		return new ArrayList<Document>(documents);
	}
	
	public void addDocument(Document document) {
		this.documents.add((Document) document);
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isModifiable() {
		return isModifiable;
	}

	public void setModifiable(boolean isModifiable) {
		this.isModifiable = isModifiable;
	}

	public boolean isColneable() {
		return isColneable;
	}

	public void setColneable(boolean isColneable) {
		this.isColneable = isColneable;
	}

	public boolean isPublicable() {
		return isPublicable;
	}

	public void setPublicable(boolean isPublicable) {
		this.isPublicable = isPublicable;
	}

	public boolean isCollectable() {
		return isCollectable;
	}

	public void setCollectable(boolean isCollectable) {
		this.isCollectable = isCollectable;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	
}

