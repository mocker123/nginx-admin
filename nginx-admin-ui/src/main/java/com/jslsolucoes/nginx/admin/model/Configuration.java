package com.jslsolucoes.nginx.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "configuration")
@SequenceGenerator(name = "configuration_sq", initialValue = 1, allocationSize = 1, sequenceName = "configuration_sq")
public class Configuration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_sq")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nginx")
	private Nginx nginx;

	@Column(name = "gzip")
	private Integer gzip;

	@Column(name = "max_post_size")
	private Integer maxPostSize;

	public Configuration() {

	}

	public Configuration(Long id, Integer gzip, Integer maxPostSize, Nginx nginx) {
		this.id = id;
		this.gzip = gzip;
		this.maxPostSize = maxPostSize;
		this.nginx = nginx;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nginx getNginx() {
		return nginx;
	}

	public void setNginx(Nginx nginx) {
		this.nginx = nginx;
	}

	public Integer getGzip() {
		return gzip;
	}

	public void setGzip(Integer gzip) {
		this.gzip = gzip;
	}

	public Integer getMaxPostSize() {
		return maxPostSize;
	}

	public void setMaxPostSize(Integer maxPostSize) {
		this.maxPostSize = maxPostSize;
	}

}
