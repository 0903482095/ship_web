package model;

import java.io.Serializable;
import java.util.Date;

public class UserOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer createdBy;
	private Float lat1;
	private Float lng1;
	private Float lat2;
	private Float lng2;
	private String content;
	private Date createdDate;
	private Long fee;
	private Integer status;
	private String fromAdd;
	private String toAdd;
	private Float lat3;
	private Float lng3;
	private Integer shipperId;
	public UserOrder() {
		super();
	}

	public UserOrder(Integer id, Integer createdBy, Float lat1, Float lng1, Float lat2, Float lng2, String content,
			Date createdDate, Long fee, Integer status, String fromAdd, String toAdd, Float lat3, Float lng3) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.lat1 = lat1;
		this.lng1 = lng1;
		this.lat2 = lat2;
		this.lng2 = lng2;
		this.content = content;
		this.createdDate = createdDate;
		this.fee = fee;
		this.status = status;
		this.fromAdd = fromAdd;
		this.toAdd = toAdd;
		this.lat3 = lat3;
		this.lng3 = lng3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Float getLat1() {
		return lat1;
	}

	public void setLat1(Float lat1) {
		this.lat1 = lat1;
	}

	public Float getLng1() {
		return lng1;
	}

	public void setLng1(Float lng1) {
		this.lng1 = lng1;
	}

	public Float getLat2() {
		return lat2;
	}

	public void setLat2(Float lat2) {
		this.lat2 = lat2;
	}

	public Float getLng2() {
		return lng2;
	}

	public void setLng2(Float lng2) {
		this.lng2 = lng2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFromAdd() {
		return fromAdd;
	}

	public void setFromAdd(String fromAdd) {
		this.fromAdd = fromAdd;
	}

	public String getToAdd() {
		return toAdd;
	}

	public void setToAdd(String toAdd) {
		this.toAdd = toAdd;
	}

	public Float getLat3() {
		return lat3;
	}

	public void setLat3(Float lat3) {
		this.lat3 = lat3;
	}

	public Float getLng3() {
		return lng3;
	}

	public void setLng3(Float lng3) {
		this.lng3 = lng3;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

}
