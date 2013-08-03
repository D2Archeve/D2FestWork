package org.d2fest.d2archive.domain;

import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * @author mh
 * @since 12.03.11
 */
@NodeEntity
public class User {
	
    @GraphId
    private Long nodeId;
    
    /** 아이디 */
    @Indexed(unique=true)
    private Long id;
    
    /** 패스워드 */
    private String passWord;
    
    /** 주소 */
    private String address;
    
    /** 메일 */
    private String mail;
    
    /** 전화번호 */
    private String telephone;

	public User(Long nodeId, Long id, String passWord, String address,
			String mail, String telephone) {
		super();
		this.nodeId = nodeId;
		this.id = id;
		this.passWord = passWord;
		this.address = address;
		this.mail = mail;
		this.telephone = telephone;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}

