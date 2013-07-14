package com.br.brazilpanels.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="form1")
public class ResultBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Q1_1")
	private Integer Q1_1;
	
	@Column(name="Q1_2")
	private Integer Q1_2;
	
	@Column(name="Q1_3")
	private Integer Q1_3;
	
	@Column(name="Q1_4")
	private Integer Q1_4;
	
	@Column(name="Q1_5")
	private Integer Q1_5;
	
	@Column(name="Q1_6")
	private Integer Q1_6;
	
	@Column(name="Q1_7")
	private Integer Q1_7;
	
	@Column(name="Q1_8")
	private Integer Q1_8;
	
	@Column(name="Q1_9")
	private Integer Q1_9;
	
	@Column(name="Q1_Outros")
	private String Q1_Outros;
	
	@Column(name="Q2")
	private Integer Q2;
	
	@Column(name="Q3")
	private Integer Q3;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getQ1_1() {
		return Q1_1;
	}
	public void setQ1_1(Integer q1_1) {
		Q1_1 = q1_1;
	}
	public Integer getQ1_2() {
		return Q1_2;
	}
	public void setQ1_2(Integer q1_2) {
		Q1_2 = q1_2;
	}
	public Integer getQ1_3() {
		return Q1_3;
	}
	public void setQ1_3(Integer q1_3) {
		Q1_3 = q1_3;
	}
	public Integer getQ1_4() {
		return Q1_4;
	}
	public void setQ1_4(Integer q1_4) {
		Q1_4 = q1_4;
	}
	public Integer getQ1_5() {
		return Q1_5;
	}
	public void setQ1_5(Integer q1_5) {
		Q1_5 = q1_5;
	}
	public Integer getQ1_6() {
		return Q1_6;
	}
	public void setQ1_6(Integer q1_6) {
		Q1_6 = q1_6;
	}
	public Integer getQ1_7() {
		return Q1_7;
	}
	public void setQ1_7(Integer q1_7) {
		Q1_7 = q1_7;
	}
	public Integer getQ1_8() {
		return Q1_8;
	}
	public void setQ1_8(Integer q1_8) {
		Q1_8 = q1_8;
	}
	public Integer getQ1_9() {
		return Q1_9;
	}
	public void setQ1_9(Integer q1_9) {
		Q1_9 = q1_9;
	}
	public String getQ1_Outros() {
		return Q1_Outros;
	}
	public void setQ1_Outros(String q1_Outros) {
		Q1_Outros = q1_Outros;
	}
	public Integer getQ2() {
		return Q2;
	}
	public void setQ2(Integer q2) {
		Q2 = q2;
	}
	public Integer getQ3() {
		return Q3;
	}
	public void setQ3(Integer q3) {
		Q3 = q3;
	}

}
